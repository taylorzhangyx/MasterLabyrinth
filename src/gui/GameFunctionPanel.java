package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GameFunctionPanel extends JPanel {
	private JPanel _pawnInfo;
	private JPanel _movePanel;
	private JPanel _freeTile;
	private ArrayList<JButton> _buttons;
	public static JLabel freeTile;
	
	
	GameFunctionPanel(){
		_buttons = new ArrayList<JButton>();
		setPreferredSize(new Dimension(400,400));
//		setLayout(new BorderLayout(10,10));
		setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		_pawnInfo = createPawnInfo();
		_movePanel = createMovePanel();
		_freeTile = createFreeTile();
		
		add(_pawnInfo);
		add(_movePanel);
		add(_freeTile);
//		add(_pawnInfo, BorderLayout.NORTH);
//		add(_movePanel, BorderLayout.CENTER);
//		add(_freeTile, BorderLayout.SOUTH);
	}
	
	private JPanel createPawnInfo(){
		MessagePanel pawnName = new MessagePanel("Name: Pawn1");
		MessagePanel pawnColor = new MessagePanel("Color: Red");
		MessagePanel pawnScore = new MessagePanel("Score: 0");
		MessagePanel pawnFormularCard = new MessagePanel("Card: NULL");
		
		JPanel jpl = new JPanel();
		jpl.setLayout(new GridLayout(4,1,5,5));
		
		jpl.add(pawnName);
		jpl.add(pawnColor);
		jpl.add(pawnScore);
		jpl.add(pawnFormularCard);
		
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
}
