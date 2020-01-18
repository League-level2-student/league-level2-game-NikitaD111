import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Screen2 extends Screen {
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
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.tree, -1, 0, Screen.WIDTH, Screen.HEIGHT, null);
		g.drawImage(this.knight, 300, 500, 250, 250, null);
	}
	}

