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
		setBackground(new Color(255, 255, 255));
		g.clearRect(0, 0, getWidth(), getHeight());
		g.drawString("Hello", 0, 0);
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
