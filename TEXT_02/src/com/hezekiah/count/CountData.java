package com.hezekiah.count;

import com.hezekiah.ui.MianJFrame;

public class CountData extends VariableData{
//    //伤害乘区
//    float 最大伤害=0,期望伤害=0,攻击区=1, 倍率区=1,增伤区=1,反应区=1,暴伤区=1,暴击区=1,防御区=1,抗性区=1;
//    //攻击乘区
//    float 基础攻击=0,额外攻击=0,百分比攻击=0,角色基础攻击=0,武器基础攻击=0,武器百分比攻击=0,圣遗物百分比攻击=0,其他百分比攻击=0,圣遗物数值攻击=0,其他攻击=0;
//    //倍率乘区
//    float 技能倍率=1;
//    //增伤乘区
//    float 增伤=1;
//    //反应乘区
//
//    //暴伤乘区
//
//    //暴击乘区
//
//    //防御乘区
//
//    //抗性乘区
//    float 抗性;
//
//    public void set最大伤害(float 最大伤害) {
//        this.最大伤害 = 攻击区 * 倍率区 * 增伤区 * 反应区 * 暴伤区 * 防御区 * 抗性区;
//    }
//
//    public void set期望伤害(float 期望伤害) {
//        this.期望伤害 = 攻击区 * 倍率区 * 增伤区 * 反应区 * 暴伤区 * 暴击区 * 防御区 * 抗性区;
//    }


//    基础攻击 = 角色基础攻击 + 武器基础攻击;
//    额外攻击 = (基础攻击 * 百分比攻击) + 圣遗物数值攻击 + 其他攻击
//    百分比攻击 = 武器百分比攻击 + 圣遗物百分比攻击 + 其他百分比攻击
//    攻击区 =  (基础攻击) + (额外攻击)

    public CountData(){
        get期望伤害();
    }


    public float get期望伤害() {
        攻击区 = MianJFrame.basicattr[1];
        倍率区 = MianJFrame.addattr[1];
        增伤区 = MianJFrame.addattr[2]/100 + 1;
        反应区 = 1;
        暴伤区 = MianJFrame.advattr[1]/100 + 1;
        暴击区 = MianJFrame.advattr[0]/100 + 1;
        防御区 = (MianJFrame.addattr[0] + 100) / ((1 - MianJFrame.enattr[3]/100) * (1 + MianJFrame.enattr[2]/100) * (MianJFrame.enattr[0] + 100) + (MianJFrame.addattr[0] + 100));
        if (MianJFrame.enattr[1]/100 > 0.75){
            抗性区 = 1 / (1 + 4 * (MianJFrame.enattr[1]/100));
        }
        else if (MianJFrame.enattr[1]/100 < 0){
            抗性区 = 1 - (MianJFrame.enattr[1]/100);
        }
        else {
            抗性区 = 1 - (MianJFrame.enattr[1]/100) / 2;
        }

        期望伤害 = 攻击区 * 倍率区 * 增伤区 * 反应区 * 暴伤区 * 暴击区 * 防御区 * 抗性区;
        System.out.print('\n' + " " + basicattr[1]);
        return 期望伤害;
    }


//    public float set攻击区(float 攻击区) {
//        return 攻击区 =  basicattr[1];
//    }
//
//    public float set倍率区(float 倍率区){
//        return 倍率区 = MianJFrame.addattr[1];
//    }
//
//    public float set增伤区(float 增伤区) {
//        return 增伤区 = MianJFrame.addattr[2]/100 + 1;
//    }
//
//    public float set反应区(float 反应区) {
//        return 反应区 = 反应区;
//    }
//
//    public float set暴伤区(float 暴伤区) {
//        return 暴伤区 = MianJFrame.advattr[1]/100 + 1;
//    }
//
//    public float set暴击区(float 暴击区) {
//        return 暴击区 = MianJFrame.advattr[0]/100 + 1;
//    }
//
//    public float set防御区(float 防御区) {
//        return 防御区 = (MianJFrame.addattr[0] + 100) / ((1 - MianJFrame.enattr[3]) * (1 + MianJFrame.enattr[2]) * (MianJFrame.enattr[0] + 100) + (MianJFrame.addattr[0] + 100));
//    }
//
//    public float set抗性区(float 抗性区) {
//        if (MianJFrame.enattr[1]/100 > 0.75){
//            return 抗性区 = 1 / (1 + 4 * (MianJFrame.enattr[1]/100));
//        }
//        else if (MianJFrame.enattr[1]/100 < 0){
//            return 抗性区 = 1 - (MianJFrame.enattr[1]/100);
//        }
//        else {
//            return 抗性区 = 1 - (MianJFrame.enattr[1]/100) / 2;
//        }
//    }
}
