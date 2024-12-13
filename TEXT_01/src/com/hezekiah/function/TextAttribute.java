package com.hezekiah.function;

import com.hezekiah.count.VariableData;

import javax.swing.*;
import java.awt.*;

import static com.hezekiah.function.TextColor.*;
import static com.hezekiah.function.TextFieldPlaceholderSetter.setPlaceholders;
import static com.hezekiah.function.TextModule.text2Fields;

public class TextAttribute extends VariableData {
    int sum = 0;

    public JTextField[] Attribute(int x, int y, int w, int h, int interval, int amount, int order, JPanel[] jPanels, String[] MulZone, String[] MulZone0) {
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
            jTextFields[flag].setBackground(TextColor3);
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






    //优化版，懒得改
    public JTextField[] Damage(int x, int y, int w, int h, int 间隔, int 行数, int 数量, int 排序数, JPanel[] 面板, String[] 分区名, String[] 主区名) {
        int flag = 0;
        JTextField[] jTextFields = text2Fields(数量);

        // 创建标签文本框
        CreateTextLabel2(面板, 排序数, 数量, x, y, w, h, 间隔, 行数, 主区名);

        for (int j = 0; j < 行数; j++) {
            // 创建属性输入区
            for (int i = 0; i < jTextFields.length/行数; i++) {
                JPanels(面板, 排序数, TextColor2, i * w + x, j * h + y, w, h);

                // 创建属性文本框
                JLabel label = getJLabel(分区名[flag]);
                面板[排序数].add(label, BorderLayout.NORTH);

                // 创建一个文本字段
                jTextFields[flag] = new JTextField(分区名[flag],5);
                jTextFields[flag].setBackground(TextColor3);
                // 将文本字段添加到面板
                面板[排序数].add(jTextFields[flag], BorderLayout.SOUTH);

                this.add(面板[排序数]);

                flag++;
            }

        }

        setPlaceholders(jTextFields, 分区名);
        return jTextFields;
    }


    private void CreateTextLabel2(JPanel[] jPanels, int order, int amount, int x, int y, int w, int h, int interval, int 行数, String[] MulZone0) {
        JPanels(jPanels, order, TextColor1, x,y - 20,(amount * w + (amount-1) * interval)/行数,h/2);
        JLabel jLabel = getJLabel(MulZone0[sum]);
        jPanels[order].add(jLabel);
        this.add(jPanels[order]);
        sum++;
    }


}
