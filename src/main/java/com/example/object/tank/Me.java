package com.example.object.tank;

import com.example.object.Bullet;
import com.example.object.Wall;

import java.util.Vector;

/**
 * 我方坦克类
 */
public class Me extends Tank {

    public boolean live = true;

    public int lifeNum = 3;

    public boolean kingLive = true;

    public boolean victory = false;

    public Vector<Enemy> enemies = new Vector<>();

    public Vector<Wall> walls = new Vector<>();

    public Me anMe = null;

    public Vector<Bullet> bullets = new Vector<>();
    public Bullet bullet = null;

    public Me(int x, int y) {
        super(x, y);
    }

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

    // 获取Panel中的坦克放入向量中
    public void getTank(Vector<Enemy> eny) {
        this.enemies = eny;
    }

    // 获取Panel中的围墙放入向量中
    public void getWall(Vector<Wall> wl) {
        this.walls = wl;
    }

    // 获取我方另一只坦克
    public void getAnotherMe(Me anMe) {
        this.anMe = anMe;
    }

    // 判断是否碰到了我方另一只坦克
    public boolean hitAnotherMe() {
        // 0表示向上，1表示向下，2表示向右，3表示向左
        switch (this.direction) {
            case 0:
                if ((this.x - anMe.x > -50) && (this.x - anMe.x < 50) && (this.y - anMe.y == 50))
                    return true;
                break;
            case 1:
                if ((this.x - anMe.x > -50) && (this.x - anMe.x < 50) && (this.y - anMe.y == -50))
                    return true;
                break;
            case 2:
                if ((this.y - anMe.y > -50) && (this.y - anMe.y < 50) && (this.x - anMe.x == -50))
                    return true;
                break;
            case 3:
                if ((this.y - anMe.y > -50) && (this.y - anMe.y < 50) && (this.x - anMe.x == 50))
                    return true;
                break;
        }
        return false;
    }

    // 判断是否碰到了别的坦克
    public boolean hitTank() {
        // 0表示向上，1表示向下，2表示向右，3表示向左
        switch (this.direction) {
            case 0:
                for (int i = 0; i < enemies.size(); i++) {
                    Enemy et = enemies.get(i);
                    if ((this.x - et.x > -50) && (this.x - et.x < 50) && (this.y - et.y == 50))
                        return true;
                }
                break;
            case 1:
                for (int i = 0; i < enemies.size(); i++) {
                    Enemy et = enemies.get(i);
                    if ((this.x - et.x > -50) && (this.x - et.x < 50) && (this.y - et.y == -50))
                        return true;
                }
                break;
            case 2:
                for (int i = 0; i < enemies.size(); i++) {
                    Enemy et = enemies.get(i);
                    if ((this.y - et.y > -50) && (this.y - et.y < 50) && (this.x - et.x == -50))
                        return true;
                }
                break;
            case 3:
                for (int i = 0; i < enemies.size(); i++) {
                    Enemy et = enemies.get(i);
                    if ((this.y - et.y > -50) && (this.y - et.y < 50) && (this.x - et.x == 50))
                        return true;
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

    public void moveDown() {
        if (y <= 870 && this.hitTank() == false && this.hitWall() == false) {
            if (this.anMe == null) {
                y += speed;
            } else if (this.anMe != null && this.hitAnotherMe() == false) {
                y += speed;
            }
        }
    }

    public void moveUp() {
        if (y >= 30 && this.hitTank() == false && this.hitWall() == false) {
            if (this.anMe == null) {
                y -= speed;
            } else if (this.anMe != null && this.hitAnotherMe() == false) {
                y -= speed;
            }
        }
    }

    public void moveRight() {
        if (x <= 1170 && this.hitTank() == false && this.hitWall() == false) {
            if (this.anMe == null) {
                x += speed;
            } else if (this.anMe != null && this.hitAnotherMe() == false) {
                x += speed;
            }
        }
    }

    public void moveLeft() {
        if (x >= 30 && this.hitTank() == false && this.hitWall() == false) {
            if (this.anMe == null) {
                x -= speed;
            } else if (this.anMe != null && this.hitAnotherMe() == false) {
                x -= speed;
            }
        }
    }

}
