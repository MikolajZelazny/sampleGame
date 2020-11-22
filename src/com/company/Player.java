package com.company;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {

    Random r = new Random();
    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, 32,96);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp(x,0,Game.WIDTH-37);
        y = Game.clamp(y,0,Game.HEIGHT-60);

        collision();
        handler.addObject(new Trail(x , y, ID.Trail, Color.LIGHT_GRAY, 32, 96
                , 0.1f, handler));
    }

    private void collision (){
        for (int i = 0; i < handler.object.size(); i++) {

            GameObject temoObject = handler.object.get(i);

            if (temoObject.getId()==ID.BasicEnemy) {
                if (getBounds().intersects(temoObject.getBounds())){ // getID player ++, p--
                    HUD.HEALTH -= 2;
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
