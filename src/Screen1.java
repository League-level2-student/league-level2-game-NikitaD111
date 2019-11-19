import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class Screen1 extends Screen implements MouseMotionListener, ActionListener {
    Font titleFont = new Font( "Playfair Display", Font.PLAIN, 48 );
    Struggle_of_Order game;

    JPanel a;
    JLabel labelStory;
    JButton button1;
    JButton button2;
    JButton button3;
    JTextField textField;
    Cursor newCursor;
    
    int cursorX;
    int cursorY;
    int cursorWidth;
    int cursorHeight;
    Color bgColor;

    public Screen1( Struggle_of_Order game) {
        super( game.frame );
        this.game = game;

        this.addMouseMotionListener( this );
    }
    public void paintComponent(Graphics g) {
        super.paintComponent( g );
        g.setColor( bgColor );
        g.drawImage( this.castle, 0, 0, Screen.WIDTH , (Screen.HEIGHT*4)/4, null );
         g.drawImage( this.taskbar, 0, (Screen.HEIGHT*3)/4, Screen.WIDTH , Screen.HEIGHT/4, null );
          

    }
    
    public void setup() {
        this.game.frame.setTitle( "Struggle_of_Order" );
        this.setLayout( new BorderLayout() );
        
        bgColor = Color.GREEN;
        
        labelStory = new JLabel( "         Choose where you want to go" );
        labelStory.setFont( new Font( "Tahoma", ( Font.BOLD | Font.ITALIC ), 24 ) );

        button1 = new JButton( "Market" );
        button2 = new JButton( "Fields" );
        button3 = new JButton( "Castle" );

        // Don't allow button presses to shift focus on the keyListener in the frame
        button1.setFocusable( false );
        button2.setFocusable( false );
        button3.setFocusable( false );
        button1.addActionListener( this );
        button2.addActionListener( this );
        button3.addActionListener( this );
        button1.setBackground(new Color(0,0,0,0));
        textField = new JTextField( 20 );
        textField.setText( "Choose your fate" );
        textField.setEditable( false );

        a = new JPanel();
        a.setLayout( new GridBagLayout() );
        a.setBackground(new Color(0,0,0,0));
        a.setPreferredSize( new Dimension( Screen.WIDTH, Screen.HEIGHT / 4 ) );
        a.setMaximumSize( new Dimension( Screen.WIDTH, Screen.HEIGHT / 4 ) );
        a.setAlignmentX( Component.LEFT_ALIGNMENT );
        a.setAlignmentY( Component.BOTTOM_ALIGNMENT );
        
        addStoryLine();
        addButtons();
        addTextField();

        cursorX = 100;
        cursorY = 100;
        cursorWidth = 75;
        cursorHeight = 75;
        
        newCursor = Toolkit.getDefaultToolkit().createCustomCursor( cursor, new Point(0, 20), "inf cursor");
        game.frame.setCursor( newCursor );
        
        this.add( a, BorderLayout.SOUTH );
        game.frame.pack();
        this.repaint();
    }

    public void addStoryLine() {

        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.EAST;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridwidth = 4;
        gc.gridx = 0;
        gc.gridy = 0;
        a.add( labelStory, gc );
    }

    public void addButtons() {
        GridBagConstraints gc = new GridBagConstraints();

        // Number of pixels between adjacent components: top, left, bottom, right sides
        gc.insets = new Insets( 20, 0, 0, 0 );

        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.NONE;
        gc.gridx = 0;
        gc.gridy = 1;
        gc.ipadx = 0;
        gc.ipadx = 100;
        a.add( button1, gc );

        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.NONE;
        gc.gridx = 1;
        gc.gridy = 1;
        a.add( button2, gc );

        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.NONE;
        gc.gridx = 2;
        gc.gridy = 1;
        a.add( button3, gc );
    }

    public void addTextField() {
        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.CENTER;
        gc.gridwidth = 3;
        gc.gridx = 0;
        gc.gridy = 2;
        gc.insets = new Insets( 20, 0, 0, 0 );
        a.add( textField, gc );
    }

    

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX() - cursorWidth / 2;
        int y = e.getY() - cursorHeight / 2;

        if( x >= 0 && x <= ( Screen.WIDTH - cursorWidth ) ) {
            cursorX = x;
            this.repaint();
        }
        if( y >= 0 && y <= ( ( Screen.HEIGHT ) - cursorHeight ) ) {
            cursorY = y;
            this.repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        JButton buttonPressed = (JButton)arg0.getSource();

        if( buttonPressed == button1 ) {
            bgColor = Color.WHITE;
            textField.setText( "Traveling to Market" );
            this.repaint();
        } else if( buttonPressed == button2 ) {
            bgColor = Color.WHITE;
            textField.setText( "Traveling to Fields" );
            this.repaint();
        } else if( buttonPressed == button3 ) {
            bgColor = Color.WHITE;
            textField.setText( "Traveling to Castle" );
            this.repaint();
        }
    }
}
