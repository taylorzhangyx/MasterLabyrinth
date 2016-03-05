package codee;
import code.Parent.*;

public class TwoDarray {

	public OppositeDirectionTile[][] creat2darray(){
		OppositeDirectionTile[][] TwoDarray = new OppositeDirectionTile[7][7];
		for (int i=0; i<7 ; i++){
			for (int j=0; j<7 ;j++){
				TwoDarray[i][j].TileNum = i+j ;
			}
		}
		
		return TwoDarray;
		
	}

	
	public TwoDarray() {
		OppositeDirectionTile[][] TwoDArray = creat2darray();
		for (int i=0; i<7 ; i++){
			for (int j=0; j<7 ;j++){
				
				System.out.printf(" %d \n",  TwoDArray[i][j].TileNum);
			}
		}
		
		
	}



}