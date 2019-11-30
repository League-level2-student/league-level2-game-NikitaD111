import java.awt.Graphics;

import javax.swing.JFrame;

public class Screen2 extends Screen {
	public Screen2(JFrame frame) {
		super(frame);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.market, -1, 0, Screen.WIDTH, Screen.HEIGHT, null);
	}
}
