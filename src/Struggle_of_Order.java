
	import java.awt.Dimension;
	import java.awt.event.KeyEvent;
	import java.awt.event.KeyListener;

	import javax.swing.JFrame;
import javax.swing.JOptionPane;

	public class Struggle_of_Order implements KeyListener {
	    private Screen currentScreen;
	    JFrame frame;
	    Screen screen0;
	    Screen screen1;
	    Screen screen2;
	    Screen screen3;

	    public  Struggle_of_Order() {
	        frame = new JFrame();
	        frame.setPreferredSize( new Dimension( Screen.WIDTH, Screen.HEIGHT ) );
	        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	        frame.setVisible( true );
	        frame.addKeyListener( this );
	        
	        screen0 = new Screen0( this );
	        screen1 = new Screen1( this );
	        screen2 = new Screen2( this );
	        
	        
	        changeScreen( screen0 );
	    }
	    
	    public void changeScreen( Screen screen ) {
	        if( currentScreen != null ) {
	            currentScreen.cleanUp();
	        }
	        
	        this.frame.getContentPane().add( screen );
	        screen.setup();
	        currentScreen = screen;
	    }

	    @Override
	    public void keyPressed(KeyEvent arg0) {
	        int keyCode = arg0.getKeyCode();
	        if(currentScreen == screen0) {
	        	
	        }
	        if( keyCode == KeyEvent.VK_ENTER ) {
	            if( currentScreen == screen0 ) {
	                changeScreen( screen1 );
	                System.out.println( currentScreen );
	           
	        }
	        if (keyCode == KeyEvent.VK_SPACE){
	        	
	        }
	    }
	    }

	    @Override
	    public void keyReleased(KeyEvent arg0) {
	        // TODO Auto-generated method stub
	        
	    }

	    @Override
	    public void keyTyped(KeyEvent arg0) {
	        // TODO Auto-generated method stub
	        
	    }

	}


