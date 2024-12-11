package com.hezekiah.ui;

import com.hezekiah.function.TextAttribute;

import javax.swing.*;
import java.awt.event.*;


public class MianJFrame extends TextAttribute implements MouseListener {

    JPanel[] jPanels_1 = new JPanel[30];
    JButton jButtons = new JButton();


    //    String[] MulZone = {"攻击区", "倍率区","增伤区","反应区","暴伤区","暴击区","防御区","抗性区"};
    String[] MulZone0 = {"基础属性", "进阶属性","加成类","怪物面板"};
    String[] MulZone1 = {"生命...", "攻击...","防御...","元素精通..."};
    String[] MulZone2 = {"暴击率...","暴击伤害..."};
    String[] MulZone3 = {"等级...", "技能倍率...","伤害加成...","反应系数..."};
    String[] MulZone4 = {"等级...", "抗性...","减防...","无视防御..."};


    int[] basicattr = new int[4];
    int[] advattr = new int[2];
    int[] addattr = new int[4];
    int[] enattr = new int[4];


    JTextField[] jTextFields;
    JTextField[] jTextFields_1, jTextFields_2, jTextFields_3, jTextFields_4 ;
    JTextField[][] jTextFields_ = {jTextFields_1,jTextFields_2,jTextFields_3,jTextFields_4};


    public MianJFrame(){
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
        //添加鼠标监听
        this.addMouseListener(this);

    }


    private void initInput(){
        jTextFields_1 = attribute(100,80,100,40,0,4,0,jPanels_1,MulZone1,MulZone0);

        jTextFields_2 = attribute(70,200,60,40,0,2,0,jPanels_1,MulZone2,MulZone0);

        jTextFields_3 = attribute(210,200,80,40,0,4,0,jPanels_1,MulZone3,MulZone0);

        jTextFields_4 = attribute(60,320,80,40,0,4,0,jPanels_1,MulZone4,MulZone0);

    }
    

    private void initCountData(){


    }


    private void initCount(){
        jButtons = new JButton("计算");
        //设置位形
        jButtons.setBounds(400,305,150,50);
        //设置背景
        jButtons.setOpaque(false);
        //动作监听
        jButtons.addMouseListener(this);

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
                        basicattr[sum1] = Integer.parseInt(jTextFields_1[sum1++].getText().trim());
                    }
                }

                int sum2 = 0;
                for (int i = 0; i < advattr.length; i++) {
                    if (!jTextFields_2[sum2].getText().equals(MulZone2[sum1])) {
                        advattr[sum2] = Integer.parseInt(jTextFields_2[sum2++].getText().trim());
                    }
                }

                int sum3 = 0;
                for (int i = 0; i < addattr.length; i++) {
                    if (!jTextFields_3[sum3].getText().equals(MulZone3[sum1])) {
                        addattr[sum3] = Integer.parseInt(jTextFields_3[sum3++].getText().trim());
                    }
                }

                int sum4 = 0;
                for (int i = 0; i < enattr.length; i++) {
                    if (!jTextFields_4[sum4].getText().equals(MulZone4[sum1])) {
                        enattr[sum4] = Integer.parseInt(jTextFields_4[sum4++].getText().trim());
                    }
                }
            }
        });
    }





//    private void buEListener(JTextField[] jTextFields) {
//        // 为按钮添加点击事件监听器
//        jButtons.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int sum = 0;
//                for (JTextField box : jTextFields) {
//                    try {
//                        // 尝试将输入框内容解析为整数，并累加到和中
//                        sum += Integer.parseInt(box.getText().replaceAll("[^\\d]", ""));
//
//                    } catch (NumberFormatException ex) {
//                        // 如果输入框内容不是有效的整数，则忽略该输入框的值
//                        // 可以选择在这里添加错误处理逻辑，比如显示错误消息
//                    }
//                }
//                // 更新按钮文本为计算得到的和
//                jButtons.setText("和: " + sum);
//            }
//        });
//    }


    // 更新按钮文本的方法
//    void updateButtonText(String text) {
//        jButtons.setText(text);
//    }




    @Override
    public void mouseClicked(MouseEvent e) {
//        Object soure = e.getSource();
//        if(soure == jButtons){
//            jButtons.setSize(200,200);
//        }
//        System.out.println("O(∩_∩)O哒哒~");
//        System.out.println(aaa++);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
