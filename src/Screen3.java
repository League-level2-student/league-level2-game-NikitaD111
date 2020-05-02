import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Screen3 extends Screen implements MouseListener, ActionListener {
	private Struggle_of_Order game;
	JPanel b;
	JButton back;
	JTextField textfield1;
	JLabel text;
	public Screen3(JFrame frame) {
		super(frame);
		
	}
	public Screen3(Struggle_of_Order struggle_of_Order) {
		super(struggle_of_Order.frame);
		this.game = struggle_of_Order;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	g.drawImage(this.kingdom, 0, 0, 1000, Screen.HEIGHT, null);
		g.drawImage(this.npc, 25, 250, 425, 400, null);
		g.drawImage(this.taskbar,0 , 550, 1000, 200, null);
	}
	public void setup() {
		game.frame.setPreferredSize(new Dimension(1000, Screen.HEIGHT));
		game.frame.pack();
		game.frame.addMouseListener(this);
		
		text = new JLabel( "  Choose where you want to go" );
        text.setFont( new Font( "Tahoma", ( Font.BOLD | Font.ITALIC ), 24 ) );

		this.setLayout( new GridBagLayout() );
        this.setBackground(new Color(0,0,0,0));
        this.setPreferredSize( new Dimension( Screen.WIDTH, Screen.HEIGHT / 4 ) );
        this.setMaximumSize( new Dimension( Screen.WIDTH, Screen.HEIGHT / 4 ) );
        this.setAlignmentX( Component.LEFT_ALIGNMENT );
        this.setAlignmentY( Component.BOTTOM_ALIGNMENT );
        
		addButtons();
		//textfield1 = new JTextField(50);
		//textfield1.setText(" Hello fellow knight we need some help. The kingdom is in danger and you arethe only one that can help");
		
		this.setFocusable(true);
		this.repaint();
		game.frame.repaint();
	}
	  public void addButtons() {
	        GridBagConstraints gc = new GridBagConstraints();

	        back = new JButton(" Back ");
	        back.setFocusable(false);
	        back.addActionListener(this);
		
	        gc.insets = new Insets( 20, 0, 0, 0 );

	     

	        gc.anchor = GridBagConstraints.CENTER;
	        gc.fill = GridBagConstraints.NONE;
	        gc.gridx = 1;
	        gc.gridy = 1;
	        this.add( back, gc );
	  }
	
	public void cleanUp() {
		super.cleanUp();
		game.frame.setPreferredSize(new Dimension(Screen.WIDTH, Screen.HEIGHT));
		game.frame.pack();
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
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton buttonpressed = (JButton)arg0.getSource();
		if( buttonpressed == back) {
			game.changeScreen(game.screen1);
		}
		
	}

}
