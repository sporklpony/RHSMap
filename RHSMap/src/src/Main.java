package src;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;

import javax.swing.JPanel;

public class Main extends JPanel implements Runnable {
	
	public Main() {
		setVisible(true);
		setFocusable(true);
		new Thread(this).start();
	}
	
	public void paint(Graphics g) {
		g.setColor(new Color(0, 0, 0));
		g.fillRect(0, 0, getWidth(), getHeight());
	}
	
	public void run() {
		long a = System.currentTimeMillis();
		while(true) {
			repaint();
			
			if(a < 30) try {
				Thread.sleep(30 - a);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			a = System.currentTimeMillis();
		}
	}
}
