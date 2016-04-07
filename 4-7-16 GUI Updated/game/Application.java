package game;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import board.Board;
import gui.GameBoardGui;
import tile.Tile;

public class Application implements Runnable {
	private GameBoardGui _gui;
	private Board _board;
	private ArrayList<JLabel> _visualTiles;
	private Tile[][] _tiles;

	@Override
	public void run() {
		// the gui is created
		_gui = new gui.GameBoardGui();
		// creates the data of the game
		_board = new Board();
		_board.createGameBoard();
		_board.populateBoard();
		_board.addTokensToBoard();
		_visualTiles = _gui.getBoard();
		_tiles = _board.getTiles();
		update();
	}

	public void update() {

		for (int i = 0; i < 7; i++) {
			for (int o = 0; o < 7; o++) {
				JLabel current = _visualTiles.get(7 * i + o);
				String temp = "T";
				if (_tiles[i][o].tileOrientation()[0]) {
					temp = temp + 0;
				}
				if (_tiles[i][o].tileOrientation()[1]) {
					temp = temp + 1;
				}
				if (_tiles[i][o].tileOrientation()[2]) {
					temp = temp + 2;
				}
				if (_tiles[i][o].tileOrientation()[3]) {
					temp = temp + 3;
				}

				switch (temp) {

				case "T01":
					current.setIcon(new ImageIcon(getClass().getResource("/resources/T01.png")));
					break;
				case "T012":
					current.setIcon(new ImageIcon(getClass().getResource("/resources/T012.png")));
					break;
				case "T013":
					current.setIcon(new ImageIcon(getClass().getResource("/resources/T013.png")));
					break;
				case "T02":
					current.setIcon(new ImageIcon(getClass().getResource("/resources/T02.png")));
					break;
				case "T023":
					current.setIcon(new ImageIcon(getClass().getResource("/resources/T023.png")));
					break;
				case "T12":
					current.setIcon(new ImageIcon(getClass().getResource("/resources/T12.png")));
					break;
				case "T123":
					current.setIcon(new ImageIcon(getClass().getResource("/resources/T123.png")));
					break;
				case "T13":
					current.setIcon(new ImageIcon(getClass().getResource("/resources/T13.png")));
					break;
				case "T23":
					current.setIcon(new ImageIcon(getClass().getResource("/resources/T23.png")));
					break;
				case "T03":
					current.setIcon(new ImageIcon(getClass().getResource("/resources/T03.png")));
					break;
				}
				if (_tiles[i][o].hasPawn()) {
					String p = "";
					ArrayList<String> pawns = _tiles[i][o].pawnsOnTile();
					for (int k = 0; k < pawns.size(); k++) {

						p = p + " " + pawns.get(k).charAt(0);
					}
					current.setText(p.toUpperCase());
					current.setHorizontalTextPosition(SwingConstants.CENTER);
					current.setVerticalTextPosition(SwingConstants.CENTER);

					Font myFont = current.getFont();
					Font newFont = myFont.deriveFont(Font.BOLD, myFont.getSize() + 8);
					current.setFont(newFont);
					current.setForeground(Color.BLACK);
				}
				if (_tiles[i][o].hasToken()){
					String t = current.getText();
					t = t +_tiles[i][o].getToken().getTokenValue();
					current.setText(t);
					Font myFont = current.getFont();
					Font newFont = myFont.deriveFont(Font.BOLD, myFont.getSize() + 8);
					current.setFont(newFont);
					current.setHorizontalTextPosition(SwingConstants.CENTER);
					current.setVerticalTextPosition(SwingConstants.CENTER);
				}
			}

		}

	}

	
}
