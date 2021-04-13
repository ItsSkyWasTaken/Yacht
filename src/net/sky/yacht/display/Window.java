package net.sky.yacht.display;

import net.sky.yacht.Game;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Window {
  
    // This is a field and not a local variable because window resizability is planned.
    private final JFrame frame;

    public Window(int width, int height, String title, Game game) {
        this.frame = new JFrame(title);
        this.frame.setPreferredSize(new Dimension(width, height));
        this.frame.setMinimumSize(new Dimension(width, height));
        this.frame.setMaximumSize(new Dimension(2732, 1536));
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(true);
        this.frame.setLocationRelativeTo(null);
        this.frame.add(game);
        this.frame.setVisible(true);
        game.start();
    }
}
