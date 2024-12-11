package com.hezekiah.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import static com.hezekiah.random.RandomArray.*;

public class GameJFrame extends JFrame implements MouseListener {

    int[] arr = new int[16];
    int[][] data = new int[4][4];
    JButton checkButton = new JButton();
    JButton[] jButtons = new JButton[16];
    JLabel[] jLabels = new JLabel[16];
    ImageIcon backdrop = new ImageIcon();
    JLabel jLabelBackdrop = new JLabel(backdrop);
    String value;
    int key1 , key2, midvalue, flog = 0;



    //创建主界面

    public GameJFrame(){
        //初始化界面
        initJFrame();

        //初始化菜单
        initJMenubar();

        //初始化数据
        initData();

        //初始化图片
        initImage();

        //初始化交互
        initInteraction();



        //显示
        this.setVisible(true);
    }



    private void initJFrame() {
        //宽高
        this.setSize(990,810);
        //标题
        this.setTitle("Genshin 2.0");
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

    private void initJMenubar() {
        //菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        //选项对象
        JMenu firstJMenu = new JMenu("阿尔法");
        JMenu secondJMenu = new JMenu("伽马");

        //条目对象
        JMenuItem aItem = new JMenuItem("好");
        JMenuItem bItem = new JMenuItem("好");
        JMenuItem cItem = new JMenuItem("学");
        JMenuItem dItem = new JMenuItem("习");

        JMenuItem eItem = new JMenuItem("天");
        JMenuItem fItem = new JMenuItem("天");
        JMenuItem gItem = new JMenuItem("向");
        JMenuItem hItem = new JMenuItem("上");

        //条目to选项
        firstJMenu.add(aItem);
        firstJMenu.add(bItem);
        firstJMenu.add(cItem);
        firstJMenu.add(dItem);

        secondJMenu.add(eItem);
        secondJMenu.add(fItem);
        secondJMenu.add(gItem);
        secondJMenu.add(hItem);

        //选项to菜单
        jMenuBar.add(firstJMenu);
        jMenuBar.add(secondJMenu);

        //设置菜单
        this.setJMenuBar(jMenuBar);
    }

    private void initData() {
        Rand1(arr);
        RandData2(arr, data);
    }

    private void initImage() {
        int num2 = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                int num = data[i][j];
                jLabels[num2] = new JLabel(new ImageIcon("TEXT_00\\image\\blonde\\"+num+".jpg"));
                jLabels[num2].setBounds(159 + j * 168,39 + i *168,166,166);
                jLabels[num2].setBorder(new BevelBorder(BevelBorder.RAISED));
                this.getContentPane().add(jLabels[num2]);
                System.out.println(num2);
                num2++;
            }
        }

        //背景图片
        //创建ImageIcon对象
        ImageIcon backdrop = new ImageIcon("TEXT_00\\image\\blonde\\backdrop.jpg");
        //创建JLabel对象
        jLabelBackdrop = new JLabel(backdrop);
        //指定位置
        jLabelBackdrop.setBounds(0,0,990,750);
        //边框纹理
        jLabelBackdrop.setBorder(new BevelBorder(BevelBorder.LOWERED));
        //to界面
        this.getContentPane().add(jLabelBackdrop);
    }

    private void initInteraction() {
        int num2 = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                //设置按钮
                jButtons[num2] = new JButton(""+num2);
                //设置位形
                jButtons[num2].setBounds(159 + j * 168,39 + i *168,166,166);
                //设置背景
                jButtons[num2].setOpaque(false);
                //动作监听
                jButtons[num2].addMouseListener(this);
                //添加按钮
                this.getContentPane().add(jButtons[num2]);
                num2++;
            }
        }

        checkButton = new JButton("提交");
        checkButton.setBounds(0,0,50,50);
        checkButton.setOpaque(true);
        checkButton.addMouseListener(this);
        this.getContentPane().add(checkButton);
    }

    private void register() {
        midvalue = arr[key1];
        arr[key1] = arr[key2];
        arr[key2] = midvalue;
        RandData1(arr, data);
        refreshImage();
    }

    private void refreshImage() {
        int num2 = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                int num = data[i][j];
                this.getContentPane().remove(jLabels[num2]);
                jLabels[num2] = new JLabel(new ImageIcon("TEXT_00\\image\\blonde\\" + num + ".jpg"));
                jLabels[num2].setBounds(159 + j * 168, 39 + i * 168, 166, 166);
                jLabels[num2].setBorder(new BevelBorder(BevelBorder.RAISED));
                this.getContentPane().add(jLabels[num2]);
                num2++;
            }
        }

        this.getContentPane().remove(jLabelBackdrop);
        ImageIcon backdrop = new ImageIcon("TEXT_00\\image\\blonde\\backdrop.jpg");
        jLabelBackdrop = new JLabel(backdrop);
        jLabelBackdrop.setBounds(0, 0, 990, 750);
        jLabelBackdrop.setBorder(new BevelBorder(BevelBorder.LOWERED));
        this.getContentPane().add(jLabelBackdrop);

        refreshInteraction();

        this.getContentPane().repaint();
    }

    private void refreshInteraction() {
        int num2 = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                this.getContentPane().remove(jButtons[num2]);
                //设置按钮
                jButtons[num2] = new JButton(""+num2);
                //设置位形
                jButtons[num2].setBounds(159 + j * 168,39 + i *168,166,166);
                //设置背景
                jButtons[num2].setOpaque(false);
                //动作监听
                jButtons[num2].addMouseListener(this);
                //添加按钮
                this.getContentPane().add(jButtons[num2]);
                num2++;
            }
        }
    }

    private void victory() {
        int flog = 0;
        int[] victoryArray ={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        for (int i = 0; i < victoryArray.length; i++) {
            if (arr[i] != victoryArray[i]) {
                flog = 0;
                System.out.println("(。・＿・。)ﾉI’m sorry~，游戏继续");
                break;
            }else {
                flog = 1;
                System.out.println("O(∩_∩)OX(^▽^)ゞ，游戏胜利！！！");
            }
        }
        if (flog == 1){
            this.getContentPane().removeAll();
            ImageIcon backdrop = new ImageIcon("TEXT_00\\image\\victory\\victory.png");
            jLabelBackdrop = new JLabel(backdrop);
            jLabelBackdrop.setBounds(0, 0, 990, 750);
            jLabelBackdrop.setBorder(new BevelBorder(BevelBorder.RAISED));
            this.getContentPane().add(jLabelBackdrop);
            this.getContentPane().repaint();
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        Object soure = e.getSource();
        if (soure == checkButton){
            victory();
        }
        for (int i = 0; i < 16; i++) {
            if (soure == jButtons[i]) {
                value = jButtons[i].getText();
                if (flog % 2 == 0){
                    key1 = Integer.parseInt(value);
                    PrintArray1("arr1:" + Arrays.toString(arr));
                }else {
                    key2 = Integer.parseInt(value);
                    register();
                    PrintArray1("arr2:" + Arrays.toString(arr));
                }
                flog++;
                break;
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        Object soure = e.getSource();
//        if(soure == jtb){
//            jtb.setSize(200,200);
//        }
//        System.out.println("O(∩_∩)O哒哒~");
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        Object soure = e.getSource();
//        if(soure == jtb){
//            jtb.setSize(100,100);
//        }
//        System.out.println("O(∩_∩)O哈哈~");
    }
}
