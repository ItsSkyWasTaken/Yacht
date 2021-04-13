package net.sky.yacht;

import net.sky.yacht.display.Window;
import net.sky.yacht.input.MouseListener;
import net.sky.yacht.objects.*;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
    private final Handler handler;
    private Thread thread;
    private boolean running = false;

    public Game() {
        this.handler = new Handler();
        this.addMouseListener(new MouseListener(this.handler));

        for(int i = 0; i < 5; i++) {
            this.handler.addObject(new Die(320 + ((i - 2) * 64), 360));
        }
        this.handler.addObject(new RollButton(240, 280));
        this.handler.addObject(new ScoreSheet(48, 32));

        new Window(640, 480, "Yacht", this);
    }

    public synchronized void start() {
        this.thread = new Thread(this);
        this.thread.start();
        this.running = true;
    }

    public synchronized void stop() {
        try {
            this.thread.join();
            this.running = false;
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60D;
        double ns = 1000000000D / amountOfTicks;
        double delta = 0D;
        long timer = System.currentTimeMillis();
        while(this.running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1D) {
                this.tick();
                delta--;
            }
            if(this.running) {
                this.render();
            }
            if(System.currentTimeMillis() - timer > 1000L) {
                timer += 1000L;
            }
        }
        this.stop();
    }

    private void tick() {
        this.handler.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
        } else {
            Graphics g = bs.getDrawGraphics();
            g.setColor(new Color(239, 239, 239));
            g.fillRect(0, 0, 640, 480);
            this.handler.render(g);
            g.dispose();
            bs.show();
        }
    }

    public static void main(String[] args) {
        new Game();
    }
}
