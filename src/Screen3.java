import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Screen3 extends Screen implements MouseListener {
	private Struggle_of_Order game;
	JPanel b;
	JButton back;
	JTextField textfield1;
	public Screen3(JFrame frame) {
		super(frame);
		
	}
	public Screen3(Struggle_of_Order struggle_of_Order) {
		super(struggle_of_Order.frame);
		this.game = struggle_of_Order;
	}
	public void setup() {
		game.frame.setPreferredSize(new Dimension(1000, Screen.HEIGHT));
		game.frame.pack();
		game.frame.addMouseListener(this);
		back = new JButton(" Back ");
		this.setFocusable(true);
		this.repaint();
		game.frame.repaint();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.kingdom, 0, 0, 1000, Screen.HEIGHT, null);
		g.drawImage(this.npc, 25, 250, 425, 400, null);
		g.drawImage(this.taskbar,0 , 550, 1000, 200, null);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
