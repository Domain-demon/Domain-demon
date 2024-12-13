package com.hezekiah.count;

import com.hezekiah.ui.MianJFrame;

public class CountData extends VariableData{

    public static double get期望伤害() {
        return VariableData.期望伤害 = get攻击(VariableData.攻击区) * get倍率(VariableData.倍率区) *
                get增伤(VariableData.增伤区) * get反应(VariableData.反应区) *
                get暴伤(VariableData.暴伤区) * get暴击(VariableData.暴击区) *
                get防御(VariableData.防御区) * get抗性(VariableData.抗性区);
    }

    public static double get暴击伤害() {
        return VariableData.暴击伤害 = get攻击(VariableData.攻击区) * get倍率(VariableData.倍率区) *
                get增伤(VariableData.增伤区) * get反应(VariableData.反应区) *
                get暴伤(VariableData.暴伤区) *
                get防御(VariableData.防御区) * get抗性(VariableData.抗性区);
    }

    public static double get不暴击伤害() {
        return VariableData.不暴击伤害 = get攻击(VariableData.攻击区) * get倍率(VariableData.倍率区) *
                get增伤(VariableData.增伤区) * get反应(VariableData.反应区) *
                get防御(VariableData.防御区) * get抗性(VariableData.抗性区);
    }

    public static double get抗性(double RES) {
        if (MianJFrame.enattr[1]/100 > 0.75){
            return RES = 1 / (1 + 4 * (MianJFrame.enattr[1]/100));
        }
        else if (MianJFrame.enattr[1]/100 < 0){
            return RES = 1 - (MianJFrame.enattr[1]/100);
        }
        else {
            return RES = 1 - (MianJFrame.enattr[1]/100) / 2;
        }
    }

    public static double get防御(double DEF) {
        return DEF = (MianJFrame.addattr[0] + 100) / ((1 - MianJFrame.enattr[3]/100) * (1 - MianJFrame.enattr[2]/100) * (MianJFrame.enattr[0] + 100) + (MianJFrame.addattr[0] + 100));
    }

    public static double get暴击(double CRT) {
        return CRT = MianJFrame.advattr[0]/100;
    }

    public static double get暴伤(double CRD) {
        return CRD = MianJFrame.advattr[1]/100 + 1;
    }

    public static double get增伤(double DBT) {
        return DBT = MianJFrame.addattr[2]/100 + 1;
    }

    public static double get倍率(double SMP) {
        return SMP = MianJFrame.addattr[1]/100;
    }

    public static double get攻击(double ATK) {
        return ATK = MianJFrame.basicattr[1];
    }




//元素反应
    //增幅反应
    private static double  get增幅精通提升(){
        return 2.78 * (basicattr[3]/(basicattr[3] + 1400));
    }
    //蒸发（Vaporize）| 融化（Melt）
    public static double [] get增幅反应(){
        double [] Amplifying = new double [增幅反应系数.length];
        for (int i = 0; i < 增幅反应系数.length; i++) {
            Amplifying[i] = (增幅反应系数[i] * (1 + get增幅精通提升() + addattr[3]));
        }
        return Amplifying;
    }
    public static double [] get增幅反应伤害(){
        double [] AmplifyingHurt = get增幅反应();
        for (int i = 0; i < 增幅反应系数.length; i++) {
            AmplifyingHurt[i] = AmplifyingHurt[i] * get暴击伤害();
        }
        return AmplifyingHurt;
    }


    //激化反应
    private static double  get激化精通提升(){
        return 5 * (basicattr[3]/(basicattr[3] + 1200));
    }
    //蔓激化（Spread）| 超激化（Aggravate）
    public static double [] get激化反应(){
        double [] Catalyze = new double [激化反应系数.length];
        for (int i = 0; i < 激化反应系数.length; i++) {
            Catalyze[i] = (激化反应系数[i] * 等级基础系数[(int) addattr[0] - 1] * (1 + get激化精通提升() + addattr[3])) ;
        }
        return Catalyze;
    }
    public static double [] get激化反应伤害(){
        double [] CatalyzeHurt = get激化反应();
        for (int i = 0; i < 激化反应系数.length; i++) {
            CatalyzeHurt[i] = (get攻击(VariableData.攻击区) * get倍率(VariableData.倍率区) + CatalyzeHurt[i]) *
                    get增伤(VariableData.增伤区) * get暴伤(VariableData.暴伤区) *
                    get防御(VariableData.防御区) * get抗性(VariableData.抗性区);
        }
        return CatalyzeHurt;
    }


    //聚变绽放反应
    private static double get聚放精通提升(){
        return 16 * (basicattr[3]/(basicattr[3] + 2000));
    }
    //扩散（Swirl）| 燃烧（Burning）| 碎冰（Shattered）| 超载（Overloaded）| 超导（Superconduct）| 感电（Electro-Charged）| 绽放（Bloom）| 烈绽放（Burgeon）| 超绽放（Hyperbloom）
    public static double [] get聚变反应(){
        double [] Transformative = new double [聚变反应系数.length];
        for (int i = 0; i < 聚变反应系数.length; i++) {
            Transformative[i] = (聚变反应系数[i] * 等级基础系数[(int) addattr[0] - 1] * (1 + get聚放精通提升() + addattr[3]));
        }
        return Transformative;
    }
    public static double [] get聚变反应伤害(){
        double [] TransformativeHurt = get聚变反应();
        for (int i = 0; i < 聚变反应系数.length; i++) {
            TransformativeHurt[i] =  TransformativeHurt[i] * get抗性(VariableData.抗性区);
        }
        return TransformativeHurt;
    }








    // 冻结（Frozen）//结晶（Crystallize）






    public static double get反应(double EMR) {
        return EMR = 1;
    }




}
