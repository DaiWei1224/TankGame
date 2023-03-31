package com.example.object;

/**
 * 子弹类
 */
public class Bullet implements Runnable {
    public int x, y, direction;
    public int speed = 25; // 子弹速度
    public boolean live = true; // 判断子弹是否还存活

    public Bullet(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (direction) {
                case 0:
                    y -= speed;
                    break;
                case 1:
                    y += speed;
                    break;
                case 2:
                    x += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }
            if (x < 0 || x > 1200 || y < 0 || y > 900) {
                live = false;
                break;
            }
        }
    }

}
