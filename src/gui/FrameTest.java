package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class FrameTest {

	public static void main(String[] args) {
		JFrame jfr = new JFrame();
		jfr.setLayout(new BorderLayout(5,5));
		jfr.setSize(1380, 940);
		jfr.add(new GameBoardPanel(), BorderLayout.CENTER);
		jfr.add(new GameFunctionPanel(), BorderLayout.EAST);
		jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfr.setLocationRelativeTo(null);
		jfr.setVisible(true);
	}

}
