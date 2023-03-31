package com.example.panel;

import com.example.panel.level.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TankGame extends JFrame implements ActionListener {

    Level_1 myPanel_1 = null;
    Level_1 myPanel_2 = null;
    Level_2 myPanel_2_1 = null;
    Level_2 myPanel_2_2 = null;
    StartPanel startPanel;
    JMenuBar jmb;
    JMenu jm1;
    JMenuItem jmi1;
    JMenuItem jmi11;
    JMenuItem jmi2;
    JMenu jm2;
    JMenuItem jm2i1;
    JMenuItem jmi111;

    public TankGame() {
        // 创建菜单和菜单选项
        Font font = new Font("微软雅黑", Font.BOLD, 16);
        jmb = new JMenuBar();
        jm1 = new JMenu("开始");
        jm1.setFont(font);
        jmi1 = new JMenuItem("单人游戏");
        jmi11 = new JMenuItem("双人游戏");
        jmi111 = new JMenuItem("下一关");
        jmi1.setFont(font);
        jmi11.setFont(font);
        jmi111.setFont(font);

        jmi1.addActionListener(this);
        jmi1.setActionCommand("单人游戏");
        jmi11.addActionListener(this);
        jmi11.setActionCommand("双人游戏");
        jmi111.addActionListener(this);
        jmi111.setActionCommand("下一关");
        jmi2 = new JMenuItem("退出游戏");
        jmi2.setFont(font);
        jmi2.addActionListener(this);
        jmi2.setActionCommand("退出游戏");
        jm2 = new JMenu("帮助");
        jm2.setFont(font);
        jm2i1 = new JMenuItem("游戏说明");
        jm2i1.setFont(font);
        jm2i1.addActionListener(this);
        jm2i1.setActionCommand("游戏说明");

        jm2.add(jm2i1);
        jm1.add(jmi1);
        jm1.add(jmi11);
        jm1.add(jmi111);
        jm1.add(jmi2);
        jmb.add(jm1);
        jmb.add(jm2);

        startPanel = new StartPanel();
        this.add(startPanel);
        Thread startPanel = new Thread(this.startPanel);
        startPanel.start();

        this.setJMenuBar(jmb);
        this.setSize(1218,976);
        this.setTitle("坦克大战");
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getActionCommand().equals("单人游戏")) {
            if (myPanel_1 != null) {
                this.remove(myPanel_1);
                myPanel_1 = null;
            }
            if (myPanel_2 != null) {
                this.remove(myPanel_2);
                myPanel_2 = null;
            }
            if (myPanel_2_1 != null) {
                this.remove(myPanel_2_1);
                myPanel_2_1 = null;
            }
            if (myPanel_2_2 != null) {
                this.remove(myPanel_2_2);
                myPanel_2_2 = null;
            }
            myPanel_1 = new Level_1(1);
            new Thread(myPanel_1).start();
            this.remove(startPanel);
            this.add(myPanel_1);
            this.addKeyListener(myPanel_1);
            this.setVisible(true);
        } else if (arg0.getActionCommand().equals("双人游戏")) {
            if (myPanel_2 != null) {
                this.remove(myPanel_2);
                myPanel_2 = null;
            }
            if (myPanel_1 != null) {
                this.remove(myPanel_1);
                myPanel_1 = null;
            }
            if (myPanel_2_1 != null) {
                this.remove(myPanel_2_1);
                myPanel_2_1 = null;
            }
            if (myPanel_2_2 != null) {
                this.remove(myPanel_2_2);
                myPanel_2_2 = null;
            }
            myPanel_2 = new Level_1(2);
            new Thread(myPanel_2).start();
            this.remove(startPanel);
            this.add(myPanel_2);
            this.addKeyListener(myPanel_2);
            this.setVisible(true);
        } else if (arg0.getActionCommand().equals("下一关")) {
            if (myPanel_1 != null) {
                this.remove(myPanel_1);
                myPanel_1 = null;
                myPanel_2_1 = new Level_2(1);
                new Thread(myPanel_2_1).start();
                this.remove(startPanel);
                this.add(myPanel_2_1);
                this.addKeyListener(myPanel_2_1);
                this.setVisible(true);
            } else if (myPanel_2 != null) {
                this.remove(myPanel_2);
                myPanel_2 = null;
                myPanel_2_2 = new Level_2(2);
                new Thread(myPanel_2_2).start();
                this.remove(startPanel);
                this.add(myPanel_2_2);
                this.addKeyListener(myPanel_2_2);
                this.setVisible(true);
            }
        } else if (arg0.getActionCommand().equals("退出游戏")) {
            System.exit(0);
        } else if (arg0.getActionCommand().equals("游戏说明")) {
            new Introduce(this).setVisible(true);
        }
    }
}


