package com.hezekiah.ui;

import com.hezekiah.count.CountData;
import com.hezekiah.count.VariableData;
import com.hezekiah.function.TextAttribute;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.hezekiah.count.CountData.*;
import static com.hezekiah.function.TextColor.TextColor4;


public class MainJFrame extends TextAttribute {

    int 随机数 = 0;

    public MainJFrame() {
        initJFrame();
        initInput();
        initCount();

        //显示
        this.setVisible(true);
    }

    private void initJFrame() {
        //宽高
        this.setSize(600,800);
        //标题
        this.setTitle("原神伤害计算器 1.0.0");
        // 设置图标
        ImageIcon icon = new ImageIcon("TEXT_01\\image\\icon\\genshin.png"); // 替换为你的图标文件路径
        this.setIconImage(icon.getImage());
        //置顶
        this.setAlwaysOnTop(true);
        //居中
        this.setLocationRelativeTo(null);
        //关闭
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认居中
        this.setLayout(null);

        // 获取JFrame的内容面板
        Container contentPane = this.getContentPane();

        // 设置内容面板的背景颜色（这将同时影响JFrame的背景颜色）
        contentPane.setBackground(new Color(252,252,252));

    }

    private void initInput(){
        jTextFields_1 = Attribute(60,80,120,40,0,4,0, jPanels,MulZone1,MulZone0);

        jTextFields_2 = Attribute(60,160,75,40,0,2,0, jPanels,MulZone2,MulZone0);

        jTextFields_3 = Attribute(240,160,75,40,0,4,0, jPanels,MulZone3,MulZone0);

        jTextFields_4 = Attribute(60,240,80,40,0,4,0, jPanels,MulZone4,MulZone0);

        jTextFields_5 = Attribute(60,320,60,40,0,8,0, jPanels,MulZone5,MulZone0);

        jTextFields_6 = Attribute(60,400,160,40,0,3,0, jPanels,MulZone6,MulZone0);

        jTextFields_7 = Damage(60,480,110,40,0,1,2,0, jPanels,MulZone7,MulZone0);

        jTextFields_8 = Damage(320,480,110,40,0,1,2,0, jPanels,MulZone8,MulZone0);

        jTextFields_9 = Damage(60,560,160,40,0,3,9,0, jPanels,MulZone9,MulZone0);



    }

    private void initCount(){
        jButtons = new JButton("计算");
        //设置位形
        jButtons.setBounds(400,225,140,50);
        //设置背景
        jButtons.setOpaque(false);

        jButtons.setBackground(TextColor4);
        jButtons.setOpaque(true);

        buEListener();

        //添加按钮
        this.getContentPane().add(jButtons);
    }

    private void buEListener() {
        // 为按钮添加点击事件监听器
        jButtons.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取输入框的内容
                int sum1 = 0;
                for (int i = 0; i < basicattr.length; i++) {
                    // 判断输入框是否有输入
                    if (!jTextFields_1[sum1].getText().equals(MulZone1[sum1])) {
                        basicattr[sum1] = Double.parseDouble(jTextFields_1[sum1].getText().trim());
                    }
                    sum1++;
                }

                int sum2 = 0;
                for (int i = 0; i < advattr.length; i++) {
                    if (!jTextFields_2[sum2].getText().equals(MulZone2[sum2])) {
                        advattr[sum2] = Double.parseDouble(jTextFields_2[sum2].getText().trim());
                    }
                    sum2++;
                }

                int sum3 = 0;
                for (int i = 0; i < addattr.length; i++) {
                    if (!jTextFields_3[sum3].getText().equals(MulZone3[sum3])) {
                        addattr[sum3] = Double.parseDouble(jTextFields_3[sum3].getText().trim());
                    }
                    sum3++;
                }

                int sum4 = 0;
                for (int i = 0; i < enattr.length; i++) {
                    if (!jTextFields_4[sum4].getText().equals(MulZone4[sum4])) {
                        enattr[sum4] = Double.parseDouble(jTextFields_4[sum4].getText().trim());
                    }
                    sum4++;
                }

                textVerify();
                jButtons.setText(String.valueOf("期望伤害：" + CountData.get期望伤害()));
                showDamage();

            }

            private void textVerify() {
                System.out.print('\n' + " " + "第" + 随机数++ + "次");

                // 打印目标数组以验证复制是否成功
                System.out.print('\n' + "基础属性：| ");
                for (double  element : basicattr) {
                    System.out.print(element + " | ");
                }
                System.out.print('\n' + "进阶属性：| ");
                for (double  element : advattr) {
                    System.out.print(element + " | ");
                }
                System.out.print('\n' + "加成属性：| ");
                for (double  element : addattr) {
                    System.out.print(element + " | ");
                }
                System.out.print('\n' + "敌人属性：| ");
                for (double  element : enattr) {
                    System.out.print(element + " | ");
                }

                System.out.print('\n');
            }
        });
    }

    private void showDamage(){
        AmplifyingDamage = CountData.get增幅反应伤害();
        CatalyzeDamage = CountData.get激化反应伤害();
        TransformativeDamage = CountData.get聚变反应伤害();
        jTextFields_5[0].setText(String.valueOf(get攻击(VariableData.攻击区)));
        jTextFields_5[1].setText(String.valueOf(get倍率(VariableData.倍率区)));
        jTextFields_5[2].setText(String.valueOf(get增伤(VariableData.增伤区)));
        jTextFields_5[3].setText(String.valueOf(get反应(VariableData.反应区)));
        jTextFields_5[4].setText(String.valueOf(get暴伤(VariableData.暴伤区)));
        jTextFields_5[5].setText(String.valueOf(get暴击(VariableData.暴击区)));
        jTextFields_5[6].setText(String.valueOf(get防御(VariableData.防御区)));
        jTextFields_5[7].setText(String.valueOf(get抗性(VariableData.抗性区)));
        jTextFields_6[0].setText(String.valueOf(CountData.get不暴击伤害()));
        jTextFields_6[1].setText(String.valueOf(CountData.get暴击伤害()));
        jTextFields_6[2].setText(String.valueOf(CountData.get期望伤害()));
        for (int i = 0; i < 增幅反应系数.length; i++) {
            jTextFields_7[i/2].setText((int) (AmplifyingDamage[i++]) + " , " + (int) AmplifyingDamage[i]);
        }
        for (int i = 0; i < 激化反应系数.length; i++) {
            jTextFields_8[i].setText(Integer.toString((int) CatalyzeDamage[i]));
        }
        for (int i = 0; i < 聚变反应系数.length; i++) {
            jTextFields_9[i].setText(Integer.toString((int) TransformativeDamage[i]));
        }

    }


}
