package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pawn.Pawn;

public class PawnEndTurnHandler implements ActionListener{
	MainFrame _frame;
	Pawn _pawn;
	
	/*
	 * Constructor for PawnEndTurnHandler
	 * 
	 */
	PawnEndTurnHandler(MainFrame frameTest, Pawn pawn){
		_frame = frameTest;
		_pawn = pawn;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		_frame._gbp.enableInsertionButton();
		_frame._gfp.disablePawnMovingButtons();
		_frame.nextPawn();
	}

}
