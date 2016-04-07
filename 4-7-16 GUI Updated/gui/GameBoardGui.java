package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;



public class GameBoardGui{
	private ArrayList<JButton> _insertButtons;
	private Dimension d = new Dimension(100,100); 
	private JFrame frame;
	private JPanel center;
	private ArrayList<JLabel> _tiles;
	private JFrame _scoreHolder;
	
	
	
	
	public GameBoardGui() {
		//we have a JLabel arraylist so that we can access the jlabels in the future. These labels will be used to show our tiles
		_tiles = new ArrayList<JLabel>();
		
		//jframe that holds the scores
		_scoreHolder = new JFrame("Score");
		_scoreHolder.setBounds(1000, 0, 500, 945);
		_scoreHolder.setVisible(true);
		_scoreHolder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//jframe holds the jpanels and everything in the jpanels
		frame = new JFrame("Game");
		frame.setVisible(true);
		frame.setBounds(0, 0, 1000, 945);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//jpanels are created
		JPanel top = new JPanel();
		JPanel bottom = new JPanel();
		JPanel centerComponentLeft = new JPanel();
		JPanel centerComponentRight = new JPanel();
		JPanel centerComponentCenter = new JPanel();
		JPanel center = new JPanel();
		
		//buttons are created and added to an arraylist to be accessed in the future
		_insertButtons = new ArrayList<JButton>();
		for (int i = 0; i<12;i++){
			JButton b = new JButton();
			b.setPreferredSize(d);
			b.setBackground(new Color(238, 238, 238));
			Border border = new LineBorder(new Color(238,238,238));
			b.setBorder(border);
			_insertButtons.add(b);
		}
		
		//the jpanels are added to the jframe in a specific layout
		frame.add(top, BorderLayout.NORTH);
		frame.add(bottom, BorderLayout.SOUTH);
		frame.add(center, BorderLayout.CENTER);
		
		// the center jpanel will have 3 jpanels in it
		center.add(centerComponentLeft);
		center.add(centerComponentCenter);
		center.add(centerComponentRight);
		
		//each jpanel has its own layout
		GridLayout sides = new GridLayout(0, 1, 0, 100);
		FlowLayout tb = new FlowLayout(FlowLayout.CENTER, 100, 0);
		centerComponentCenter.setLayout(new GridLayout(7,7));
		centerComponentLeft.setLayout(sides);
		centerComponentRight.setLayout(sides);
		top.setLayout(tb);
		bottom.setLayout(tb);
		
		// the for loops add the jbuttons to the top bottom left and right
		for (int i = 0; i<49; i++){
			JLabel l = new JLabel(new ImageIcon(getClass().getResource("/resources/T01.png")));
			l.setText("");
			_tiles.add(l);
			centerComponentCenter.add(l);
			
		}
		
		for (int o = 9;o<12; o++){
			JButton temp = _insertButtons.get(o);
			temp.setIcon(new ImageIcon(getClass().getResource("/resources/3.png")));
			centerComponentLeft.add(temp);
		}
		
		for (int p = 3; p<6;p++){
			JButton temp = _insertButtons.get(p);
			temp.setIcon(new ImageIcon(getClass().getResource("/resources/1.png")));
			centerComponentRight.add(temp);
		}
		
		for (int u = 0;u<3;u++){
			JButton temp = _insertButtons.get(u);
			temp.setIcon(new ImageIcon(getClass().getResource("/resources/0.png")));
			top.add(temp);
		}
		
		for (int y = 6; y<9;y++){
			JButton temp = _insertButtons.get(y);
			temp.setIcon(new ImageIcon(getClass().getResource("/resources/2.png")));
			
			bottom.add(temp);
		}
	
	}
	public ArrayList<JLabel> getBoard(){
		return _tiles;
	}
	
	
	
}
	

