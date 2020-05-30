
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.Timer;

@SuppressWarnings("serial")
public class Screen4 extends Screen implements ActionListener {
    Font titleFont = new Font( "Times New Roman", Font.PLAIN, 48 );
    private Struggle_of_Order game;
    
    Timer timer;
    int fps = 60;
    String endGame = "Press 'Enter' to stop game";
    int endGameX = 100;
    
  
    
    KeyAdapter keyAdapter;

    public Screen4(Struggle_of_Order game) {
        super( game.frame );
        this.game = game;
    }

    public void setup() {
        game.frame.setTitle( "Multiple controllable game objects" );
        
        
              

        this.revalidate();
        this.repaint();
    }

    public void cleanUp() {
        super.cleanUp();
    }
    

    public void paintComponent(Graphics g) {
        super.paintComponent( g );
        g.drawImage(this.endgame , 0 , 0, Screen.WIDTH, Screen.HEIGHT, null);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

    }
}
