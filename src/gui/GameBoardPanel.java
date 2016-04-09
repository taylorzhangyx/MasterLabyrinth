package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.*;

import board.Board;
import tile.*;

public class GameBoardPanel extends JPanel{
	
	private JPanel topPanel;
	private JPanel bottomPanel;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JPanel centerPanel; //hold the board
	//if we want to change the color of arrow with corresponding availability of insertion point
	// we need to create unique button for each arrow and linked them with last insertion position
	public static Board _board = new Board();
	
	public GameBoardPanel() {
		
		setLayout(new BorderLayout());
		_board.createGameBoard();
		_board.populateBoard();
		
		topPanel = setArrowPanel(1, 9, "North");
		bottomPanel = setArrowPanel(1, 9, "South");
		leftPanel = setArrowPanel(7, 1, "West");
		rightPanel = setArrowPanel(7, 1, "East");
		centerPanel = setBoard();
		
		add(topPanel,BorderLayout.NORTH);
		add(leftPanel,BorderLayout.WEST);
		add(centerPanel,BorderLayout.CENTER);
		add(rightPanel,BorderLayout.EAST);
		add(bottomPanel,BorderLayout.SOUTH);
	  }
	
	  public static void main(String[] args) {
		  GameBoardPanel gb = new GameBoardPanel();
	  }
	  
	  /**
	   * set Board based on _board info
	   * 
	   * @return a JPanel contains a new board
	   */
	  private JPanel setBoard(){
		  JPanel _board = new JPanel();
		  _board.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		  _board.setPreferredSize(new Dimension(700,700));
		  for(int i = 0; i < 7; i++){
			  for(int j = 0; j < 7; j++){
				  //store each image to this panel
				  _board.add(this._board._gameBoard[i][j].getImage());
			  }
		  }
		  
		  return _board;
	  }
	  
	  
	  /**
	   * set the edge panel to display arrow that points to insertion point
	   * 
	   * @param row
	   * @param column
	   * @param direction
	   * @return
	   */
	  private JPanel setArrowPanel(int row, int column, String direction){
		  JPanel jpl = new JPanel();
//		  jpl.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		  jpl.setLayout(new GridLayout(row, column,0,10));
//		  jpl.setPreferredSize(new Dimension(row, column));
//		  JButton jbt = new JButton();
//		  jbt.setIcon(new ImageIcon(getClass().getResource("/image/arrow/arrowOn" + direction + ".png")));
		  
		  if(column == 9){
			  jpl.add(new JLabel("  "));
		  }
		  
		  jpl.add(new JLabel("  "));
		  jpl.add(new JButton(new ImageIcon(getClass().getResource("/image/arrow/arrowOn" + direction + ".png"))));
		  jpl.add(new JLabel("  "));
		  jpl.add(new JButton(new ImageIcon(getClass().getResource("/image/arrow/arrowOn" + direction + ".png"))));
		  jpl.add(new JLabel("  "));
		  jpl.add(new JButton(new ImageIcon(getClass().getResource("/image/arrow/arrowOn" + direction + ".png"))));
		  jpl.add(new JLabel("  "));
		  
		  if(column == 9){
			  jpl.add(new JLabel("  "));
		  }
		  
		  return jpl;
	  }
}
