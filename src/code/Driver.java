package code;

import javax.swing.SwingUtilities;
/*
 *Driver for the game. This will call application. The names that are passed in on the command line
 *will be passed to Application. 
 *  
 */
public class Driver {
	public static void main(String[] args) throws InvalidArgumentException{
		if (args.length<5&&args.length>1){
			SwingUtilities.invokeLater(new Application(args));
		}
		else {throw new InvalidArgumentException("Please enter two to four names!");}
	}

}
