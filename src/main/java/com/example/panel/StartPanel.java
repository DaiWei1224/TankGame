package com.example.panel;

import javax.swing.*;
import java.awt.*;

/**
 * 启动面板
 */
public class StartPanel extends JPanel implements Runnable {
    int times = 0;
    int x = 1200;
    int x1 = -50;

    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1200, 900);

        Font font = new Font("宋体", Font.BOLD, 150);
        Font font2 = new Font("宋体", Font.BOLD, 100);
        g.setFont(font);
        g.setColor(Color.orange);
        g.drawString("TankBattle", x, 350);
        g.setFont(font2);
        g.drawString("2017", x + 280, 500);

        if (x1 < 640) {
            g.setColor(Color.green);
            drawTank(x1 - 120, 600, g, 1);
            g.setColor(Color.CYAN);
            drawTank(x1 + 30, 600, g, 1);
        } else {
            g.setColor(Color.green);
            drawTank(x1 - 120, 600, g, 0);
            g.setColor(Color.CYAN);
            drawTank(x1 + 30, 600, g, 0);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (x > 200) {
                x -= 10;
            }
            if (x1 < 640) {
                x1 += 7;
            }
            times++;
            this.repaint();
        }
    }

    public void drawTank(int x, int y, Graphics g, int direct) {
        switch (direct) {
            case 0:
                g.fill3DRect(x - 25, y - 25, 10, 50, false); // 左履带
                g.fill3DRect(x + 15, y - 25, 10, 50, false); // 右履带
                g.fill3DRect(x - 15, y - 15, 30, 30, false); // 中间矩形
                g.fillOval(x - 10, y - 10, 20, 20); // 圆
                g.drawLine(x, y - 10, x, y - 25); // 炮筒
                break;
            case 1:
                g.fill3DRect(x - 25, y - 25, 50, 10, false); // 左履带
                g.fill3DRect(x - 25, y + 15, 50, 10, false); // 右履带
                g.fill3DRect(x - 15, y - 15, 30, 30, false); // 中间矩形
                g.fillOval(x - 10, y - 10, 20, 20); // 圆
                g.drawLine(x + 10, y, x + 25, y); // 炮筒
                break;
        }
    }
}
