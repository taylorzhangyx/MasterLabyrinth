package codee;

import code.Parent.OppositeDirectionTile;

public class Driver {
	public static void main(String[] args){
		OppositeDirectionTile[][] TwoDArray = creat2darray();
		for (int i=0; i<7 ; i++){
			for (int j=0; j<7 ;j++){
				//Here I test every value in TileNum in each element of the array, 
				//the number represents the row and column row number TwoDArray[i][j]
				System.out.printf(" %d \n",  TwoDArray[i][j].TileNum);
			}
		}
	}

	
	public static OppositeDirectionTile[][] creat2darray(){
		//Create the two dimensional array of the class OppositeDirectionTile
		//By creating it, it runs 7*7 times of the method and output 49 lines of [N,E,S,W]
		OppositeDirectionTile[][] TwoDarray = new OppositeDirectionTile[7][7];
		for (int i=0; i<7 ; i++){
			for (int j=0; j<7 ;j++){
				//Initialize each element in this array, it runs 7*7 times of the method and output 49 lines of [N,E,S,W]
				TwoDarray[i][j] = new OppositeDirectionTile();
				//I give a initial value to public int TileNum in each element  
				TwoDarray[i][j].TileNum = 10*i+ j ;
			}
		}
		
		return TwoDarray;
		
	}

}
