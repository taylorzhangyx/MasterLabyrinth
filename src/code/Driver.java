package code;

import javax.swing.SwingUtilities;

public class Driver {
	public static void main(String[] args){
		if (args.length<5&&args.length!=0){
			SwingUtilities.invokeLater(new Application(args));
		}
	}

}
