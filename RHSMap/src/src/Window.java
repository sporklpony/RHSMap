package src;

import javax.swing.JFrame;

public class Window extends JFrame {
	public Window() {
		add(new Main());
		setVisible(true);
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		System.out.println("Program Starting, yeet!");
		new Window();
	}
}
