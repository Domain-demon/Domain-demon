package com.hezekiah.function;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TextFieldPlaceholderSetter {

    // 自定义方法，用于设置占位符
    public static void setPlaceholders(JTextField[] textFields, String[] placeholders) {
        // 检查数组长度是否匹配
        if (textFields.length != placeholders.length) {
            throw new IllegalArgumentException("Text field and placeholder arrays must have the same length.");
        }

        // 遍历数组，为每个文本字段设置占位符逻辑
        for (int i = 0; i < textFields.length; i++) {
            JTextField textField = textFields[i];
            String placeholder = placeholders[i];

            // 设置默认文本（占位符）和颜色
            textField.setText(placeholder);
            textField.setForeground(Color.GRAY);

            // 添加焦点监听器，以在字段获得和失去焦点时更改文本和颜色
            textField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (placeholder.equals(textField.getText())) {
                        textField.setText(""); // 清空占位符文本
                        textField.setForeground(Color.BLACK); // 设置正常文本颜色
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (textField.getText().isEmpty()) {
                        textField.setText(placeholder); // 如果字段为空，则恢复占位符文本
                        textField.setForeground(Color.GRAY); // 设置占位符文本颜色
                    }
                }
            });
        }
    }
}