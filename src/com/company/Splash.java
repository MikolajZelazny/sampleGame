//package com.company;
//
//import java.awt.*;
//
//
////AFTER COMMENTING CLASS AND IMPLEMENTATION IN GAME ERROR OCCURES (HOW TO FIND REASON)
//public class Splash extends GameObject {
//    public Rectangle getBounds(){
//        return new Rectangle(x, y, 10,10);
//    }
//
//    @Override
//    public Rectangle getBoundsLeft() {
//        return null;
//    }
//
//    @Override
//    public Rectangle getBoundsRight() {
//        return null;
//    }
//
//    @Override
//    public Rectangle getBoundsTop() {
//        return null;
//    }
//
//    @Override
//    public Rectangle getBoundsDown() {
//        return null;
//    }
//
//    //mechanizm rekurencji
//    public Splash(int x, int y, ID id) {
//        super(x, y, id);
//        // for here or int directions as input for method
//        // for inside constructor
//        velX = 2;
//        velY = 2;
//
//    }
//
//    @Override
//    public void tick() {
//        for (int i = 0; i < 4; i++) {
//            x += velX*0.2;
//            y += velY*0.2;
//            //this.velX*0.2;
//            //System.out.println(getVelX());
//        }
//
//
//        if(y <= 0 || y >=Game.HEIGHT-32) velY *= -1;
//        if(x <= 0 || x>=Game.WIDTH-16) velX *= -1;
//    }
//
//    @Override
//    public void render(Graphics g) {
//        for (int i = 0; i < 2; i++) {
//            //setX();
//            g.setColor(Color.yellow);
//            g.fillRect(x,y,10,10);
//            //if(y <= 0 || y >=Game.HEIGHT-32) velY *= -1;
//            //if(x <= 0 || x>=Game.WIDTH-16) velX *= -1;
//        }
//
//
//
//    }
//
//}
