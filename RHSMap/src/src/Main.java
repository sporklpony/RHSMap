package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import src.ZoomButton;

public class Main extends JPanel implements Runnable, MouseMotionListener, MouseListener {
	int viewX = 0;
	int viewY = 0;
	int prevX = 0;
	int prevY = 0;
	double zoom = 1;
	BufferedImage map;

	public Main() {
		try {
			map = ImageIO.read(new File("src/resources/map.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setVisible(true);
		setFocusable(true);
		addMouseListener(this);
		addMouseMotionListener(this);

		new Thread(this).start();
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(map, 0, 0, getWidth(), getHeight(), viewX, viewY, viewX + (int)(zoom * (getWidth() < getHeight() ? 500 : 500.0 / getHeight() * getWidth())), viewY + (int)(zoom * (getWidth() < getHeight() ?  500.0 / getWidth() * getHeight() : 500)), this);
	}
	
	public void run() {
		long a = System.currentTimeMillis();
		while(true) {
			if(viewX < 0) viewX += Math.ceil(-viewX/10.0);
			else if(viewX > map.getWidth() - getWidth()) viewX -= Math.ceil((viewX - map.getWidth() + getWidth())/10.0);
			if(viewY < 0) viewY += Math.ceil(-viewY/10.0);
			else if(viewY > map.getHeight() - getHeight()) viewY -= Math.ceil((viewY - map.getHeight() + getHeight())/10.0);
			
			repaint();
			
			if(System.currentTimeMillis() - a < 30) try {
				Thread.sleep(30 - System.currentTimeMillis() + a);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			a = System.currentTimeMillis();
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		viewX -= e.getX() - prevX;
		viewY -= e.getY() - prevY;
		prevX = e.getX();
		prevY = e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		prevX = e.getX();
		prevY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
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
}
