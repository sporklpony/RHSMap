package src;

import javax.swing.JFrame;

public class Window extends JFrame {
	public Window() {
		setSize(500, 500);
		add(new Main());
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		System.out.println("Program Starting, yeet!");
		new Window();
	}
}
