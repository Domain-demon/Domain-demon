package com.hezekiah.demo;

import java.text.NumberFormat;
import java.util.Scanner;

public class GenshinImpactDamageCalculator {
    // 反应系数配置
    private static final double[] AMPLIFY_FACTORS = {1.5, 2.0, 1.5, 2.0}; // 火蒸,水蒸,冰融,火融
    private static final double[] CATALYZE_FACTORS = {1.15, 1.25};       // 超激化,蔓激化
    private static final double[] TRANSFORM_FACTORS = {0.6, 0.25, 3.0, 2.75, 1.5, 2.0, 2.0, 3.0, 3.0};

    // 等级基础系数 (1-90级)
    private static final double[] LEVEL_BASE = { /* 用户提供的数组数据 */};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入角色属性
        GameCharacter character = inputCharacter(scanner);

        // 输入敌人属性
        Enemy enemy = inputEnemy(scanner);

        // 执行计算
        DamageResult result = new DamageCalculator(character, enemy).calculate();

        // 显示结果
        printResults(result);

        scanner.close();
    }

    // 角色属性输入
    private static GameCharacter inputCharacter(Scanner sc) {
        System.out.println("=== 角色属性输入 ===");
        return new GameCharacter(
                getInput(sc, "基础攻击力", 1000.0),
                getInput(sc, "技能倍率(%)", 200.0),
                getInput(sc, "伤害加成(%)", 0.0),
                Math.min(getInput(sc, "暴击率(%)", 5.0), 100.0),
                getInput(sc, "暴击伤害(%)", 50.0),
                getInput(sc, "元素精通", 0.0),
                (int) getInput(sc, "角色等级", 90.0)
        );
    }

    // 敌人属性输入
    private static Enemy inputEnemy(Scanner sc) {
        System.out.println("\n=== 敌人属性输入 ===");
        return new Enemy(
                (int) getInput(sc, "敌人等级", 90.0),
                getInput(sc, "防御减免(%)", 0.0),
                getInput(sc, "防御穿透(%)", 0.0),
                getInput(sc, "元素抗性(%)", 10.0)
        );
    }

    private static double getInput(Scanner sc, String prompt, double defaultValue) {
        System.out.printf("%s (默认 %.1f): ", prompt, defaultValue);
        try {
            return Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    // 结果输出
    private static void printResults(DamageResult result) {
        System.out.println("\n=== 伤害计算结果 ===");
        System.out.println("期望伤害: " + result.nf.format(result.expectedDamage));
        System.out.println("暴击伤害: " + result.nf.format(result.critDamage));
        System.out.println("非暴击伤害: " + result.nf.format(result.nonCritDamage));

        System.out.println("\n[增幅反应]");
        System.out.println("火蒸发: " + result.nf.format(result.amplifyDamages[0]));
        System.out.println("水蒸发: " + result.nf.format(result.amplifyDamages[1]));
        System.out.println("冰融化: " + result.nf.format(result.amplifyDamages[2]));
        System.out.println("火融化: " + result.nf.format(result.amplifyDamages[3]));

        System.out.println("\n[激化反应]");
        System.out.println("超激化: " + result.nf.format(result.catalyzeDamages[0]));
        System.out.println("蔓激化: " + result.nf.format(result.catalyzeDamages[1]));

        System.out.println("\n[聚变反应]");
        System.out.println("超载: " + result.nf.format(result.transformDamages[3]));
        System.out.println("感电: " + result.nf.format(result.transformDamages[5]));
        System.out.println("烈绽放: " + result.nf.format(result.transformDamages[7]));
    }

    // 伤害计算核心类
    static class DamageCalculator {
        final GameCharacter character;
        final Enemy enemy;

        public DamageCalculator(GameCharacter character, Enemy enemy) {
            this.character = character;
            this.enemy = enemy;
            validateLevel();
        }

        public DamageResult calculate() {
            double baseDamage = calculateBaseDamage();
            return new DamageResult(
                    calculateExpectedDamage(baseDamage),
                    calculateCriticalDamage(baseDamage),
                    baseDamage,
                    calculateAmplifyDamage(baseDamage),
                    calculateCatalyzeDamage(),
                    calculateTransformDamage()
            );
        }

        // 基础伤害计算
        private double calculateBaseDamage() {
            return character.attack
                    * (character.skillMultiplier / 100.0)
                    * (1 + character.damageBonus / 100.0)
                    * getDefenseMultiplier()
                    * getResistanceMultiplier();
        }

        // 期望伤害（暴击期望）
        private double calculateExpectedDamage(double baseDamage) {
            double critRate = character.critRate / 100.0;
            double critDmg = 1 + character.critDamage / 100.0;
            return baseDamage * (critRate * critDmg + (1 - critRate));
        }

        // 暴击伤害
        private double calculateCriticalDamage(double baseDamage) {
            return baseDamage * (1 + character.critDamage / 100.0);
        }

        // 防御区计算
        private double getDefenseMultiplier() {
            double charLevelTerm = character.level + 100;
            double defenseReduce = 1 - enemy.defenseReduce / 100.0;
            double defenseIgnore = 1 - enemy.defenseIgnore / 100.0;
            double denominator = defenseReduce * defenseIgnore * (enemy.level + 100) + charLevelTerm;
            return charLevelTerm / denominator;
        }

        // 抗性区计算
        private double getResistanceMultiplier() {
            double res = enemy.elementalResist / 100.0;
            return res > 0.75 ? 1 / (1 + 4 * res) :
                    res < 0 ? 1 - res :
                            1 - res / 2;
        }

        // 增幅反应计算
        private double[] calculateAmplifyDamage(double baseDamage) {
            double masteryBonus = 2.78 * (character.mastery / (character.mastery + 1400));
            double[] damages = new double[AMPLIFY_FACTORS.length];
            for (int i = 0; i < damages.length; i++) {
                damages[i] = baseDamage * AMPLIFY_FACTORS[i]
                        * (1 + masteryBonus + character.reactionBonus)
                        * (1 + character.critDamage / 100.0);
            }
            return damages;
        }

        // 激化反应计算
        private double[] calculateCatalyzeDamage() {
            double masteryBonus = 5 * (character.mastery / (character.mastery + 1200));
            int levelIndex = Math.min(character.level - 1, LEVEL_BASE.length - 1);
            double[] damages = new double[CATALYZE_FACTORS.length];

            for (int i = 0; i < damages.length; i++) {
                double catalyzeValue = LEVEL_BASE[levelIndex]
                        * CATALYZE_FACTORS[i]
                        * (1 + masteryBonus + character.reactionBonus);

                damages[i] = (character.attack * (character.skillMultiplier / 100.0) + catalyzeValue)
                        * (1 + character.damageBonus / 100.0)
                        * getDefenseMultiplier()
                        * getResistanceMultiplier();
            }
            return damages;
        }

        // 聚变反应计算
        private double[] calculateTransformDamage() {
            double masteryBonus = 16 * (character.mastery / (character.mastery + 2000));
            int levelIndex = Math.min(character.level - 1, LEVEL_BASE.length - 1);
            double[] damages = new double[TRANSFORM_FACTORS.length];

            for (int i = 0; i < damages.length; i++) {
                damages[i] = LEVEL_BASE[levelIndex]
                        * TRANSFORM_FACTORS[i]
                        * (1 + masteryBonus + character.reactionBonus)
                        * getResistanceMultiplier();
            }
            return damages;
        }

        private void validateLevel() {
            if (character.level < 1 || character.level > 90) {
                throw new IllegalArgumentException("角色等级必须在1-90之间");
            }
        }
    }

    // 数据实体类
    static class GameCharacter {
        final double attack;          // 攻击力
        final double skillMultiplier; // 技能倍率%
        final double damageBonus;    // 伤害加成%
        final double critRate;       // 暴击率%
        final double critDamage;     // 暴击伤害%
        final double mastery;        // 元素精通
        final int level;             // 角色等级
        double reactionBonus = 0;    // 反应加成%

        // 构造方法
        public GameCharacter(double attack, double skillMultiplier, double damageBonus,
                             double critRate, double critDamage, double mastery, int level) {
            this.attack = attack;
            this.skillMultiplier = skillMultiplier;
            this.damageBonus = damageBonus;
            this.critRate = Math.min(critRate, 100);
            this.critDamage = critDamage;
            this.mastery = mastery;
            this.level = level;
        }
    }

    static class Enemy {
        final int level;             // 敌人等级
        final double defenseReduce; // 防御减免%
        final double defenseIgnore; // 防御穿透%
        final double elementalResist;// 元素抗性%

        public Enemy(int level, double defenseReduce, double defenseIgnore, double elementalResist) {
            this.level = level;
            this.defenseReduce = defenseReduce;
            this.defenseIgnore = defenseIgnore;
            this.elementalResist = elementalResist;
        }
    }

    // 结果封装类
    static class DamageResult {
        final NumberFormat nf = NumberFormat.getInstance();

        final double expectedDamage;   // 期望伤害
        final double critDamage;      // 暴击伤害
        final double nonCritDamage;   // 非暴击伤害
        final double[] amplifyDamages;// 四种增幅反应
        final double[] catalyzeDamages;// 两种激化
        final double[] transformDamages;// 九种聚变

        public DamageResult(double expected, double crit, double nonCrit,
                            double[] amplify, double[] catalyze, double[] transform) {
            nf.setMaximumFractionDigits(2);
            this.expectedDamage = expected;
            this.critDamage = crit;
            this.nonCritDamage = nonCrit;
            this.amplifyDamages = amplify;
            this.catalyzeDamages = catalyze;
            this.transformDamages = transform;
        }
    }
}