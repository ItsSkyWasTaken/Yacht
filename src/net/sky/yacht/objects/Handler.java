package net.sky.yacht.objects;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
    private final LinkedList<GameObject> objects = new LinkedList<>();

    public void tick() {
        for(GameObject object : this.objects) {
            object.tick();
        }
    }

    public void render(Graphics g) {
        for(GameObject object : this.objects) {
            object.render(g);
        }
    }

    public void click(int x, int y) {
        for(GameObject object : this.objects) {
            object.click(x, y);
        }
    }

    public void addObject(GameObject object) {
        this.objects.add(object);
        object.handler = this;
    }

    public void removeObject(GameObject object) {
        this.objects.remove(object);
    }

    public LinkedList<GameObject> getObjects() {
        return this.objects;
    }
}
