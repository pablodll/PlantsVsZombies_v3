package tp.p3;

import tp.p3.logic.Game;
import tp.p3.logic.Level;
import tp.p3.logic.print.*;

import tp.p3.control.Controller;

public class PlantsVsZombies {
	
	public static void main(String[] args) {
		
		System.out.println(titleScreen());
		
		if(args.length == 1 ||args.length == 2) {
			
			Level level = null;
			long seed = System.currentTimeMillis();
			
			if(args[0].equals("EASY")) level = Level.EASY;
			else if(args[0].equals("HARD")) level = Level.HARD;
			else if(args[0].equals("INSANE")) level = Level.INSANE;
			
			if(level != null) {
				
				if(args.length == 2) seed = Integer.parseInt(args[1]);
				
				Game game = new Game(level, seed);
				GamePrinter printer = new ReleasePrinter(game, game.getRows(), game.getCols()); //By default we print Release version
				Controller controller = new Controller(game, printer);
				
				System.out.println("Random seed used: " + seed);
				controller.run();
			}
	    }
	    else {
	        System.err.println("Usage: PlantsVsZombies <level> [<seed>]"); 
	        // Mensaje de error estandar (UNIX), <level>: Obligatorio, [<seed>]: Opcional
	    }
	}
	
	private static String titleScreen() {
		return ("\r\n" + 
				"  _____  _               _   _ _______ _____  __      _______   __________  __  __ ____ _____ ______  _____ \r\n" + 
				" |  __ \\| |        /\\   | \\ | |__   __/ ____| \\ \\    / / ____| |___  / __ \\|  \\/  |  _ \\_   _|  ____|/ ____|\r\n" + 
				" | |__) | |       /  \\  |  \\| |  | | | (___    \\ \\  / / (___      / / |  | | \\  / | |_) || | | |__  | (___  \r\n" + 
				" |  ___/| |      / /\\ \\ | . ` |  | |  \\___ \\    \\ \\/ / \\___ \\    / /| |  | | |\\/| |  _ < | | |  __|  \\___ \\ \r\n" + 
				" | |    | |____ / ____ \\| |\\  |  | |  ____) |    \\  /  ____) |  / /_| |__| | |  | | |_) || |_| |____ ____) |\r\n" + 
				" |_|    |______/_/    \\_\\_| \\_|  |_| |_____/      \\/  |_____/  /_____\\____/|_|  |_|____/_____|______|_____/ \r\n" + 
				"                                                                                                            \r\n" + 
				"                                                                                                            \r\n" + 
				"");
	}
	
}
