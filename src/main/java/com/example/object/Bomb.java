package com.example.object;

/**
 * 爆炸类
 */
public class Bomb {
    public int x, y;
    public int life = 9; // 子弹刚开始的寿命是9，根据寿命来觉得播放哪张图
    public boolean live = true;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void lifReduce() {
        if (life > 0) {
            life--;
        } else {
            this.live = false;
        }
    }

}
