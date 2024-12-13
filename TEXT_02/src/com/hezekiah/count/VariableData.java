package com.hezekiah.count;

import javax.swing.*;

public class VariableData extends JFrame {
    public JPanel[] jPanels_1 = new JPanel[30];
    public JButton jButtons = new JButton();

    //伤害乘区
    public float 最大伤害;
    public static float 期望伤害;
    public static float 攻击区;
    public static float 倍率区;
    public static float 增伤区;
    public static float 反应区;
    public static float 暴伤区;
    public static float 暴击区;
    public static float 防御区;
    public static float 抗性区;


    //    String[] MulZone = {"攻击区", "倍率区","增伤区","反应区","暴伤区","暴击区","防御区","抗性区"};
    public String[] MulZone0 = {"基础属性", "进阶属性","加成类","怪物面板","伤害乘区"};
    public String[] MulZone1 = {"生命", "攻击","防御","元素精通"};
    public String[] MulZone2 = {"暴击率","暴击伤害"};
    public String[] MulZone3 = {"等级", "技能倍率","伤害加成","反应系数"};
    public String[] MulZone4 = {"等级", "抗性","减防","无视防御"};
    public String[] MulZone5 = {"攻击区", "倍率区", "增伤区", "反应区", "暴伤区", "暴击区", "防御区", "抗性区"};


    public static float[] basicattr = new float[4];
    public static float[] advattr = new float[2];
    public static float[] addattr = new float[4];
    public static float[] enattr = new float[4];


    public JTextField[] jTextFields_1, jTextFields_2, jTextFields_3, jTextFields_4, jTextFields_5;

}
