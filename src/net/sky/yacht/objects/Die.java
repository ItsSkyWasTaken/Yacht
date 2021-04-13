package net.sky.yacht.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Die extends GameObject {
    private final Random r;
    private int value;
    private boolean held;

    public Die(int x, int y) {
        super(x, y);
        this.r = new Random();
        this.value = 0;
        this.held = false;
    }

    public void roll(boolean ignoreHold) {
        if(ignoreHold) {
            this.held = false;
        }
        if(!this.held) {
            this.value = this.r.nextInt(6) + 1;
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(this.x - 16, this.y - 16, 32, 32);
        g.setColor(Color.WHITE);
        g.fillRect(this.x - 15, this.y - 15, 30, 30);
        g.setColor(Color.BLACK);
        switch(this.value) {
            case 1:
                g.fillOval(this.x - 4, this.y - 4, 8, 8);
                break;
            case 2:
                g.fillOval(this.x + 6, this.y - 14, 8, 8);
                g.fillOval(this.x - 14, this.y + 6, 8, 8);
                break;
            case 3:
                g.fillOval(this.x + 6, this.y - 14, 8, 8);
                g.fillOval(this.x - 4, this.y - 4, 8, 8);
                g.fillOval(this.x - 14, this.y + 6, 8, 8);
                break;
            case 4:
                g.fillOval(this.x - 14, this.y - 14, 8, 8);
                g.fillOval(this.x + 6, this.y - 14, 8, 8);
                g.fillOval(this.x - 14, this.y + 6, 8, 8);
                g.fillOval(this.x + 6, this.y + 6, 8, 8);
                break;
            case 5:
                g.fillOval(this.x - 14, this.y - 14, 8, 8);
                g.fillOval(this.x + 6, this.y - 14, 8, 8);
                g.fillOval(this.x - 4, this.y - 4, 8, 8);
                g.fillOval(this.x - 14, this.y + 6, 8, 8);
                g.fillOval(this.x + 6, this.y + 6, 8, 8);
                break;
            case 6:
                g.fillOval(this.x - 14, this.y - 14, 8, 8);
                g.fillOval(this.x + 6, this.y - 14, 8, 8);
                g.fillOval(this.x - 14, this.y - 4, 8, 8);
                g.fillOval(this.x + 6, this.y - 4, 8, 8);
                g.fillOval(this.x - 14, this.y + 6, 8, 8);
                g.fillOval(this.x + 6, this.y + 6, 8, 8);
                break;
        }
        if(this.held) {
            g.drawRect(this.x - 20, this.y - 20, 40, 40);
        }
    }

    @Override
    public void click(int x, int y) {
        if((x >= this.x - 16) && (x < this.x + 16) && (y >= this.y - 16) && (y < this.y + 16) && (this.value > 0)) {
            this.held = !this.held;
        }
    }

    public int getValue() {
        return this.value;
    }
}
