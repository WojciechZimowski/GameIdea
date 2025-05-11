
import javax.swing.*;
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

    Thread gameThread;

//com

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (gameThread!= null){
//gamee
        }

    }
}
