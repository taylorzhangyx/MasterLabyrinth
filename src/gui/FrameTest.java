package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import pawn.Pawn;

public class FrameTest {
	private static GameFunctionPanel _gfp;
	private static GameBoardPanel _gbp;
	private static ArrayList<JButton> _gfpb;
	private static JFrame jfr;
	//current player
	private static Pawn _pawn;
	
	
	public static void main(String[] args) {
		if (args.length<5&&args.length!=0){
		FrameTest f = new FrameTest(args);
		}
	}
		public FrameTest(String[] names){
			
			_gbp = new GameBoardPanel();
			//when initialize, set pawn to the first player
			_pawn = _gbp._board.getPawn("red");
			
			_gfp = new GameFunctionPanel(_pawn);
			
			jfr = new JFrame();
			jfr.setLayout(new BorderLayout(5,5));
			jfr.setSize(1302, 925);
			jfr.add(_gbp, BorderLayout.CENTER);
			jfr.add(_gfp, BorderLayout.EAST);
			jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jfr.setLocationRelativeTo(null);
			jfr.setVisible(true);
			jfr.setResizable(false);
			_gfpb = _gfp.getButtons();
			
			//adds functionality to the insert buttons
			_gbp.getButtons().get(0).addActionListener(new InsertButtonHandler(_gbp._board, this, 0, 1));
			_gbp.getButtons().get(1).addActionListener(new InsertButtonHandler(_gbp._board, this, 0, 3));
			_gbp.getButtons().get(2).addActionListener(new InsertButtonHandler(_gbp._board, this, 0, 5));
			_gbp.getButtons().get(3).addActionListener(new InsertButtonHandler(_gbp._board, this, 1, 6));
			_gbp.getButtons().get(4).addActionListener(new InsertButtonHandler(_gbp._board, this, 3, 6));
			_gbp.getButtons().get(5).addActionListener(new InsertButtonHandler(_gbp._board, this, 5, 6));
			_gbp.getButtons().get(6).addActionListener(new InsertButtonHandler(_gbp._board, this, 6, 1));
			_gbp.getButtons().get(7).addActionListener(new InsertButtonHandler(_gbp._board, this, 6, 3));
			_gbp.getButtons().get(8).addActionListener(new InsertButtonHandler(_gbp._board, this, 6, 5));
			_gbp.getButtons().get(9).addActionListener(new InsertButtonHandler(_gbp._board, this, 1, 0));
			_gbp.getButtons().get(10).addActionListener(new InsertButtonHandler(_gbp._board, this, 3, 0));
			_gbp.getButtons().get(11).addActionListener(new InsertButtonHandler(_gbp._board, this, 5, 0));
			
			//adds functionality to the moving pawn buttons
			_gfpb.get(1).addActionListener(new PawnMovingButtonHandler(_gbp._board,this,_pawn,"N"));
			_gfpb.get(3).addActionListener(new PawnMovingButtonHandler(_gbp._board,this,_pawn,"W"));
			_gfpb.get(4).addActionListener(new PawnMovingButtonHandler(_gbp._board,this,_pawn,"S"));
			_gfpb.get(5).addActionListener(new PawnMovingButtonHandler(_gbp._board,this,_pawn,"E"));
			
			//adds functionality to pick up token method
			_gfpb.get(0).addActionListener(new PawnPickUpTokenButtonHandler(_gbp._board,this,_pawn));
			
			//adds functionality to the rotate buttons
			_gfpb.get(6).addActionListener(new RotateCounterClockwiseButtonHandler(_gbp._board,this));
			_gfpb.get(7).addActionListener(new RotateClockwiseButtonHandler(_gbp._board,this));
			
			
		}
		

	public static void update() {
		for (int i=0; i<7;i++){
			for(int o = 0;o<7;o++){
				//clear all components on the JLabel
				_gbp.getLabels().get(7*i+o).removeAll();
				
				_gbp.getLabels().get(7*i+o).setIcon(_gbp._board._gameBoard[i][o].getIcon());
				_gbp.getLabels().get(7*i+o).add(GameBoardPanel.setPawnAndTokenImageOnTile(i,o));
				_gbp.getLabels().get(7*i+o).validate();
				_gbp.getLabels().get(7*i+o).repaint();
				
			}
		}
		
		_gbp._board._freetile.refreshImage();
		_gfp.freeTile.setIcon(_gbp._board._freetile.getIcon());
	}
	
	public static void updateScore() {
		_gfp.setScore();
	}
}
