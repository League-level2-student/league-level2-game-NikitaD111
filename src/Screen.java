
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Screen extends JPanel {
    static final int WIDTH = 600;
    static final int HEIGHT = 800;

    public BufferedImage castle;
    public BufferedImage cursor;
    public BufferedImage taskbar;
    public BufferedImage background;
    public BufferedImage help;
    public BufferedImage market;
    public BufferedImage tree;
    public BufferedImage knight;
    public BufferedImage cave;
    public BufferedImage house;
    public BufferedImage deadf;
    public BufferedImage SRF;
    public BufferedImage door;
    public BufferedImage dungeon;
    public BufferedImage fighter;
    public BufferedImage loser;
    public BufferedImage kingdom;
    public BufferedImage npc;
    
    
    JFrame frame;
    GridBagConstraints c;
    Color backgroundColor;
    Audio audio;
    Visual visual;
    
    int sword = 0;
    
    public Screen( JFrame frame ) {
        this.frame = frame;
        
        visual = new Visual();
        c = new GridBagConstraints();
        
        frame.setPreferredSize( new Dimension( Screen.WIDTH, Screen.HEIGHT ) );
        
        try {
            castle = ImageIO.read(this.getClass().getResourceAsStream("kingdom.jpg"));
            cursor = ImageIO.read(this.getClass().getResourceAsStream("cursor.png"));
            taskbar = ImageIO.read(this.getClass().getResourceAsStream("taskbar1.png"));
            background = ImageIO.read(this.getClass().getResourceAsStream("Background.png"));
            help = ImageIO.read(this.getClass().getResourceAsStream("100.jpg"));
            tree = ImageIO.read(this.getClass().getResourceAsStream("tree.png"));
            knight = ImageIO.read(this.getClass().getResourceAsStream("Dark_Knight.png"));
            cave = ImageIO.read(this.getClass().getResourceAsStream("cave.jpg"));
            house = ImageIO.read(this.getClass().getResourceAsStream("house.png"));
            deadf = ImageIO.read(this.getClass().getResourceAsStream("dead_field.png"));
            SRF = ImageIO.read(this.getClass().getResourceAsStream("SRF.gif"));
            door = ImageIO.read(this.getClass().getResourceAsStream("door.jpg"));
            dungeon = ImageIO.read(this.getClass().getResourceAsStream("dungeon.png"));
            fighter = ImageIO.read(this.getClass().getResourceAsStream("knight1.png"));
            loser = ImageIO.read(this.getClass().getResourceAsStream("loser.jpg"));
           kingdom = ImageIO.read(this.getClass().getResourceAsStream("Cerean.jpg"));
           npc = ImageIO.read(this.getClass().getResourceAsStream("TownKnight.png"));
           
            
        } catch( IOException e ) {
            System.out.println( "ERROR: unable to load image files" );
        }
        
        // Default panel layout, can be changed
        this.setLayout( new GridBagLayout() );
        this.frame.pack();
    }
    
    public void setup() {
        this.revalidate();
        this.repaint();
        this.frame.pack();
    }
    
    public void cleanUp() {
        this.removeAll();
        this.frame.getContentPane().remove( this );
        this.frame.requestFocus();
    }
}
