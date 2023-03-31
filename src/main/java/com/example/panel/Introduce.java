package com.example.panel;

import javax.swing.*;
import java.awt.*;

/**
 * 游戏说明
 */
public class Introduce extends JDialog {

    public Introduce(JFrame parent) {
        super(parent, "游戏说明", false);

        JPanel panel = new JPanel();
        Font font = new Font("微软雅黑", Font.BOLD, 30);

        JLabel jlb05 = new JLabel("我方坦克生命：3");
        JLabel jlb04 = new JLabel(" ");
        JLabel jlb03 = new JLabel("敌方坦克数量：18");
        JLabel jlb02 = new JLabel(" ");
        JLabel jlb01 = new JLabel("总关卡数：2");
        JLabel jlb00 = new JLabel(" ");
        JLabel jlb0 = new JLabel("玩家1：");
        JLabel jlb1 = new JLabel("                      W：上");
        JLabel jlb2 = new JLabel("          A：左    S：下    D：右");
        JLabel jlb3 = new JLabel(" ");
        JLabel jlb4 = new JLabel("                   F：发射子弹");
        JLabel jlb5 = new JLabel(" ");
        JLabel jlb6 = new JLabel("玩家2：");
        JLabel jlb7 = new JLabel("                        ↑：上");
        JLabel jlb8 = new JLabel("          ←：左    ↓：下    →：右");
        JLabel jlb9 = new JLabel(" ");
        JLabel jlb10 = new JLabel("                   L：发射子弹");

        jlb05.setFont(font);
        jlb03.setFont(font);
        jlb01.setFont(font);
        jlb0.setFont(font);
        jlb1.setFont(font);
        jlb2.setFont(font);
        jlb4.setFont(font);
        jlb6.setFont(font);
        jlb7.setFont(font);
        jlb8.setFont(font);
        jlb10.setFont(font);

        BoxLayout blt = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(blt);

        panel.add(jlb05);
        panel.add(jlb04);
        panel.add(jlb03);
        panel.add(jlb02);
        panel.add(jlb01);
        panel.add(jlb00);
        panel.add(jlb0);
        panel.add(jlb1);
        panel.add(jlb2);
        panel.add(jlb3);
        panel.add(jlb4);
        panel.add(jlb5);
        panel.add(jlb6);
        panel.add(jlb7);
        panel.add(jlb8);
        panel.add(jlb9);
        panel.add(jlb10);
        this.add(panel);

        this.setSize(550, 650);
        this.setVisible(true);
    }

}
