package tp.p3;

import tp.p3.logic.Game;
import tp.p3.logic.Level;
import tp.p3.logic.print.*;

import tp.p3.control.Controller;
import tp.p3.exceptions.ProgramArgumentsException;


public class PlantsVsZombies {

	private static String usageMsg = "Usage: PlantsVsZombies <EASY|HARD|INSANE> [<seed>]";
	
	public static void main(String[] args) {

		System.out.println(titleScreen());
		
		try {
			if(args.length == 1 ||args.length == 2) {
				
				Level level = null;
				long seed = System.currentTimeMillis();
				
				if(args[0].equals("EASY")) level = Level.EASY;
				else if(args[0].equals("HARD")) level = Level.HARD;
				else if(args[0].equals("INSANE")) level = Level.INSANE;
				else throw new ProgramArgumentsException(usageMsg + ": level must be one of: EASY, HARD, INSANE");
				
				if(level != null) {
					
					try {
						if(args.length == 2) seed = Integer.parseInt(args[1]);
					} catch (NumberFormatException ex) {
						throw new ProgramArgumentsException(usageMsg + ": the seed must be a number");
					}
						
					Game game = new Game(level, seed);
					GamePrinter printer = new ReleasePrinter(game); //By default we print Release version
					Controller controller = new Controller(game, printer);
					
					System.out.println("Random seed used: " + seed);
	
					controller.run();
				}
		    }
		    else {
		    	throw new ProgramArgumentsException(usageMsg);
		        // Mensaje de error estandar (UNIX), <level>: Obligatorio, [<seed>]: Opcional
		    }
		} catch (ProgramArgumentsException ex) {
			System.err.format(ex.getMessage() + "%n%n");
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
