package com.example.panel.level;

import com.example.music.BGMusicPlayer;
import com.example.object.*;
import com.example.object.tank.Enemy;
import com.example.object.tank.Me;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * 关卡1面板
 */
public class Level_1 extends JPanel implements Runnable, KeyListener {

    // 我方坦克数量
    int number;
    // 定义我的坦克
    Me me;
    Me me2 = null;
    // 敌方新加入坦克的最大数量，为15只
    int enemyNum = 0;
    // 定义敌方的坦克组
    Vector<Enemy> enemies = new Vector<>();
    // 定义围墙组
    Vector<Wall> walls = new Vector<>();
    // 定义爆炸组
    Vector<Bomb> bombs = new Vector<>();
    // 定义爆炸的连续三张图片
    Image bombImage1;
    Image bombImage2;
    Image bombImage3;
    // 老王
    Image king;

    public Level_1(int number) {
        this.number = number;
        // 初始化我方坦克
        me = new Me(425, 875);
        me.getTank(enemies);
        me.getWall(walls);
        if (number == 2) {
            me2 = new Me(775, 875);
            me2.getTank(enemies);
            me2.getWall(walls);
            me.getAnotherMe(me2);
            me2.getAnotherMe(me);
        }
        // 初始化敌方坦克组
        for (int i = 0; i < 3; i++) { // 敌方坦克一次出来三辆
            Enemy enemy = new Enemy(25 + i * 575, 25);
            // 将敌人坦克向量赋给刚创建的敌人
            enemy.getTank(enemies);
            enemy.getWall(walls);
            // 将该敌人添加到地方坦克组里
            enemies.add(enemy);
            enemy.setDirection(1);
            Thread enTank = new Thread(enemy);
            enTank.start();
        }
        // 初始化围墙
        for (int i = 0; i < 13; i++) { // 左一
            Wall wall = new Wall(50, 50 + i * 25, 0);
            walls.add(wall);
        }
        for (int i = 0; i < 13; i++) {
            Wall wall = new Wall(100, 50 + i * 25, 0);
            walls.add(wall);
        }
        for (int i = 0; i < 13; i++) {
            Wall wall = new Wall(50, 525 + i * 25, 0);
            walls.add(wall);
        }
        for (int i = 0; i < 13; i++) {
            Wall wall = new Wall(100, 525 + i * 25, 0);
            walls.add(wall);
        }

        for (int i = 0; i < 13; i++) { // 右一
            Wall wall = new Wall(1050, 50 + i * 25, 0);
            walls.add(wall);
        }
        for (int i = 0; i < 13; i++) {
            Wall wall = new Wall(1100, 50 + i * 25, 0);
            walls.add(wall);
        }
        for (int i = 0; i < 13; i++) {
            Wall wall = new Wall(1050, 525 + i * 25, 0);
            walls.add(wall);
        }
        for (int i = 0; i < 13; i++) {
            Wall wall = new Wall(1100, 525 + i * 25, 0);
            walls.add(wall);
        }

        for (int i = 0; i < 13; i++) { // 左二
            Wall wall = new Wall(250, 50 + i * 25, 0);
            walls.add(wall);
        }
        for (int i = 0; i < 13; i++) {
            Wall wall = new Wall(300, 50 + i * 25, 0);
            walls.add(wall);
        }
        for (int i = 0; i < 13; i++) {
            Wall wall = new Wall(250, 525 + i * 25, 0);
            walls.add(wall);
        }
        for (int i = 0; i < 13; i++) {
            Wall wall = new Wall(300, 525 + i * 25, 0);
            walls.add(wall);
        }

        for (int i = 0; i < 13; i++) { // 右二
            Wall wall = new Wall(850, 50 + i * 25, 0);
            walls.add(wall);
        }
        for (int i = 0; i < 13; i++) {
            Wall wall = new Wall(900, 50 + i * 25, 0);
            walls.add(wall);
        }
        for (int i = 0; i < 13; i++) {
            Wall wall = new Wall(850, 525 + i * 25, 0);
            walls.add(wall);
        }
        for (int i = 0; i < 13; i++) {
            Wall wall = new Wall(900, 525 + i * 25, 0);
            walls.add(wall);
        }

        for (int i = 0; i < 10; i++) { // 左三
            Wall wall = new Wall(450, 50 + i * 25, 0);
            walls.add(wall);
        }
        for (int i = 0; i < 10; i++) {
            Wall wall = new Wall(500, 50 + i * 25, 0);
            walls.add(wall);
        }

        for (int i = 0; i < 10; i++) { // 右三
            Wall wall = new Wall(650, 50 + i * 25, 0);
            walls.add(wall);
        }
        for (int i = 0; i < 10; i++) {
            Wall wall = new Wall(700, 50 + i * 25, 0);
            walls.add(wall);
        }

        for (int i = 0; i < 3; i++) { // 中间第一层
            for (int j = 0; j < 6; j++) {
                Wall wall = new Wall(450 + j * 50, 450 + i * 25, 0);
                walls.add(wall);
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                Wall wall = new Wall(450 + j * 50, 375 + i * 25, 0);
                walls.add(wall);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                Wall wall = new Wall(650 + j * 50, 375 + i * 25, 0);
                walls.add(wall);
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                Wall wall = new Wall(550 + j * 50, 525 + i * 25, 0);
                walls.add(wall);
            }
        }

        for (int i = 0; i < 3; i++) { // 中间第二层
            for (int j = 0; j < 6; j++) {
                Wall wall = new Wall(450 + j * 50, 600 + i * 25, 0);
                walls.add(wall);
            }
        }

        for (int i = 0; i < 6; i++) { // 老巢左
            Wall wall = new Wall(500, 750 + i * 25, 0);
            walls.add(wall);
        }
        for (int i = 0; i < 6; i++) { // 老巢右
            Wall wall = new Wall(650, 750 + i * 25, 0);
            walls.add(wall);
        }

        for (int i = 0; i < 2; i++) { // 老巢上左
            Wall wall = new Wall(550, 750 + i * 25, 0);
            walls.add(wall);
        }
        for (int i = 0; i < 2; i++) { // 老巢上右
            Wall wall = new Wall(600, 750 + i * 25, 0);
            walls.add(wall);
        }

        for (int i = 0; i < 7; i++) { // 左边铁块
            Wall wall = new Wall(i * 50, 425, 1);
            walls.add(wall);
        }
        for (int i = 0; i < 7; i++) { // 左边铁块
            Wall wall = new Wall(i * 50, 450, 1);
            walls.add(wall);
        }

        for (int i = 0; i < 7; i++) { // 右边铁块
            Wall wall = new Wall(850 + i * 50, 425, 1);
            walls.add(wall);
        }
        for (int i = 0; i < 7; i++) { // 左边铁块
            Wall wall = new Wall(850 + i * 50, 450, 1);
            walls.add(wall);
        }

        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 6; i++) { // 中间铁块
                Wall wall = new Wall(450 + i * 50, 300 + j * 25, 1);
                walls.add(wall);
            }
        }
        // 播放背景音乐
        new BGMusicPlayer().start();
        // 初始化图片
        bombImage1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/img/bomb_1.gif"));
        bombImage2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/img/bomb_2.gif"));
        bombImage3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/img/bomb_3.gif"));
        king = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/img/boss.jpg"));
    }

    // 重写paint方法
    public void paint(Graphics g) {
        super.paint(g);

        g.fillRect(0, 0, 1200, 900);

        // 画出老巢
        if (me.kingLive) {
            g.drawImage(king, 550, 800, 100, 100, this);
        }

        // 画出我方坦克
        if (me.live) {
            this.drawTank(me.getX(), me.getY(), me.getDirection(), 0, g);
            // 画出我的坦克的Bullets中每颗子弹
            if (me.live) {
                for (int i = 0; i < this.me.bullets.size(); i++) {
                    Bullet bulleti = me.bullets.get(i);
                    // 判断子弹不为空且子弹存活的时候，画子弹
                    if (bulleti != null && bulleti.live == true) {
                        g.fillOval(bulleti.x, bulleti.y, 6, 6);// 圆
                    }
                    if (bulleti.live == false) {
                        // 若子弹已经死亡，则从向量中删除
                        me.bullets.remove(bulleti);
                    }
                }
            }
        }
        if (this.number == 2) {
            if (me2.live) {
                this.drawTank(me2.getX(), me2.getY(), me2.getDirection(), 2, g);
                for (int i = 0; i < this.me2.bullets.size(); i++) {
                    Bullet bulleti = me2.bullets.get(i);
                    // 判断子弹不为空且子弹存活的时候，画子弹
                    if (bulleti != null && bulleti.live == true) {
                        g.fillOval(bulleti.x, bulleti.y, 6, 6); // 圆
                    }
                    if (bulleti.live == false) {
                        // 若子弹已经死亡，则从向量中删除
                        me2.bullets.remove(bulleti);
                    }
                }
            }
        }

        // 画出敌方坦克的Bullets中每颗子弹
        g.setColor(Color.lightGray);
        for (int j = 0; j < this.enemies.size(); j++) {
            Enemy enemy1 = enemies.get(j);
            for (int i = 0; i < enemy1.bullets.size(); i++) {
                Bullet bulleti = enemy1.bullets.get(i);
                // 判断子弹不为空且子弹存活的时候，画子弹
                if (bulleti != null && bulleti.live == true) {
                    g.fillOval(bulleti.x, bulleti.y, 6, 6); // 圆
                }
                if (bulleti.live == false) {
                    // 若子弹已经死亡，则从向量中删除
                    enemy1.bullets.remove(bulleti);
                }
            }
        }

        // 画出爆炸效果
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if (bomb.life > 6) {
                g.drawImage(bombImage1, bomb.x, bomb.y, 50, 50, this);
            } else if (bomb.life > 3) {
                g.drawImage(bombImage2, bomb.x, bomb.y, 50, 50, this);
            } else if (bomb.life > 0) {
                g.drawImage(bombImage3, bomb.x, bomb.y, 50, 50, this);
            }
            bomb.lifReduce();
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }
        }

        // 画出敌方坦克
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemyi = enemies.get(i);
            if (enemyi.live == false) {
                enemies.remove(enemyi);
            } else {
                this.drawTank(enemyi.getX(), enemyi.getY(), enemyi.getDirection(), 1, g);
            }
        }

        // 画出围墙
        for (int i = 0; i < walls.size(); i++) {
            Wall walli = walls.get(i);
            if (walli.live == false) {
                walls.remove(walli);
            } else {
                this.drawWall(walli.getX(), walli.getY(), walli.getType(), g);
            }
        }

        // 画出Game over
        if (me.kingLive == false && enemies.size() > 0) {
            Font font = new Font("宋体", Font.BOLD, 180);
            g.setFont(font);
            g.setColor(Color.RED);
            g.drawString("Game over", 160, 500);
        }
        if (number == 2) {
            if (me.lifeNum == 0 && me2.lifeNum == 0 && enemies.size() > 0) {
                Font font = new Font("宋体", Font.BOLD, 180);
                g.setFont(font);
                g.setColor(Color.RED);
                g.drawString("Game over", 160, 500);
            }
        } else {
            if (me.lifeNum == 0 && enemies.size() > 0) {
                Font font = new Font("宋体", Font.BOLD, 180);
                g.setFont(font);
                g.setColor(Color.RED);
                g.drawString("Game over", 160, 500);
            }
        }
        // 画出you win
        if (me.victory) {
            Font font = new Font("宋体", Font.BOLD, 180);
            g.setFont(font);
            g.setColor(Color.WHITE);
            g.drawString("You win!", 200, 500);
        }
    }

    // 画围墙
    public void drawWall(int x, int y, int type, Graphics g) {
        switch (type) {
            case 0:
                g.setColor(Color.ORANGE); // 砖块
                break;
            case 1:
                g.setColor(Color.LIGHT_GRAY); // 铁块
                break;
            case 2:
                g.setColor(Color.BLUE); // 河流
                break;
            case 3:
                g.setColor(Color.GREEN); // 草丛
                break;
        }
        g.fill3DRect(x, y, 50, 25, false);
    }

    // 画坦克
    public void drawTank(int x, int y, int direction, int type, Graphics g) {
        switch (type) {
            case 0: // 我方
                g.setColor(Color.GREEN);
                break;
            case 1: // 敌方
                g.setColor(Color.MAGENTA);
                break;
            case 2: // 我方2
                g.setColor(Color.CYAN);
                break;
        }
        switch (direction) { // 判断方向
            case 0: // 方向向上
                g.fill3DRect(x - 25, y - 25, 10, 50, false); // 左履带
                g.fill3DRect(x + 15, y - 25, 10, 50, false); // 右履带
                g.fill3DRect(x - 15, y - 15, 30, 30, false); // 中间矩形
                g.fillOval(x - 10, y - 10, 20, 20); // 圆
                g.drawLine(x, y - 10, x, y - 25); // 炮筒
                break;
            case 1: // 方向向下
                g.fill3DRect(x - 25, y - 25, 10, 50, false); // 左履带
                g.fill3DRect(x + 15, y - 25, 10, 50, false); // 右履带
                g.fill3DRect(x - 15, y - 15, 30, 30, false); // 中间矩形
                g.fillOval(x - 10, y - 10, 20, 20); // 圆
                g.drawLine(x, y + 10, x, y + 25); // 炮筒
                break;
            case 2: // 方向向右
                g.fill3DRect(x - 25, y - 25, 50, 10, false); // 左履带
                g.fill3DRect(x - 25, y + 15, 50, 10, false); // 右履带
                g.fill3DRect(x - 15, y - 15, 30, 30, false); // 中间矩形
                g.fillOval(x - 10, y - 10, 20, 20); // 圆
                g.drawLine(x + 10, y, x + 25, y); // 炮筒
                break;
            case 3: // 方向向左
                g.fill3DRect(x - 25, y - 25, 50, 10, false); // 左履带
                g.fill3DRect(x - 25, y + 15, 50, 10, false); // 右履带
                g.fill3DRect(x - 15, y - 15, 30, 30, false); // 中间矩形
                g.fillOval(x - 10, y - 10, 20, 20); // 圆
                g.drawLine(x - 10, y, x - 25, y); // 炮筒
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            this.me.setDirection(0);
            this.me.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            this.me.setDirection(1);
            this.me.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            this.me.setDirection(2);
            this.me.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            this.me.setDirection(3);
            this.me.moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_F) {
            if (me.bullets.size() == 0) {
                this.me.shot();
            }
        }
        if (number == 2) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                this.me2.setDirection(0);
                this.me2.moveUp();
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                this.me2.setDirection(1);
                this.me2.moveDown();
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                this.me2.setDirection(2);
                this.me2.moveRight();
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                this.me2.setDirection(3);
                this.me2.moveLeft();
            }
            if (e.getKeyCode() == KeyEvent.VK_L) {
                if (me2.bullets.size() == 0) {
                    this.me2.shot();
                }
            }
        }
        // 重绘界面
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 判断敌方子弹是否击中围墙
            for (int j = 0; j < this.enemies.size(); j++) {
                Enemy enemy1 = enemies.get(j);
                for (int i = 0; i < enemy1.bullets.size(); i++) {
                    Bullet bulleti = enemy1.bullets.get(i);
                    for (int k = 0; k < this.walls.size(); k++) {
                        Wall walli = walls.get(k);
                        if (bulleti.x >= walli.x && bulleti.x <= walli.x + 50 && bulleti.y >= walli.y && bulleti.y <= walli.y + 25) {
                            if (walli.type == 0) { // 砖块类型的墙
                                bulleti.live = false;
                                walli.live = false;
                            } else if (walli.type == 1) { // 铁块类型的墙
                                bulleti.live = false;
                            }
                        }
                    }
                }
            }
            if (me.kingLive) {
                // 判断敌方子弹是否击中老王
                for (int j = 0; j < this.enemies.size(); j++) {
                    Enemy enemy1 = enemies.get(j);
                    for (int i = 0; i < enemy1.bullets.size(); i++) {
                        Bullet bulleti = enemy1.bullets.get(i);
                        if (bulleti.x >= 550 && bulleti.x <= 650 && bulleti.y >= 800 && bulleti.y <= 900) {
                            bulleti.live = false;
                            me.kingLive = false;
                            Bomb bomb = new Bomb(575, 825);
                            bombs.add(bomb);
                            me.live = false;
                            Bomb bomb2 = new Bomb(me.x - 25, me.y - 25);
                            bombs.add(bomb2);
                            if (number == 2) {
                                me2.live = false;
                                Bomb bomb3 = new Bomb(me2.x - 25, me2.y - 25);
                                bombs.add(bomb3);
                            }
                            me.lifeNum = 0;
                            if (number == 2) {
                                me2.lifeNum = 0;
                            }
                        }
                    }
                }
            }
            if (me.live) { // 我方坦克还活着的时候
                // 判断敌方子弹是否击中我方坦克
                for (int j = 0; j < this.enemies.size(); j++) {
                    Enemy enemy1 = enemies.get(j);
                    for (int i = 0; i < enemy1.bullets.size(); i++) {
                        Bullet bulleti = enemy1.bullets.get(i);
                        if (bulleti.x >= me.x - 25 && bulleti.x <= me.x + 25 && bulleti.y >= me.y - 25 && bulleti.y <= me.y + 25) {
                            bulleti.live = false;
                            me.live = false;
                            me.lifeNum--;

                            // System.gc();
                            Bomb bomb = new Bomb(me.x - 25, me.y - 25);
                            bombs.add(bomb);
                        }
                    }
                }
                // 判断子弹是否击中敌方坦克
                for (int i = 0; i < me.bullets.size(); i++) {
                    // 取出当前子弹
                    Bullet bulleti = me.bullets.get(i);
                    if (bulleti.live == true) {
                        // 对每辆敌方坦克进行判断
                        for (int j = 0; j < enemies.size(); j++) {
                            // 取出当前坦克
                            Enemy enemyi = enemies.get(j);
                            if (enemyi.live == true) {
                                if (bulleti.x >= enemyi.x - 25 && bulleti.x <= enemyi.x + 25 && bulleti.y >= enemyi.y - 25 && bulleti.y <= enemyi.y + 25) {
                                    bulleti.live = false;
                                    enemyi.live = false;
                                    Bomb bomb = new Bomb(enemyi.x - 25, enemyi.y - 25);
                                    bombs.add(bomb);
                                }
                            }
                        }
                    }
                }
                // 判断子弹是否击中围墙
                for (int i = 0; i < me.bullets.size(); i++) {
                    // 取出当前子弹
                    Bullet bulleti = me.bullets.get(i);
                    if (bulleti.live == true) {
                        // 对每个围墙进行判断
                        for (int j = 0; j < walls.size(); j++) {
                            // 取出当前坦克
                            Wall walli = walls.get(j);
                            if (walli.live == true) {
                                if (bulleti.x >= walli.x && bulleti.x <= walli.x + 50 && bulleti.y >= walli.y && bulleti.y <= walli.y + 25) {
                                    if (walli.type == 0) { // 砖块类型的墙
                                        bulleti.live = false;
                                        walli.live = false;
                                    } else if (walli.type == 1) { // 铁块类型的墙
                                        bulleti.live = false;
                                    }
                                }
                            }
                        }
                    }
                }
                if (me.kingLive) {
                    // 判断子弹是否击中老王
                    for (int i = 0; i < me.bullets.size(); i++) {
                        // 取出当前子弹
                        Bullet bulleti = me.bullets.get(i);
                        if (bulleti.live == true) {
                            if (bulleti.x >= 550 && bulleti.x <= 650 && bulleti.y >= 800 && bulleti.y <= 900) {
                                bulleti.live = false;
                                me.kingLive = false;
                                Bomb bomb = new Bomb(575, 825);
                                bombs.add(bomb);
                                me.live = false;
                                Bomb bomb2 = new Bomb(me.x - 25, me.y - 25);
                                bombs.add(bomb2);
                                if (number == 2) {
                                    me2.live = false;
                                    Bomb bomb3 = new Bomb(me2.x - 25, me2.y - 25);
                                    bombs.add(bomb3);
                                }
                                me.lifeNum = 0;
                                if (number == 2) {
                                    me2.lifeNum = 0;
                                }
                            }
                        }
                    }
                }
            }
            if (number == 2) {
                for (int i = 0; i < me2.bullets.size(); i++) {
                    // 取出当前子弹
                    Bullet bulleti = me2.bullets.get(i);
                    if (bulleti.live == true) {
                        // 对每辆敌方坦克进行判断
                        for (int j = 0; j < enemies.size(); j++) {
                            // 取出当前坦克
                            Enemy enemyi = enemies.get(j);
                            if (enemyi.live == true) {
                                if (bulleti.x >= enemyi.x - 25 && bulleti.x <= enemyi.x + 25 && bulleti.y >= enemyi.y - 25 && bulleti.y <= enemyi.y + 25) {
                                    bulleti.live = false;
                                    enemyi.live = false;
                                    Bomb bomb = new Bomb(enemyi.x - 25, enemyi.y - 25);
                                    bombs.add(bomb);
                                }
                            }
                        }
                    }
                }
                if (me2.live) { // 我方坦克还活着的时候
                    // 判断敌方子弹是否击中我方坦克
                    for (int j = 0; j < this.enemies.size(); j++) {
                        Enemy enemy1 = enemies.get(j);
                        for (int i = 0; i < enemy1.bullets.size(); i++) {
                            Bullet bulleti = enemy1.bullets.get(i);
                            if (bulleti.x >= me2.x - 25 && bulleti.x <= me2.x + 25 && bulleti.y >= me2.y - 25 && bulleti.y <= me2.y + 25) {
                                bulleti.live = false;
                                me2.live = false;
                                me2.lifeNum--;
                                // me=null;
                                // System.gc();
                                Bomb bomb = new Bomb(me2.x - 25, me2.y - 25);
                                bombs.add(bomb);
                            }
                        }
                    }
                    // 判断子弹是否击中敌方坦克
                    for (int i = 0; i < me2.bullets.size(); i++) {
                        // 取出当前子弹
                        Bullet bulleti = me2.bullets.get(i);
                        if (bulleti.live == true) {
                            // 对每辆敌方坦克进行判断
                            for (int j = 0; j < enemies.size(); j++) {
                                // 取出当前坦克
                                Enemy enemyi = enemies.get(j);
                                if (enemyi.live == true) {
                                    if (bulleti.x >= enemyi.x - 25 && bulleti.x <= enemyi.x + 25 && bulleti.y >= enemyi.y - 25 && bulleti.y <= enemyi.y + 25) {
                                        bulleti.live = false;
                                        enemyi.live = false;
                                        Bomb bomb = new Bomb(enemyi.x - 25, enemyi.y - 25);
                                        bombs.add(bomb);
                                    }
                                }
                            }
                        }
                    }
                    // 判断子弹是否击中围墙
                    for (int i = 0; i < me2.bullets.size(); i++) {
                        // 取出当前子弹
                        Bullet bulleti = me2.bullets.get(i);
                        if (bulleti.live == true) {
                            // 对每个围墙进行判断
                            for (int j = 0; j < walls.size(); j++) {
                                // 取出当前坦克
                                Wall walli = walls.get(j);
                                if (walli.live == true) {
                                    if (bulleti.x >= walli.x && bulleti.x <= walli.x + 50 && bulleti.y >= walli.y && bulleti.y <= walli.y + 25) {
                                        if (walli.type == 0) { // 砖块类型的墙
                                            bulleti.live = false;
                                            walli.live = false;
                                        } else if (walli.type == 1) { // 铁块类型的墙
                                            bulleti.live = false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (me.kingLive) {
                        // 判断子弹是否击中老王
                        for (int i = 0; i < me2.bullets.size(); i++) {
                            // 取出当前子弹
                            Bullet bulleti = me2.bullets.get(i);
                            if (bulleti.live == true) {
                                if (bulleti.x >= 550 && bulleti.x <= 650 && bulleti.y >= 800 && bulleti.y <= 900) {
                                    bulleti.live = false;
                                    me.kingLive = false;
                                    Bomb bomb = new Bomb(575, 825);
                                    bombs.add(bomb);
                                    me.live = false;
                                    Bomb bomb2 = new Bomb(me.x - 25, me.y - 25);
                                    bombs.add(bomb2);
                                    me2.live = false;
                                    Bomb bomb3 = new Bomb(me2.x - 25, me2.y - 25);
                                    bombs.add(bomb3);
                                    me.lifeNum = 0;
                                    me2.lifeNum = 0;
                                }
                            }
                        }
                    }
                }
            }
            if (enemies.size() < 3 && enemyNum < 15) {
                Enemy enemy = new Enemy(25 + (enemyNum % 3) * 575, 25);
                // 将敌人坦克向量赋给刚创建的敌人
                enemy.getTank(enemies);
                enemy.getWall(walls);
                // 将该敌人添加到地方坦克组里
                enemies.add(enemy);
                enemy.setDirection(1);
                Thread enTank = new Thread(enemy);
                enTank.start();
                enemyNum++;
            }
            if (enemies.size() == 0) {
                me.victory = true;
            }
            if (me.live == false && me.lifeNum > 0) {
                me.live = true;
                me.x = 425;
                me.y = 875;
            }
            if (number == 2) {
                if (me2.live == false && me2.lifeNum > 0) {
                    me2.live = true;
                    me2.x = 775;
                    me2.y = 875;
                }
            }
            // 重绘面板
            this.repaint();
        }
    }

}