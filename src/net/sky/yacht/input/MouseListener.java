package net.sky.yacht.input;

import net.sky.yacht.objects.Handler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends MouseAdapter {
    private final Handler handler;

    public MouseListener(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.handler.click(e.getX(), e.getY());
    }
}
