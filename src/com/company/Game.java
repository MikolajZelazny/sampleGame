package com.company;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

/**
 * This class contantilogic orender
 *
 * @author Mikolaj
 *
 * 2021 New Year Resolution
 */
public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 4983030414942140047L;
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private Random random;
    private HUD hud;

    public Game() {
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        new Window(WIDTH, HEIGHT, "GAME", this);

        hud = new HUD();
        random = new Random();

        Player player1 = new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player, handler);
        Player player2 = new Player(WIDTH / 2 + 64, HEIGHT / 2 - 32, ID.Player2, handler);

        handler.addObject(player1);
        handler.addObject(player2);
        handler.addObject(new BasicEnemy(WIDTH / 2 + 64, HEIGHT / 2 - 32, ID.BasicEnemy,handler, player1, player2));
        //for (int i = 0; i < 10; i++) {
        //    handler.addObject(new Splash(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Splash));
        //}

        //handler.addObject(new Splash(WIDTH / 2, HEIGHT / 2 - 32, ID.Splash));
    }

    public synchronized void start() {
        thread = new Thread(this); //Poczytac
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
        hud.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.blue);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);
        hud.render(g);
        g.dispose();
        bs.show();
    }


    public static int clamp(int var, int min, int max) {
        if (var >= max)
            return var = max;
        else if(var <= min)
            return var = min;
        else
            return var;
    }

    public static void main(String[] args) {
        new Game();
    }


}
