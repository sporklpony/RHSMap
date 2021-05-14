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
	double viewX = 0;
	double viewY = 0;
	double viewWidth = 0;
	double viewHeight = 0;
	int prevX = 0;
	int prevY = 0;
	double momentumX = 0;
	double momentumY = 0;
	double zoom = 1;
	boolean mouseDown = false;
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
		g.drawImage(map, 0, 0, getWidth(), getHeight(), (int)Math.round(viewX), (int)Math.round(viewY), (int)Math.round(viewX + viewWidth), (int)Math.round(viewY + viewHeight), this);
	}
	
	public void update() {	
		viewWidth = zoom * (getWidth() < getHeight() ? 500.0 : 500.0 / getHeight() * getWidth());
		viewHeight = zoom * (getWidth() < getHeight() ?  500.0 / getWidth() * getHeight() : 500.0);
		
		if(viewX < 0) viewX -= viewX/10.0;
		else if(viewX > map.getWidth() - viewWidth) viewX -= (viewX - map.getWidth() + viewWidth)/10.0;
		if(viewY < 0) viewY -= viewY/10.0;
		else if(viewY > map.getHeight() - viewHeight) viewY -= (viewY - map.getHeight() + viewHeight)/10.0;
		
		momentumX *= 0.9;
		momentumY *= 0.9;
		if(!mouseDown) {
			viewX -= momentumX;
			viewY -= momentumY;
		}
	} 
	
	public void run() {
		long a = System.currentTimeMillis();
		while(true) {
			update();
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
		momentumX += 0.1 * (e.getX() - prevX);
		momentumY += 0.1 * (e.getY() - prevY);
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
		mouseDown = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseDown = false;
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
