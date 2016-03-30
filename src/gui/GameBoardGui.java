package gui;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.*;

import board.Board;
import tile.*;

public class GameBoardGui extends JFrame{
	
	public GameBoardGui() {
		
		Board b = new Board();
		b.createGameBoard();
		b.populateBoard();
		Tile[][] boardToBeDisplayed = b._gameBoard;
	    JFrame f = new JFrame();
	    f.setVisible(true);
	    
	    f.setLayout(new GridLayout(7,7));
	    for(int i = 0; i < 7; i++){
	    	for(int j = 0; j < 7; j++){
	    		JButton tileShown = new JButton();
	    		
	    		f.add(tileShown);
	
	    	}
	    }
	    
	    f.setSize(1000, 1000);
	    f.setLocationRelativeTo(null);
	    f.setLocation(100, 100);
	    f.setDefaultCloseOperation(EXIT_ON_CLOSE);
	  }
	
	  public static void main(String[] args) {
		  GameBoardGui gb = new GameBoardGui();
	  }
}
