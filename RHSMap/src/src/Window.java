package src;

import javax.swing.JFrame;

public class Window extends JFrame {
	public Window() {
		setVisible(true);
		setFocusable(true);
		setSize(500, 500);
		add(new Main());
	}
	
	public static void main(String[] args) {
		System.out.println("Program Starting, yeet!");
		new Window();
	}
}
