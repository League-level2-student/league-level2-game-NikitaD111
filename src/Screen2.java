import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Screen2 extends Screen implements KeyListener, MouseListener {
	private Struggle_of_Order game;
	ArrayList<BufferedImage> fields;
	int bgX = 0;
	int bgS = 1;
	int knightX = 300;
	int stage = 0;

	public Screen2(Struggle_of_Order game) {
		super(game.frame);
		this.game = game;
		fields = new ArrayList<BufferedImage>();
		fields.add(tree);
		fields.add(tree);

	}

	public void setup() {
		game.frame.setPreferredSize(new Dimension(800, Screen.HEIGHT));
		System.out.println("something that indicate that it got to that part of the code");
		game.frame.pack();
		game.frame.addKeyListener(this);
		game.frame.addMouseListener(this);
		this.setFocusable(true);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (stage == 0) {
			
		
		for (int i = 0; i < 5; i++) {
			g.drawImage(this.tree, bgX + i * 800, 0, 800, Screen.HEIGHT, null);
		}
		for (int i = 0; i < 4; i++) {
			g.drawImage(this.cave, (bgX + i * 800) + 4800, 0, 1000, Screen.HEIGHT, null);
		}
		
		g.drawImage(this.house, bgX + 4000, 0, 1000, Screen.HEIGHT + 90, null);
		g.drawImage(this.deadf, bgX + 8000, 0, 1000, Screen.HEIGHT, null);
		g.drawImage(this.deadf, bgX + 9000, 0, 1000, Screen.HEIGHT, null);
		g.drawImage(this.deadf, bgX + 10000, 0, 1000, Screen.HEIGHT, null);
		g.drawImage(this.knight, knightX, 450, 250, 250, null);
		}
		else if(stage == 1) {
			for (int i = 0; i < 6; i++) {
				g.drawImage(this.dungeon, bgX +i *800 , 0, 1000, Screen.HEIGHT, null);

			}
				g.drawImage(this.knight, knightX, 450, 250, 250, null);
				}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		System.out.println(key);
		if (key == KeyEvent.VK_D) {
			if ((bgX <= -3100 && bgX > -4000) || (bgX <= -4200 && bgX > -5700) || bgX <= -7200 && bgX > -8000) {
				if (knightX >= 1000) {
					knightX = 300;
					if (bgX > -4000) {
						bgX = -4000;
					}
						else if(bgX > -5700) {
							bgX = -5700;
						}
					 else if (bgX > -8000) {
						bgX = -8000;
					} 
				} else {
					knightX = knightX + 200;
				}
			} else {
				bgX = bgX - 100;
			}
			repaint();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int sX = e.getX();
		int sY = e.getY();
		System.out.println(bgX);
		System.out.println(sX);
		System.out.println(sY);
		if(bgX<-3500 && bgX>-4500) {
			if (sX>=210 && sX<=255 && sY>=572 && sY<=593) {
				System.out.println("clicked");
				stage = 1;
				bgX = 0;
			}
		}
		//x=245 y=572
		//x=255 y=593
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}
}
