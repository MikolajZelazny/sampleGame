package com.company;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class FastEnemy extends GameObject {

    private Handler handler;

    public FastEnemy(int x, int y, ID id, Handler handler) {
        //public BasicEnemy(int x, int y, ID id, Handler handler, Player player1, Player player2)
        super(x, y, id);
        this.handler = handler;
        velX = 5;
        velY = 5;
        //player1_x = player1.getX();
        //player1_y = player1.getY();
        //player2_x = player2.getX();
        //player2_y = player2.getY();
    }

    public Rectangle getBounds(){
        Rectangle rect = new Rectangle(x, y, 16,16);
        //rect.setFrame();
        return rect;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if(y <= 0 || y >=Game.HEIGHT-32) velY *= -1;
        if(x <= 0 || x>=Game.WIDTH-16) velX *= -1;

        handler.addObject(new Trail(x , y, ID.Trail, Color.LIGHT_GRAY, 16, 16
                , 0.1f, handler));

        //pileczka weszla w interakcje z paletka


        System.out.println("Enemy x:" + x + " y:" + y);
    }

    @Override
    public void render(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.green);
        g2d.draw(getBounds());


        //g.setColor(Color.red);
        //g.fillRect(x,y,16,16);
    }
}
