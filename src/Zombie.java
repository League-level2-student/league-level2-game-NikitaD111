import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.Timer;

public class Zombie implements KeyListener {
	public boolean inbattle = false;
	int battlecount = 0;
	public int[] keys;
	int keyIndex = 0;
	public boolean zombieDefeated = false;
	int keyPressedTime = 26;
	int instructionTime = 6;
	int bgX;

	public Zombie(int bgX) {
		this.bgX = bgX;
		keys = getKeys();
	}

	public void setBattleCount(int battlecount) {
		this.battlecount = battlecount;
	}

	public int getLetter() {
		return keys[keyIndex];
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

	public boolean checkLose() {
		return zombieDefeated == false && battlecount >= keyPressedTime + instructionTime;
	}

	public void DrawZombie(Graphics g) {

		if (!inbattle && zombieDefeated == false) {
			battlecount = 0;
			inbattle = true;
		}
		if (bgX == -2000) {
			if (inbattle) {

				// lose condition
				if (battlecount == keyPressedTime + instructionTime) {
					inbattle = false;

				}

				g.drawImage(Screen.zombie, bgX + 2450, 310, 325, 250, null);
				g.drawImage(Screen.taskbar, bgX + 1950, 550, 1000, 200, null);
				g.setFont(new Font("Arial", Font.PLAIN, 30));
				g.setColor(Color.BLACK);
				g.setFont(new Font("Kalam", Font.PLAIN, 30));
				if (battlecount < instructionTime) {
					g.drawString("You have encountered a zombie!", bgX + 2075, 655);
				} else if (zombieDefeated == true) {
					g.drawString(" You defeated the zombie ", bgX + 2075, 655);
					inbattle = false;
				} else {
					g.drawString("time left: " + (keyPressedTime + instructionTime - battlecount), 100, 100);
					g.setColor(Color.WHITE);
					g.setFont(new Font("Arial", Font.PLAIN, 25));
					g.drawString(" " + (char) keys[keyIndex], 400, 300);
					// "" + (char)keys[ keyIndex ];
				}

			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
