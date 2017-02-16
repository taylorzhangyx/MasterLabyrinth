package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import board.Board;

public class GameBoardPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel centerPanel; //hold the board
	public ArrayList<JLabel> _labels;
	
	private JPanel topPanel;
	private JPanel bottomPanel;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private ArrayList<JButton> _buttons;

	//if we want to change the color of arrow with corresponding availability of insertion point
	// we need to create unique button for each arrow and linked them with last insertion position
	
	public Board _board;
	

	/*
	 * Constructor for GameBoardPanel; Instantiates board
	 * 
	 */
	public GameBoardPanel(String[] names) {
		//prepare board
		buildBoard(names);
		
		_buttons = new ArrayList<JButton>();
		_labels = new ArrayList<JLabel>();
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(200, 0));
		
		//initial 5 panel on the panel
		topPanel = topAndBottomPanel("North");
		rightPanel = setArrowPanel("East");
		bottomPanel = topAndBottomPanel("South");
		leftPanel = setArrowPanel( "West");
		centerPanel = setBoard();
		
		//add 5 panels to the panel
		add(topPanel,BorderLayout.NORTH);
		add(leftPanel,BorderLayout.WEST);
		add(centerPanel,BorderLayout.CENTER);
		add(rightPanel,BorderLayout.EAST);
		add(bottomPanel,BorderLayout.SOUTH);
	}
	
	/**
	 * 
	 * @param s
	 */
	private void buildBoard(String[] s) {
	_board = new Board();
	_board.createGameBoard();
	_board.populateBoard();
	_board.setPawnName(s);
	_board.updatePawnXYPosition();
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
		  
		  JPanel board = new JPanel();
		  
		  board.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		  
		  for(int i = 0; i < 7; i++){
			  for(int j = 0; j < 7; j++){
				  //store each image to this panel
				  JLabel label = new JLabel(this._board._gameBoard[i][j].getIcon());
				  label.setLayout(new GridLayout(0,1));
				  label.add(setPawnAndTokenImageOnTile(i,j));
				  _labels.add(label);
				  board.add(label);
			  }
		  }
		  
		  return board;
	  }
	  
	  /**
	   * get a JLabel that holds all the pawns' and tokens' image on the tile[x][y]
	   * 
	   * @param x
	   * @param y
	   * @return
	   */
	  public JLabel setPawnAndTokenImageOnTile(int x, int y){
		  
		  JLabel label = new JLabel();
		  int pawnNum = this._board._gameBoard[x][y].numOfPawns();
		  int tokenNum = 0;
		  if(this._board._gameBoard[x][y].hasToken()){
			  tokenNum = 1;
		  }
		  
		  if(pawnNum + tokenNum > 2){
			  label.setLayout(new GridLayout(0,2,0,0));
		  }
		  else{
			  label.setLayout(new GridBagLayout());
		  }
		  if(this._board._gameBoard[x][y].hasPawn())
		  {
			  for(int i = 0; i < pawnNum; i++)
			  {
				  label.add(this._board.getPawn(this._board.gameBoard()[x][y].pawnsOnTile().get(i)).getImage());
			  }
		  }
		  
		  if(this._board._gameBoard[x][y].hasToken()){
			  label.add(this._board._gameBoard[x][y].getToken().getImage());
		  }
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
		  jpl.setPreferredSize(new Dimension(99	, 0));
		  
		  jpl.add(new JLabel("  "));
		  //fill the panel within a loop
		  //add button and empty label repeatedly 
		  for(int i = 0 ; i < 3 ; i ++){
			  JButton b  = productArrayButton(direction);
			  jpl.add(b);
			  _buttons.add(b);
			  jpl.add(new JLabel("  "));
		  }		  
		  return jpl;
	  }
 
	  
	  /**
	   * Generate a button based on given String, with corresponding icon
	   * 
	   * @param direction: a string representing button position
	   * @return
	   */
	private JButton productArrayButton(String direction) {
		JButton b = new JButton(new ImageIcon(getClass().getResource("/image/arrow/arrowOn" + direction + ".png")));
		b.setPreferredSize(new Dimension(100,100));
		b.setOpaque(false);
		b.setContentAreaFilled(false);
		b.setBorderPainted(false);
		return b;
	}
	
	/**
	 * return the buttons in game board panel
	 * 
	 * @return
	 */
	public ArrayList<JButton> getButtons(){
		  return _buttons;
	  }
	
	/**
	 * acquire labels in game board panel
	 * @return
	 */
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
