package com.example.object;

/**
 * 围墙类
 */
public class Wall {
    public int x, y;
    public int type; // 围墙类型
    public boolean live = true;

    public Wall(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getType() {
        return type;
    }

}
