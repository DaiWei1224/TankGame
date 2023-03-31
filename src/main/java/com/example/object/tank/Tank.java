package com.example.object.tank;

/**
 * 坦克基类
 */
public abstract class Tank {
    public int x; // 坦克横坐标
    public int y; // 坦克纵坐标
    public int speed = 5; // 坦克速度
    public int direction = 0; // 0表示向上，1表示向下，2表示向右，3表示向左

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
