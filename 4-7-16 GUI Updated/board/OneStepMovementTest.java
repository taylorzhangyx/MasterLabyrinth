package board;

import tile.*;

import static org.junit.Assert.*;

import org.junit.Test;

import pawn.Pawn;

import static org.hamcrest.CoreMatchers.instanceOf;

public class OneStepMovementTest {
	
	private Pawn _pawn1 = new Pawn("red", 2, 2, 0);
	private Pawn _pawn2 = new Pawn("yellow", 2, 4, 0);
	private Pawn _pawn3 = new Pawn("blue", 4, 2, 0);
	private Pawn _pawn4 = new Pawn("white", 4, 4, 0);
	
	
	public void OneStepMovementCommonTest(Pawn currentpawn, String Direction, boolean expected) {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		boolean actrual = b.moveOneStep(Direction, currentpawn);
		
		assertTrue("", expected == actrual);
	}
	
	//current tile N is open but target tile S is close
	@Test public void MoveNtest1(){OneStepMovementCommonTest(_pawn1,"N",false);}
	//current tile N is close but target tile S is open
	@Test public void MoveNtest2(){OneStepMovementCommonTest(_pawn2,"N",false);}
	//current tile N is open but target tile S is open
	@Test public void MoveNtest3(){OneStepMovementCommonTest(_pawn3,"N",true);}
	
	//current tile S is open but target tile N is close
	@Test public void MoveStest4(){OneStepMovementCommonTest(_pawn2,"S",false);}
	//current tile S is close but target tile N is open
	@Test public void MoveStest5(){OneStepMovementCommonTest(_pawn3,"S",false);}
	//current tile S is open but target tile N is open
	@Test public void MoveStest6(){OneStepMovementCommonTest(_pawn4,"S",true);}
	
	//current tile E is close but target tile W is open
	@Test public void MoveStest8(){OneStepMovementCommonTest(_pawn4,"E",false);}
	//current tile E is open but target tile W is open
	@Test public void MoveStest9(){OneStepMovementCommonTest(_pawn2,"E",true);}
	
	//current tile W is close but target tile S is open
	@Test public void MoveStest10(){OneStepMovementCommonTest(_pawn1,"W",false);}
	//current tile W is open but target tile S is open
	@Test public void MoveStest11(){OneStepMovementCommonTest(_pawn2,"W",true);}
	
	@Test public void erasePawnOnBoardTest(){
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		//Make a legal movement on red pawn
		b.moveOneStep("E", _pawn1);
		Board _bStep = new Board();
		_bStep.createGameBoard();
		_bStep.populateTestBoardAfterMove();
		
		assertTrue("", _bStep.hasPawn(2, 2) == b.hasPawn(2, 2));
	}
	
	@Test public void setPawnOnBoardTest(){
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		//Make a legal movement on red pawn
		b.moveOneStep("E", _pawn1);
		Board _bStep = new Board();
		_bStep.createGameBoard();
		_bStep.populateTestBoardAfterMove();
		
		assertTrue("", _bStep.hasPawn(2, 3) == b.hasPawn(2, 3));
	}
	
	@Test public void checkPawnOnBoardTest(){
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		//Make a legal movement on red pawn
		b.moveOneStep("E", _pawn1);
		Board _bStep = new Board();
		_bStep.createGameBoard();
		_bStep.populateTestBoardAfterMove();
		
		assertTrue("", _bStep.pawnsOnTile(2, 3).equals(b.pawnsOnTile(2, 3)));
	}
	
}
