package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FrameTest {
	private static GameFunctionPanel _gfp;
	private static GameBoardPanel _gbp;
	private static ArrayList<JButton> _gfpb;
	private static JFrame jfr;
	public static void main(String[] args) {
		if (args.length<5&&args.length!=0){
		FrameTest f = new FrameTest(args);
		}
	}
		public FrameTest(String[] names){
			
			_gbp = new GameBoardPanel();
			_gfp = new GameFunctionPanel();
			
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
			
			//adds functionality to the rotate buttons
			_gfpb.get(6).addActionListener(new RotateCounterClockwiseButtonHandler(_gbp._board,this));
			_gfpb.get(7).addActionListener(new RotateClockwiseButtonHandler(_gbp._board,this));
			
			
		}
		
		
		
		
		
		
		/*
		_gfpb.get(6).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				_gbp._board.InsertTile(0, 3, _gbp._board._freetile);
				update();
				
			}
			
		});
*/
		
		
		

	public static void update() {
		for (int i=0; i<7;i++){
			for(int o = 0;o<7;o++){
				_gbp.getLabels().get(7*i+o).setIcon(_gbp._board._gameBoard[i][o].getIcon());
				if (_gbp._board._gameBoard[i][o].hasPawn()){
					
				}
				if (_gbp._board._gameBoard[i][o].hasToken()){
					
				}
			}
		}
		
		_gbp._board._freetile.refreshImage();
		_gfp.freeTile.setIcon(_gbp._board._freetile.getIcon());
		
	}
}
