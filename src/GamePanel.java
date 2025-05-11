
import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel {
    //SETTINGS
    final int originalTileSize = 32;
    //32x32
    final int scale =2;
    final int titleSize = originalTileSize*scale; //64x64
    final int maxScreenCol = 16;
    final int maxScreenRow=12;
    final int screenWidth = titleSize * maxScreenCol;//1024 pix
    final int screenHeight = titleSize * maxScreenRow;//768 pix

//com

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

}
