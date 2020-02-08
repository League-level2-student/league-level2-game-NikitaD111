import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Screen2 extends Screen implements KeyListener {
	private Struggle_of_Order game;
	ArrayList<BufferedImage> fields;
	int bgX = 0;
	int bgS = 1;
	
	public Screen2(Struggle_of_Order game ) {
		super(game.frame);
		this.game = game;
		fields = new ArrayList<BufferedImage>();
		fields.add(tree);
		fields.add(tree);
		
	}
	public void setup() {
		 game.frame.setPreferredSize(new Dimension(800,Screen.HEIGHT));
         System.out.println("something that indicate that it got to that part of the code");
         game.frame.pack();
         game.frame.addKeyListener(this);
         this.setFocusable(true);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < 5; i++) {
			g.drawImage(this.tree, bgX+i*800 ,0, 800, Screen.HEIGHT, null);	
		}
		for (int i = 0; i < 2; i++) {
			g.drawImage(this.cave, (bgX+i*800)+4800,0,1000,Screen.HEIGHT,null);
		}
	    g.drawImage(this.house, bgX+4000,50,1000, Screen.HEIGHT,null);
		g.drawImage(this.knight, 300, 450, 250, 250, null);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		System.out.println(key);
		if(key == KeyEvent.VK_D) {
			bgX = bgX-200;
			repaint();
		}
		
	
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}
	}

