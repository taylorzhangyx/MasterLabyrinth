package gui;

import java.awt.BorderLayout;
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


public class GameFunctionPanel extends JPanel {
	private JPanel _pawnInfo;
	private JPanel _movePanel;
	private JPanel _freeTile;
	private ArrayList<JButton> _buttons;
	private Pawn _pawn;
	public static JLabel freeTile;

	private MessagePanel pawnName;
	private MessagePanel pawnColor;
	private MessagePanel pawnScore;
	private MessagePanel pawnFormularCard;
	
	
	GameFunctionPanel(Pawn pawn){
		_buttons = new ArrayList<JButton>();
		_pawn = pawn;
		setPreferredSize(new Dimension(400,400));
		setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		_pawnInfo = createPawnInfo();
		_movePanel = createMovePanel();
		_freeTile = createFreeTile();
		
		
		add(_pawnInfo);
		add(_movePanel);
		add(_freeTile);
	}
	
	private JPanel createPawnInfo(){
		//name is passed by arg[]
		this.pawnName = new MessagePanel("Name: " + _pawn.getName());
		this.pawnName.setFont(new Font("Courier", Font.BOLD, 32));
		this.pawnName.setCentered(true);
		//color is the current pawn's color
		this.pawnColor = new MessagePanel("Color: " + _pawn.getColor());
		this.pawnColor.setFont(new Font("Courier", Font.BOLD, 32));
		this.pawnColor.setCentered(true);
		//score updates when pick up a token
		this.pawnScore = new MessagePanel("Score: " + _pawn.getScore());
		this.pawnScore.setFont(new Font("Courier", Font.BOLD, 32));
		this.pawnScore.setCentered(true);
		this.pawnFormularCard = new MessagePanel("Card: NULL");
		this.pawnFormularCard.setFont(new Font("Courier", Font.BOLD, 32));
		this.pawnFormularCard.setCentered(true);
		
		JPanel jpl = new JPanel();
		jpl.setPreferredSize(new Dimension(300,300));
		jpl.setLayout(new GridLayout(4,1,5,5));
		
		jpl.add(this.pawnName);
		jpl.add(this.pawnColor);
		jpl.add(this.pawnScore);
		jpl.add(this.pawnFormularCard);
		
		return jpl;
	}
	
	private JPanel createMovePanel(){
		JPanel jpl = new JPanel();
		jpl.setLayout(new GridLayout(2,3,5,5));
		_buttons.add(new JButton(new ImageIcon(getClass().getResource("/image/functionpanel/check.png"))));
		jpl.add(_buttons.get(0));
		_buttons.add(new JButton(new ImageIcon(getClass().getResource("/image/functionpanel/moveDirectionUp.png"))));
		jpl.add(_buttons.get(1));
		_buttons.add(new JButton(new ImageIcon(getClass().getResource("/image/functionpanel/END.png"))));
		jpl.add(_buttons.get(2));
		_buttons.add(new JButton(new ImageIcon(getClass().getResource("/image/functionpanel/moveDirectionLeft.png"))));
		jpl.add(_buttons.get(3));
		_buttons.add(new JButton(new ImageIcon(getClass().getResource("/image/functionpanel/moveDirectionDown.png"))));
		jpl.add(_buttons.get(4));
		_buttons.add(new JButton(new ImageIcon(getClass().getResource("/image/functionpanel/moveDirectionRight.png"))));
		jpl.add(_buttons.get(5));
		return jpl;
	}
	
	private JPanel createFreeTile(){
		JPanel jpl = new JPanel();
		jpl.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		_buttons.add(new JButton(new ImageIcon(getClass().getResource("/image/functionpanel/AntiClockwise.png"))));
		jpl.add(_buttons.get(6));
		freeTile = new JLabel(GameBoardPanel._board.getFreeTile().getIcon());
		jpl.add(freeTile);
		_buttons.add(new JButton(new ImageIcon(getClass().getResource("/image/functionpanel/Clockwise.png"))));
		jpl.add(_buttons.get(7));
		return jpl;
	}
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
	 */
	public void enablePawnMovingButtons(){
		for(int i=1; i<_buttons.size(); i++)
			if(i<6){
				_buttons.get(i).setEnabled(true);
			}
			else{
				_buttons.get(i).setEnabled(false);
			}
				
	}
	
	/**
	 * this method runs when the game goes into the insertion part
	 * disable six moving buttons includes pick up button and enable two rotation buttons
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
