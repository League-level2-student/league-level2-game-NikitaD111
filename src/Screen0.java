import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Screen0 extends Screen {
	private static final long serialVersionUID = 1L;
	Struggle_of_Order game;
	KeyAdapter keyAdapter;
	boolean instructionPressed = false;
	
	public Screen0( Struggle_of_Order game) {
		 super( game.frame );
	        this.game = game;
	        
	        keyAdapter = new KeyAdapter() {
	            public void keyPressed(KeyEvent e) {
	                int keyCode = e.getKeyCode();
	                
	                if(keyCode == KeyEvent.VK_ENTER) {
	                	game.frame.addKeyListener( game );
	                }
	                else if(keyCode == KeyEvent.VK_SPACE) {
	                	instructionPressed = true;
	                }
	                }
	            };
	            game.frame.removeKeyListener( game );
	            game.frame.addKeyListener( keyAdapter );
	}
	 public void cleanUp() {
	        super.cleanUp();
	        
	        game.frame.removeKeyListener( keyAdapter );
	    }
	public void paintComponent(Graphics g) {
        super.paintComponent( g );
        g.drawImage( this.background, -1, 0, Screen.WIDTH , Screen.HEIGHT, null );
        if (instructionPressed) {
			g.drawImage( this.help, -1, 0, Screen.WIDTH , Screen.HEIGHT, null );
		}
          

    }
    
}
