package com.hezekiah.demo;

import com.hezekiah.demo.count.GenshinImpactDamageCalculator;
import com.hezekiah.demo.ui.GenshinDamageCalculatorGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GenshinDamageCalculatorGUI gui = new GenshinDamageCalculatorGUI();
            gui.setVisible(true);

            gui.setCalculateAction(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        GenshinImpactDamageCalculator.GameCharacter character = gui.getCharacterInput();
                        GenshinImpactDamageCalculator.Enemy enemy = gui.getEnemyInput();

                        GenshinImpactDamageCalculator.DamageResult result =
                                GenshinImpactDamageCalculator.DamageCalculator.calculate(character, enemy);

                        gui.showResults(result);
                    } catch (NumberFormatException ex) {
                        gui.showError("输入格式错误！请检查数字输入");
                    } catch (IllegalArgumentException ex) {
                        gui.showError(ex.getMessage());
                    }
                }
            });
        });
    }
}