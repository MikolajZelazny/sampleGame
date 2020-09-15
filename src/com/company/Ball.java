package com.company;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball extends GameObject {

    private Rocket rocket1;
    private Rocket rocket2;

    public Ball(int x, int y, ID id, Rocket rocket1, Rocket rocket2) {
        super(x, y, id);

        velX = 0.5;
        velY = 0.5;
        this.rocket1=rocket1;
        this.rocket2 = rocket2;
        player1_x = rocket1.getX();
        player1_y = rocket1.getY();
        player2_x = rocket2.getX();
        player2_y = rocket2.getY();
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

        if(   (y <= 0 || y >=Game.HEIGHT-32) || rocket1.isCollion || rocket2.isCollion  ) {

            velY *= -1;

            if(rocket1.isCollion) rocket1.isCollion = false;
            if(rocket2.isCollion) rocket2.isCollion = false;
        }
        if(   x <= 0 || x>=Game.WIDTH-16 || rocket1.isCollion || rocket2.isCollion )  {

            velX *= -1;

            if(rocket1.isCollion) rocket1.isCollion = false;
            if(rocket2.isCollion) rocket2.isCollion = false;
        }


        //pileczka weszla w interakcje z paletka


        System.out.println("Enemy x:" + x + " y:" + y);
        System.out.println("Player1 x:" + player1_x + " y:" + player1_y);
        System.out.println("Player2 x:" + player2_x + " y:" + player2_y);
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
