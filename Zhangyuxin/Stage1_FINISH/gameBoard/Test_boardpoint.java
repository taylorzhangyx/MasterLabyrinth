package gameBoard;

import org.junit.Assert;
import org.junit.Test;

import tile.OppositeDirectionTile;
import tile.Tile;

public class Test_boardpoint {
	
@Test public void test01() {
    	
		Boardpoint[] tdt = new Boardpoint[3];
		for(int i = 0; i<3; i++){
			tdt[i] = new Boardpoint();
		}
		Tile _tile = new OppositeDirectionTile(1);
		tdt[1].assigntile(new OppositeDirectionTile(1));
		tdt[1].printPoint();
		
	}

}
