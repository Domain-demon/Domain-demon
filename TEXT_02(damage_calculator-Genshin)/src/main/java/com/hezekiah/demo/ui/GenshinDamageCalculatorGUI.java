package com.hezekiah.demo.ui;

import com.hezekiah.demo.count.GenshinImpactDamageCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class GenshinDamageCalculatorGUI extends JFrame {
    private JTextField attackField = new JTextField(10);
    private JTextField skillMultiField = new JTextField(10);
    // ...其他输入字段声明

    private JTextArea resultArea = new JTextArea(15, 40);

    public GenshinDamageCalculatorGUI() {
        initUI();
    }

    private void initUI() {
        // 界面初始化代码
        setTitle("原神伤害计算器");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        // ...组件布局代码

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }

    public void showResults(GenshinImpactDamageCalculator.DamageResult result) {
        // 结果显示实现
        NumberFormat nf = NumberFormat.getNumberInstance();
        StringBuilder sb = new StringBuilder();
        // ...结果格式化代码
        resultArea.setText(sb.toString());
    }

    public GenshinImpactDamageCalculator.GameCharacter getCharacterInput() {
        // 从输入字段获取角色属性
        return new GenshinImpactDamageCalculator.GameCharacter(
                Double.parseDouble(attackField.getText()),
                // ...其他字段
        );
    }

    public GenshinImpactDamageCalculator.Enemy getEnemyInput() {
        // 从输入字段获取敌人属性
        return new GenshinImpactDamageCalculator.Enemy(
                Integer.parseInt(enemyLevelField.getText()),
                // ...其他字段
        );
    }

    public void setCalculateAction(ActionListener listener) {
        calculateBtn.addActionListener(listener);
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "错误", JOptionPane.ERROR_MESSAGE);
    }
}