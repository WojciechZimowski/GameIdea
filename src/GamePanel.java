
import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;


public class GamePanel extends JPanel implements Runnable {
    //SETTINGS
    final int originalTileSize = 32;
    //32x32
    final int scale =2;
    final int titleSize = originalTileSize*scale; //64x64
    final int maxScreenCol = 16;
    final int maxScreenRow=12;
    final int screenWidth = titleSize * maxScreenCol;//1024 pix
    final int screenHeight = titleSize * maxScreenRow;//768 pix
    KeyInput keyH = new KeyInput();
    Thread gameThread;

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
        while (gameThread!= null){
            //System.out.println("The game loop is on");
            update();

            repaint();

        }

    }
    public void update(){
        //InputHandling
        if(keyH.upPressed== true){
            playerY -= playerSpeed;

        }
        else if(keyH.downPressed== true){
            playerY += playerSpeed;

        }
        else if(keyH.leftPressed== true){
            playerX -= playerSpeed;

        }
        else if(keyH.rightPressed== true){
            playerX += playerSpeed;

        }

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2=(Graphics2D)g;

        g2.setColor(Color.white);
        g2.fillRect(playerX,playerY,titleSize,titleSize);

        g2.dispose();
    }
}
