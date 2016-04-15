package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import board.Board;
import tile.*;

public class GameBoardPanel extends JPanel{
	
	private JPanel topPanel;
	private JPanel bottomPanel;
	private JPanel leftPanel;
	private JPanel rightPanel;
	public JPanel centerPanel; //hold the board
	private ArrayList<JButton> _buttons;
	public ArrayList<JLabel> _labels;

	//if we want to change the color of arrow with corresponding availability of insertion point
	// we need to create unique button for each arrow and linked them with last insertion position
	
	public static Board _board;
	

	/*
	 * Constructor for GameBoardPanel; Instantiates board
	 * 
	 */
	  public GameBoardPanel(String[] names) {
		  _board = new Board();
			_buttons = new ArrayList<JButton>();
			_labels = new ArrayList<JLabel>();
			setLayout(new BorderLayout());
			setPreferredSize(new Dimension(200, 0));
			_board.createGameBoard();
			_board.populateBoard();
			_board.setPawnName(names);
			_board.updatePawnXYPosition();
			
			topPanel = topAndBottomPanel("North");
			rightPanel = setArrowPanel("East");
			
			bottomPanel = topAndBottomPanel("South");
			
			leftPanel = setArrowPanel( "West");
			centerPanel = setBoard();
			
			add(topPanel,BorderLayout.NORTH);
			add(leftPanel,BorderLayout.WEST);
			add(centerPanel,BorderLayout.CENTER);
			add(rightPanel,BorderLayout.EAST);
			add(bottomPanel,BorderLayout.SOUTH);
	}
/*
 * Create JPanel
 * 
 * @return p of type JPanel
 */
	private JPanel topAndBottomPanel(String s) {
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));
		for (int i =0;i<3;i++){
			JButton b = new JButton(new ImageIcon(getClass().getResource("/image/arrow/arrowOn"+s+".png")));
			b.setOpaque(false);
			b.setContentAreaFilled(false);
			b.setBorderPainted(false);
			b.setPreferredSize(new Dimension(99,99));
			p.add(b);
			_buttons.add(b);
		}
		  return p;
		
		
	}

	  
	  /**
	   * set Board based on _board info
	   * 
	   * @return a JPanel contains a new board
	   */
	  public JPanel setBoard(){
		  
		  JPanel _board = new JPanel();
		  
		  _board.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		 // _board.setPreferredSize(new Dimension(600,0));
		  
		  for(int i = 0; i < 7; i++){
			  for(int j = 0; j < 7; j++){
				  //store each image to this panel
				  //_board.add(this._board._gameBoard[i][j].getImage());
				  JLabel label = new JLabel(GameBoardPanel._board._gameBoard[i][j].getIcon());
				  
				  label.setLayout(new GridLayout(0,1));
				  label.add(setPawnAndTokenImageOnTile(i,j));
				  _labels.add(label);
				  _board.add(_labels.get(7*i+j));
			  }
		  }
		  
		  return _board;
	  }
	  
	  /**
	   * get a JLabel that holds all the pawns' and tokens' image on the tile[x][y]
	   * 
	   * @param x
	   * @param y
	   * @return
	   */
	  public static JLabel setPawnAndTokenImageOnTile(int x, int y){
		  
//		  JLabel Biglabel = new JLabel();
//		  Biglabel.setLayout(new GridLayout(0,2,0,0));
//		  Biglabel.setPreferredSize(new Dimension(90,90));
		  
		  JLabel label = new JLabel();
//		  Border border = BorderFactory.createLineBorder(Color.BLACK);
		  int pawnNum = GameBoardPanel._board._gameBoard[x][y].numOfPawns();
//		  int tokenNum = 0;
//		  if(GameBoardPanel._board._gameBoard[x][y].hasToken()){
//			  tokenNum = 1;
//		  }
//		  
//		  if(pawnNum + tokenNum > 2){
//			  label.setLayout(new GridLayout(0,2,0,0));
//			  
//		  }
//		  else{
//			  label.setLayout(new GridBagLayout());
//		  }
		  
//		  label.setPreferredSize(new Dimension(0,90));
//		  label.setLayout(new GridBagLayout());
		  
//		  label.setBorder(border);
		  if(GameBoardPanel._board._gameBoard[x][y].hasPawn()){
			  for(int i = 0; i < pawnNum; i++){
				  label.add(GameBoardPanel._board.getPawn(GameBoardPanel._board.gameBoard()[x][y].pawnsOnTile().get(i)).getImage());
			  }
		  }
		  
		  if(GameBoardPanel._board._gameBoard[x][y].hasToken()){
			  label.add(GameBoardPanel._board._gameBoard[x][y].getToken().getImage());
//			  label.add(new JButton(""+x+y));
		  }
//		  label.add(Biglabel);
		  return label;
	  }
	  
	  
	  
	  
	  /**
	   * set the edge panel to display arrow that points to insertion point
	   * 
	   * @param row
	   * @param column
	   * @param direction
	   * @return
	   */
	  private JPanel setArrowPanel(String direction){
		  JPanel jpl = new JPanel();
		  jpl.setLayout(new GridLayout(7,1,10,10));
//		  jpl.setLayout(new FlowLayout(FlowLayout.CENTER));
		  jpl.setPreferredSize(new Dimension(99	, 0));
//		  JButton jbt = new JButton();
//		  jbt.setIcon(new ImageIcon(getClass().getResource("/image/arrow/arrowOn" + direction + ".png")));
		  
		  jpl.add(new JLabel("  "));
		  JButton b = new JButton(new ImageIcon(getClass().getResource("/image/arrow/arrowOn" + direction + ".png")));
		  b.setPreferredSize(new Dimension(100,100));
		  b.setOpaque(false);
		  b.setContentAreaFilled(false);
		  b.setBorderPainted(false);
		  jpl.add(b);
		  _buttons.add(b);
		  jpl.add(new JLabel("  "));
		  JButton b1 = new JButton(new ImageIcon(getClass().getResource("/image/arrow/arrowOn" + direction + ".png")));
		  b1.setPreferredSize(new Dimension(100,100));
		  b1.setOpaque(false);
		  b1.setContentAreaFilled(false);
		  b1.setBorderPainted(false);
		  jpl.add(b1);
		  _buttons.add(b1);
		  jpl.add(new JLabel("  "));
		  JButton b2 = new JButton(new ImageIcon(getClass().getResource("/image/arrow/arrowOn" + direction + ".png")));
		  b2.setPreferredSize(new Dimension(100,100));
		  b2.setOpaque(false);
		  b2.setContentAreaFilled(false);
		  b2.setBorderPainted(false);
		  jpl.add(b2);
		  _buttons.add(b2);
		  jpl.add(new JLabel("  "));
		  
		  return jpl;
	  }
	  public ArrayList<JButton> getButtons(){
		  return _buttons;
	  }
	  public ArrayList<JLabel> getLabels(){
		  return _labels;
	  }
	  
	  /**
	   * disable the insertion buttons
	   */
	  public void disableInsertionButton(){
		  for(int i=0; i<_buttons.size(); i++){
			  _buttons.get(i).setEnabled(false);
		  }
	  }
	  
	  /**
	   * enable the insertion buttons
	   * 
	   * @return void
	   */
	  public void enableInsertionButton(){
		  for(int i=0; i<_buttons.size(); i++){
			  _buttons.get(i).setEnabled(true);
		  }
	  }
}
