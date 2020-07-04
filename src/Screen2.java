import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Screen2 extends Screen implements KeyListener, MouseListener, ActionListener {
	private Struggle_of_Order game;
	ArrayList<BufferedImage> fields;
	int bgX = 0;
	int bgS = 1;
	int knightX = 300;
	int stage = 0;
	boolean inbattle = false;
	Timer battletimer = new Timer(1000, this);

Zombie zombie = null;

	public Screen2(Struggle_of_Order game) {
		super(game.frame);
		this.game = game;
		fields = new ArrayList<BufferedImage>();
		fields.add(tree);
		fields.add(tree);
	}

	public int[] getKeys() {
		int[] randomKeys = new int[26];
		for (int i = 0; i < randomKeys.length; i++) {
			randomKeys[i] = (int) 'a' + i;
			System.out.println((char) randomKeys[i]);
		}
		for (int i = 0; i < 1000; i++) {
			int randIndex1 = new Random().nextInt(26);
			int randIndex2 = new Random().nextInt(26);

			// index: 2, 22
			// value: c, v
			// temp = c
			// v, v
			// v, c swapped!

			int temp = randomKeys[randIndex1];
			randomKeys[randIndex1] = randomKeys[randIndex2];
			randomKeys[randIndex2] = temp;
		}

		for (int i = 0; i < randomKeys.length; i++) {
			System.out.println((char) randomKeys[i]);
		}
		return randomKeys;

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
			g.drawImage(this.loser, bgX + 11000, 0, 1000, Screen.HEIGHT, null);
			g.drawImage(this.knight, knightX, 450, 250, 250, null);
		} else if (stage == 1) {
			for (int i = 0; i < 6; i++) {
				g.drawImage(this.dungeon, bgX + i * 800, 0, 1000, Screen.HEIGHT, null);

			}
			System.out.println(bgX);
			if (bgX == -2000) {
				
				// Start zombie
				if(zombie == null) {
					zombie = new Zombie(bgX);
					battletimer.start();
				}
				
				// Draw zombie if exists
				if(zombie != null) {
					zombie.DrawZombie(g);
					
					if (zombie.checkLose()) {
						game.changeScreen(game.screen4);
					}
				}

//				if (!inbattle && zombieDefeated == false) {
//					battlecount = 0;
//					inbattle = true;
//					battletimer.start();
//				}
//
//				if (inbattle) {
//
//					// lose condition
//					if (battlecount == keyPressedTime + instructionTime) {
//						inbattle = false;
//						game.changeScreen(game.screen4);
//					}
//
//					g.drawImage(this.zombie, bgX + 2450, 310, 325, 250, null);
//					g.drawImage(this.taskbar, bgX + 1950, 550, 1000, 200, null);
//					g.setFont(new Font("Arial", Font.PLAIN, 30));
//					g.setColor(Color.BLACK);
//					g.setFont(new Font("Kalam", Font.PLAIN, 30));
//					if (battlecount < instructionTime) {
//						g.drawString("You have encountered a zombie!", bgX + 2075, 655);
//					} else if (zombieDefeated == true) {
//						g.drawString(" You defeated the zombie ", bgX + 2075, 655);
//						inbattle = false;
//					} else {
//						g.drawString("time left: " + (keyPressedTime + instructionTime - battlecount), 100, 100);
//						g.setColor(Color.WHITE);
//						g.setFont(new Font("Arial", Font.PLAIN, 25));
//						g.drawString(" " + (char) keys[keyIndex], 400, 300);
//						// "" + (char)keys[ keyIndex ];
//					}
//
//				}

			}

			else {
				g.drawImage(this.knight, knightX, 450, 250, 250, null);
			}
			g.drawImage(this.SRF, bgX + 4000, 0, 1000, Screen.HEIGHT, null);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		System.out.println(key);

		if (zombie != null && zombie.inbattle && stage == 1) {
			// e.getKeyCode()
			if (Character.toLowerCase(e.getKeyCode()) == zombie.getLetter()) {
				zombie.keyIndex = zombie.keyIndex + 1;
				
				
				System.out.println(zombie.keyIndex);
				
				if (zombie.keyIndex > 25) {
					zombie.zombieDefeated = true;
					zombie.keyIndex = 0;
				}
			}
		} else if (key == KeyEvent.VK_D) {
			if (stage == 0) {
				if ((bgX <= -3100 && bgX > -4000) || (bgX <= -4200 && bgX > -5700) || bgX <= -7200 && bgX > -8000
						|| bgX <= -10100 && bgX > -11000 || bgX <= -11200 && bgX > -10000000) {
					if (knightX >= 1000) {
						knightX = 300;
						if (bgX > -4000) {
							bgX = -4000;
						} else if (bgX > -5700) {
							bgX = -5700;
						} else if (bgX > -8000) {
							bgX = -8000;
						} else if (bgX > -11000) {
							bgX = -11000;
						}
					} else {
						knightX = knightX + 200;
					}
				} else {
					// Code that moves the background
					bgX = bgX - 100;
					if (bgX == -11200) {
						JOptionPane.showMessageDialog(null, "I'm sorry to tell you this but...");
						JOptionPane.showMessageDialog(null, "You're tonights biggest loser");

					}

				}
			} else if (stage == 1) {
				// If end of background
				if ((bgX <= -3200 && bgX > -3400) || (bgX <= -4200 && bgX > -4400)) {
					// If knight is past right side of screen
					if (knightX >= 1000) {
						knightX = 100;
						if (bgX > -4000) {
							bgX = -4000;
						}

					} else {
						// move knight to the right
						knightX = knightX + 200;
					}

					// Not end of background
				} else {

					if (inbattle == false) {
						bgX = bgX - 100;
					}

				}
			}
		}

		repaint();
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
		if (bgX < -3500 && bgX > -4500) {
			if (sX >= 210 && sX <= 255 && sY >= 572 && sY <= 593) {
				System.out.println("clicked");
				stage = 1;
				bgX = 0;

			}
		}
		// x=245 y=572
		// x=255 y=593
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		zombie.setBattleCount(zombie.battlecount+1);
		repaint();
	}
}
