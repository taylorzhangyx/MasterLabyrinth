package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pawn.Pawn;
import tile.Tile;


public class GameFunctionPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel _pawnInfo;
	private JPanel _movePanel;
	private JPanel _freeTile;
	private ArrayList<JButton> _buttons;
	private Pawn _pawn;
	public JLabel freeTile;

	private MessagePanel pawnName;
	private MessagePanel pawnColor;
	private MessagePanel pawnScore;
	private MessagePanel pawnFormularCard;
	
	/**
	 * Constructor for the GameFunctionPanel
	 * @param _gbp 
	 * 
	 * 
	 */
	GameFunctionPanel(Pawn pawn, GameBoardPanel _gbp){
		_pawn = pawn;
		setPreferredSize(new Dimension(400,400));
		setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		_pawnInfo = createPawnInfo();
		_movePanel = createMovePanel();
		_freeTile = createFreeTile(_gbp._board._freetile);
		
		
		add(_pawnInfo);
		add(_movePanel);
		add(_freeTile);
	}
	
	/*
	 *Instantiates pawns,  
	 * 
	 * @return jpl of type JPanel
	 */
	private JPanel createPawnInfo(){
		
		//initialize pawn
		initPawn();
		
		//create panel and add infos
		JPanel jpl = new JPanel();
		jpl.setPreferredSize(new Dimension(300,300));
		jpl.setLayout(new GridLayout(4,1,5,5));
		
		jpl.add(this.pawnName);
		jpl.add(this.pawnColor);
		jpl.add(this.pawnScore);
		jpl.add(this.pawnFormularCard);
		
		return jpl;
	}
	
	/**
	 * initialize pawn name, color, score, card
	 */
	private void initPawn() {
		//name is passed by arg[]
		this.pawnName = produceMessagePanel("Name: " + _pawn.getName());
		//color is the current pawn's color
		this.pawnColor = produceMessagePanel("Color: " + _pawn.getColor());
		//score updates when pick up a token
		this.pawnScore = produceMessagePanel("Score: " + _pawn.getScore());
		//magic card park for further extension
		this.pawnFormularCard = produceMessagePanel("Card: NULL");
		
	}

	/**
	 * create a message panel based on given string s
	 * @param s words appears on the message panel
	 * @return
	 */
	private MessagePanel produceMessagePanel(String s){
		MessagePanel mp = new MessagePanel(s);
		this.pawnFormularCard.setFont(new Font("Courier", Font.BOLD, 32));
		this.pawnFormularCard.setCentered(true);
		return mp;
	}
	
	
	/*
	 * Creates Move panel
	 * 
	 * @return jpl of type JPanel 
	 */
	private JPanel createMovePanel(){
		JPanel jpl = new JPanel();
		jpl.setLayout(new GridLayout(2,3,5,5));
		//initial buttons icon
		_buttons = new ArrayList<JButton>(8);
		_buttons.add(new JButton(new ImageIcon(getClass().getResource("/image/functionpanel/check.png"))));//check
		_buttons.add(new JButton(new ImageIcon(getClass().getResource("/image/functionpanel/moveDirectionUp.png"))));//move up
		_buttons.add(new JButton(new ImageIcon(getClass().getResource("/image/functionpanel/END.png"))));//end
		_buttons.add(new JButton(new ImageIcon(getClass().getResource("/image/functionpanel/moveDirectionLeft.png"))));//move left
		_buttons.add(new JButton(new ImageIcon(getClass().getResource("/image/functionpanel/moveDirectionDown.png"))));//move down
		_buttons.add(new JButton(new ImageIcon(getClass().getResource("/image/functionpanel/moveDirectionRight.png"))));//move right
		for(int i = 0; i < 6; i++)
			jpl.add(_buttons.get(i));
		
		return jpl;
	}
	/*
	 * Instantiates freeTile
	 * 
	 * @return jpl of type JPanel
	 */
	private JPanel createFreeTile(Tile _freetile){
		JPanel jpl = new JPanel();
		jpl.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		_buttons.add(new JButton(new ImageIcon(getClass().getResource("/image/functionpanel/AntiClockwise.png"))));
		jpl.add(_buttons.get(6));
		freeTile = new JLabel(_freetile.getIcon());
		jpl.add(freeTile);
		_buttons.add(new JButton(new ImageIcon(getClass().getResource("/image/functionpanel/Clockwise.png"))));
		jpl.add(_buttons.get(7));
		return jpl;
	}
	
	//return the buttons inside panel
	public ArrayList<JButton> getButtons(){
		return _buttons;
	}
	/**
	 * used when the pawn switches to a new one 
	 * 
	 * @param newPawn 
	 */
	public void switchPawn(Pawn newPawn){
		this._pawn = newPawn;
		this.pawnColor.setMessage("Color: " + _pawn.getColor());
		this.pawnName.setMessage("Name: " + _pawn.getName());
		this.pawnScore.setMessage("Score: " + _pawn.getScore());
		this.pawnFormularCard.setMessage("Card: NULL"); 
	}
	
	/**
	 * this method is used when a pawn has picked up a token
	 */
	public void setScore(){
		this.pawnScore.setMessage("Score: " + _pawn.getScore());
	}
	
	/**
	 * this method runs when the game goes into the pawn moving part
	 * enable five moving buttons except pick up button and disable rotation button
	 * 
	 * @return void
	 */
	public void enablePawnMovingButtons(){
		for(int i=1; i<_buttons.size(); i++){
			if(i<6){
				_buttons.get(i).setEnabled(true);
			}
			else{
				_buttons.get(i).setEnabled(false);
			}
		}
	}
	
	/**
	 * this method runs when the game goes into the insertion part
	 * disable six moving buttons includes pick up button and enable two rotation buttons
	 * 
	 * @return void
	 */
	public void disablePawnMovingButtons(){
		for(int i=0; i<_buttons.size(); i++)
			if(i<6){
				_buttons.get(i).setEnabled(false);
			}
			else{
				_buttons.get(i).setEnabled(true);
			}
				
	}
}
