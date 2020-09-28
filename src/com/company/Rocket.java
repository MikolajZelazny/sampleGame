package com.company;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Rocket extends GameObject {

    boolean isCollion = false;
    Random r = new Random();
    Handler handler;

    public Rocket(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, 32,96);
    }


    public Rectangle getBoundsLeft() {
        return new Rectangle(x, y, 0,0);
    }
    public Rectangle getBoundsRight() {
        return new Rectangle(x, y+15, 0,0);
    }
    public Rectangle getBoundsTop() {
        return new Rectangle(x, y, 0,0);
    }
    public Rectangle getBoundsDown() {
        return new Rectangle(x+15, y, 0,0);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp(x,0,Game.WIDTH-37);
        y = Game.clamp(y,0,Game.HEIGHT-60);

        collision();
    }

    private void collision (){
        for (int i = 0; i < handler.object.size(); i++) {

            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId()==ID.Ball) {
                if (getBounds().intersects(tempObject.getBounds())){ // getID player ++, p--
                    HUD.HEALTH -= 2;
                    isCollion = true;
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        //add head
        if(id == ID.Player) g.setColor((Color.green));
        else if (id == ID.Player2) g.setColor(Color.black);
        //g.setColor(Color.green);
        g.fillRect(x, y, 32, 96);
    }
}
