package com.company;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player) { //KEYBOARD SETTINGS
                if (key == KeyEvent.VK_W) tempObject.setVelY(-5); // setVelY is better than setY
                if (key == KeyEvent.VK_S) tempObject.setVelY(5);
                if (key == KeyEvent.VK_D) tempObject.setVelX(5);
                if (key == KeyEvent.VK_A) tempObject.setVelX(-5);
            }
            if (tempObject.getId() == ID.Player2) { //KEYBOARD SETTINGS
                if (key == KeyEvent.VK_UP) tempObject.setVelY(-5);
                if (key == KeyEvent.VK_DOWN) tempObject.setVelY(5);
                if (key == KeyEvent.VK_RIGHT) tempObject.setVelX(5);
                if (key == KeyEvent.VK_LEFT) tempObject.setVelX(-5);
            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player) { //KEYBOARD SETTINGS
                if (key == KeyEvent.VK_W) tempObject.setVelY(0);
                if (key == KeyEvent.VK_S) tempObject.setVelY(0);
                if (key == KeyEvent.VK_D) tempObject.setVelX(0);
                if (key == KeyEvent.VK_A) tempObject.setVelX(0);
            }
            if (tempObject.getId() == ID.Player2) { //KEYBOARD SETTINGS
                if (key == KeyEvent.VK_UP) tempObject.setVelY(0);
                if (key == KeyEvent.VK_DOWN) tempObject.setVelY(0);
                if (key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
                if (key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
            }

        }

    }
}
