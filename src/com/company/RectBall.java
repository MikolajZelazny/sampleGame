package com.company;

import java.awt.*;

public class RectBall extends GameObject {

    Handler handler;
    boolean collisionDetector = false;

    public Rectangle getBoundsLeft() {
        return new Rectangle(x, y, 15,1);
    }
    public Rectangle getBoundsRight() {
        return new Rectangle(x, y+15, 15,1);
    }
    public Rectangle getBoundsTop() {
        return new Rectangle(x, y, 1,15);
    }
    public Rectangle getBoundsDown() {
        return new Rectangle(x+15, y, 1,15);
    }

    private Rocket rocket1;
    private Rocket rocket2;

    public RectBall(int x, int y, ID id, Handler handler, Rocket rocket1, Rocket rocket2) {
        super(x, y, id);
        this.handler = handler;


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
        return new Rectangle(x, y, 0,0);
        //return null;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp(x,0,Game.WIDTH-37);
        y = Game.clamp(y,0,Game.HEIGHT-60);

        wallsCollision();
    }

    private void wallsCollision (){
        for (int i = 0; i < handler.object.size(); i++) {

            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId()==ID.RectBall) {
                if (rocket1.getBounds().intersects(tempObject.getBoundsRight())){
                    velX *= -1;
                    collisionDetector = true;
                    System.out.println("Collision detected");
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        if (collisionDetector == true) {
            g.setColor(Color.green);
        } else g.setColor(Color.red);
        g2d.draw(getBoundsLeft());
        if (collisionDetector == true) {
            g.setColor(Color.green);
        } else g.setColor(Color.pink);
        g2d.draw(getBoundsRight());
        if (collisionDetector == true) {
            g.setColor(Color.green);
        } else g.setColor(Color.black);
        g2d.draw(getBoundsTop());
        if (collisionDetector == true) {
            g.setColor(Color.green);
        } else g.setColor(Color.white);
        g2d.draw(getBoundsDown());

    }
}