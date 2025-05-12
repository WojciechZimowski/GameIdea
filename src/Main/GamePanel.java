package Main;

import Entity.Player;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel implements Runnable {
    //SETTINGS
    final int originalTileSize = 32;
    //32x32
    final int scale =2;
    public final int titleSize = originalTileSize*scale; //64x64
    final int maxScreenCol = 16;
    final int maxScreenRow=12;
    final int screenWidth = titleSize * maxScreenCol;//1024 pix
    final int screenHeight = titleSize * maxScreenRow;//768 pix
    //FramesPerSecond
    int FPS =60;
    KeyInput keyH = new KeyInput();
    Thread gameThread;
    Player player = new Player(this,keyH);

    //Player def pos.
    int playerX=100;
    int playerY=100;
    int playerSpeed = 4;


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer=0;
        int drawCount = 0;

        while (gameThread!= null){
            currentTime = System.nanoTime();
            delta+=(currentTime-lastTime)/drawInterval;
            lastTime = currentTime;
                    if(delta>=1){
                        update();

                        repaint();
                        delta--;
                        drawCount++;

                    }
                    if(timer>=1000000000){
                        System.out.println("FPS"+drawCount);
                        drawCount=0;
                        timer=0;
                    }



        }

    }
    public void update(){
        //InputHandling

        player.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2=(Graphics2D)g;

        player.draw(g2);



        g2.dispose();
    }
}
