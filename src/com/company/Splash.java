/*package com.company;

import java.awt.Color;
import java.awt.Graphics;

public class Splash extends GameObject {

    //mechanizm rekurencji
    public Splash(int x, int y, ID id) {
        super(x, y, id);
        // for here or int directions as input for method
        velX = 1;
        velY = -velX*2;

    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if(y <= 0 || y >=Game.HEIGHT-32) velY *= -1;
        if(x <= 0 || x>=Game.WIDTH-16) velX *= -1;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(x,y,10,10);
    }

}
*/