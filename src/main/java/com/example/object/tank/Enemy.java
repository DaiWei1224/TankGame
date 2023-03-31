package com.example.object.tank;

import com.example.object.Bullet;
import com.example.object.Wall;

import java.util.Vector;

/**
 * 敌方坦克类
 */
public class Enemy extends Tank implements Runnable {

    public boolean live = true;

    public Vector<Enemy> enemies = new Vector<>();

    public Vector<Wall> walls = new Vector<>();

    public Vector<Bullet> bullets = new Vector<>();

    public Bullet bullet = null;

    public void shot() {
        switch (this.direction) {
            case 0: // 上
                bullet = new Bullet(x, y - 25, 0);
                bullets.add(bullet);
                break;
            case 1: // 下
                bullet = new Bullet(x, y + 25, 1);
                bullets.add(bullet);
                break;
            case 2: // 右
                bullet = new Bullet(x + 25, y, 2);
                bullets.add(bullet);
                break;
            case 3: // 左
                bullet = new Bullet(x - 25, y, 3);
                bullets.add(bullet);
                break;
        }
        // 启动子弹线程
        new Thread(bullet).start();
    }

    public Enemy(int x, int y) {
        super(x, y);
    }

    // 获取Panel中的坦克放入向量中
    public void getTank(Vector<Enemy> eny) {
        this.enemies = eny;
    }

    // 获取Panel中的围墙放入向量中
    public void getWall(Vector<Wall> wl) {
        this.walls = wl;
    }

    // 判断是否碰到了别的坦克
    public boolean hitTank() {
        // 0表示向上，1表示向下，2表示向右，3表示向左
        switch (this.direction) {
            case 0:
                for (int i = 0; i < enemies.size(); i++) {
                    Enemy et = enemies.get(i);
                    if (et != this) {
                        if ((this.x - et.x > -50) && (this.x - et.x < 50) && (this.y - et.y == 50))
                            return true;
                    }
                }
                break;
            case 1:
                for (int i = 0; i < enemies.size(); i++) {
                    Enemy et = enemies.get(i);
                    if (et != this) {
                        if ((this.x - et.x > -50) && (this.x - et.x < 50) && (this.y - et.y == -50))
                            return true;
                    }
                }
                break;
            case 2:
                for (int i = 0; i < enemies.size(); i++) {
                    Enemy et = enemies.get(i);
                    if (et != this) {
                        if ((this.y - et.y > -50) && (this.y - et.y < 50) && (this.x - et.x == -50))
                            return true;
                    }
                }
                break;
            case 3:
                for (int i = 0; i < enemies.size(); i++) {
                    Enemy et = enemies.get(i);
                    if (et != this) {
                        if ((this.y - et.y > -50) && (this.y - et.y < 50) && (this.x - et.x == 50))
                            return true;
                    }
                }
                break;
        }
        return false;
    }

    // 判断是否碰到了围墙
    public boolean hitWall() {
        // 0表示向上，1表示向下，2表示向右，3表示向左
        switch (this.direction) {
            case 0:
                for (int i = 0; i < walls.size(); i++) {
                    Wall wl = walls.get(i);
                    if ((this.x - wl.x > -25) && (this.x - wl.x < 75) && (this.y - wl.y == 50))
                        return true;
                }
                break;
            case 1:
                for (int i = 0; i < walls.size(); i++) {
                    Wall wl = walls.get(i);
                    if ((this.x - wl.x > -25) && (this.x - wl.x < 75) && (this.y - wl.y == -25))
                        return true;
                }
                break;
            case 2:
                for (int i = 0; i < walls.size(); i++) {
                    Wall wl = walls.get(i);
                    if ((this.y - wl.y > -25) && (this.y - wl.y < 50) && (this.x - wl.x == -25))
                        return true;
                }
                break;
            case 3:
                for (int i = 0; i < walls.size(); i++) {
                    Wall wl = walls.get(i);
                    if ((this.y - wl.y > -25) && (this.y - wl.y < 50) && (this.x - wl.x == 75))
                        return true;
                }
                break;
        }
        return false;
    }

    @Override
    public void run() {
        while (true) {
            if (this.bullets.size() == 0) {
                this.shot();
            }
            switch (this.direction) {
                case 0:
                    for (int i = 0; i < 50; i++) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (y >= 30 && this.hitTank() == false && this.hitWall() == false) {
                            y -= speed;
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 50; i++) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (y <= 870 && this.hitTank() == false && this.hitWall() == false) {
                            y += speed;
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 50; i++) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (x <= 1170 && this.hitTank() == false && this.hitWall() == false) {
                            x += speed;
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 50; i++) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (x >= 30 && this.hitTank() == false && this.hitWall() == false) {
                            x -= speed;
                        }
                    }
                    break;
            }
            // 让敌方坦克产生一个随机方向
            this.direction = (int) (Math.random() * 4);
            // 如果敌方坦克死亡
            if (this.live == false) {
                break;
            }
        }
    }

}
