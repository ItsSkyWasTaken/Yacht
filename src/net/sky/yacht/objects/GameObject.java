package net.sky.yacht.objects;

import java.awt.Graphics;

public abstract class GameObject {
    public Handler handler;
    protected int x;
    protected int y;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void tick() {}
    public void render(Graphics g) {}
    public void click(int x, int y) {}
}
