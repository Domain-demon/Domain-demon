package com.hezekiah.function;

import javax.swing.*;
import java.awt.*;

import static com.hezekiah.function.TextColor.TextColor1;
import static com.hezekiah.function.TextColor.TextColor2;
import static com.hezekiah.function.TextFieldPlaceholderSetter.setPlaceholders;
import static com.hezekiah.function.TextModule.text2Fields;

public class TextAttribute extends JFrame{
    int sum = 0;

    public JTextField[] attribute(int x, int y, int w, int h, int interval, int amount, int order, JPanel[] jPanels, String[] MulZone, String[] MulZone0) {
        int flag = 0;
        JTextField[] jTextFields = text2Fields(amount);

        // 创建标签文本框
        CreateTextLabel(jPanels, order, amount, x, y, w, h, interval, MulZone0);

        // 创建属性输入区
        for (int i = 0; i < jTextFields.length; i++) {
            JPanels(jPanels, order, TextColor2, i * w + x, y, w, h);

            // 创建属性文本框
            JLabel label = getJLabel(MulZone[flag]);
            jPanels[order].add(label, BorderLayout.NORTH);

            // 创建一个文本字段
            jTextFields[flag] = new JTextField(MulZone[flag],5);
            // 将文本字段添加到面板
            jPanels[order].add(jTextFields[flag], BorderLayout.SOUTH);

            this.add(jPanels[order]);

            flag++;
        }
        setPlaceholders(jTextFields, MulZone);
        return jTextFields;
    }


    private void CreateTextLabel(JPanel[] jPanels, int order, int amount, int x, int y, int w, int h, int interval, String[] MulZone0) {
        JPanels(jPanels, order, TextColor1, x,y - 20,amount * w + (amount-1) * interval,h/2);
        JLabel jLabel = getJLabel(MulZone0[sum]);
        jPanels[order].add(jLabel);
        this.add(jPanels[order]);
        sum++;
    }

    private static JLabel getJLabel(String MulZone) {
        JLabel label = new JLabel(MulZone);
        label.setHorizontalAlignment(SwingConstants.CENTER); // 水平居中
        label.setVerticalAlignment(SwingConstants.CENTER);    // 垂直居中（但通常对于JLabel，垂直居中需要配合布局管理器）
        return label;
    }

    private static void JPanels(JPanel[] jPanels, int order, Color textColor ,int x,int y, int w, int h) {
        // 创建面板放置组件
        jPanels[order] = new JPanel();
        // 设置面板属性
        jPanels[order].setLayout(new BorderLayout());
        jPanels[order].setBounds(x, y, w, h);
        jPanels[order].setBackground(textColor);
    }




//    private void basic_attribute() {
//        int num1 = 0, num2 = 100, num3 = 4;
//        jTextFields = text2Fields(num3);
//
//        // 创建标签文本框
//        jPanels_1[1] = new JPanel();
//        jPanels_1[1].setBounds(  num2,30,400,20);
//        jPanels_1[1].setBackground(TextColor1);
//        JLabel jLabel = new JLabel("基础属性");
//        jLabel.setHorizontalAlignment(SwingConstants.CENTER); // 水平居中
//        jLabel.setVerticalAlignment(SwingConstants.CENTER);    // 垂直居中（但通常对于JLabel，垂直居中需要配合布局管理器）
//        jPanels_1[1].add(jLabel);
//        this.add(jPanels_1[1]);
//
//        // 创建属性输入区
//        for (int i = 0; i < jTextFields.length; i++) {
//            // 创建面板放置组件
//            jPanels_1[0] = new JPanel();
//            // 设置面板属性
//            jPanels_1[0].setLayout(new  BorderLayout());
//            jPanels_1[0].setBounds(  i * 100 + num2,50,100,40);
//            jPanels_1[0].setBackground(TextColor2);
//
//            // 创建属性文本框
//            JLabel label = new JLabel(MulZone1[num1]);
//            label.setHorizontalAlignment(SwingConstants.CENTER); // 水平居中
//            label.setVerticalAlignment(SwingConstants.CENTER);    // 垂直居中（但通常对于JLabel，垂直居中需要配合布局管理器）
//            jPanels_1[0].add(label, BorderLayout.NORTH);
//
//            // 创建一个文本字段
//            jTextFields[num1] = new JTextField(MulZone1[num1],5);
//            // 将文本字段添加到面板
//            jPanels_1[0].add(jTextFields[num1], BorderLayout.SOUTH);
//
//            this.add(jPanels_1[0]);
//
//            num1++;
//        }
//        setPlaceholders(jTextFields, MulZone1);
//    }



}
