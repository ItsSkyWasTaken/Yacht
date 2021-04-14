package net.sky.yacht.objects;

import java.awt.*;

public class RollButton extends GameObject {
    private int rollsLeft;
    private boolean clickable = true;
    private int rounds = 12;

    public RollButton(int x, int y) {
        super(x, y);
        this.rollsLeft = 3;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(this.x, this.y, 160, 48);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Sans Serif", Font.PLAIN, 24));
        if(this.rounds >= 12) {
            g.drawString("New Game", this.x + 20, this.y + 32);
        } else if(this.clickable && this.rollsLeft == 0) {
            g.drawString("Next Round", this.x + 16, this.y + 32);
        } else {
            g.drawString("Rolls left: ".concat(String.valueOf(this.rollsLeft)), this.x + 20, this.y + 32);
        }
    }

    @Override
    public void click(int x, int y) {
        if(this.clickable && (x >= this.x) && (x < this.x + 160) && (y >= this.y) && (y < this.y + 48)) {
            if(this.rounds == 12) {
                this.rounds = 0;
                for(GameObject object : this.handler.getObjects()) {
                    if(object instanceof ScoreSheet) {
                        ((ScoreSheet) object).reset();
                    }
                }
            }
            if(this.rollsLeft > 0) {
                for(GameObject object : this.handler.getObjects()) {
                    if(object instanceof Die) {
                        ((Die) object).roll(false);
                    }
                }
                this.rollsLeft--;
                if(this.rollsLeft == 0) {
                    this.clickable = false;
                }
            } else {
                for(GameObject object : this.handler.getObjects()) {
                    if(object instanceof Die) {
                        ((Die) object).roll(true);
                    }
                }
                this.rollsLeft = 2;
            }
            for(GameObject object : this.handler.getObjects()) {
                if(object instanceof ScoreSheet) {
                    ((ScoreSheet) object).clickable = true;
                }
            }
        }
    }

    public void reset() {
        this.clickable = true;
        this.rollsLeft = 0;
        this.rounds++;
    }
}
