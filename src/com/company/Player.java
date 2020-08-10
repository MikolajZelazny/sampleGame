package com.company;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player extends GameObject {

    Random r = new Random();

    public Player(int x, int y, ID id) {
        super(x, y, id);

    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp(x,0,Game.WIDTH-37);
        y = Game.clamp(y,0,Game.HEIGHT-60);
    }

    @Override
    public void render(Graphics g) {
        //add head
        if(id == ID.Player) g.setColor((Color.green));
        else if (id == ID.Player2) g.setColor(Color.black);
        //g.setColor(Color.green);
        g.fillRect(x, y, 32, 64);
    }
}
