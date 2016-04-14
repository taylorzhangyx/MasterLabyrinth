package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pawn.Pawn;

public class PawnEndTurnHandler implements ActionListener{
	FrameTest _frameTest;
	Pawn _pawn;
	
	PawnEndTurnHandler(FrameTest frameTest, Pawn pawn){
		_frameTest = frameTest;
		_pawn = pawn;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		_frameTest._gbp.enableInsertionButton();
		_frameTest._gfp.disablePawnMovingButtons();
		_frameTest.nextPawn();
	}

}
