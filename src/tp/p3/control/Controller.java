package tp.p3.control;

import java.util.Scanner;

import tp.p3.exceptions.*;
import tp.p3.logic.Game;
import tp.p3.logic.print.GamePrinter;

public class Controller {
	
	private Game game;
	private Scanner in = new Scanner(System.in);
	private String unknownCommandMsg = "Unknown command. Use 'help' to see available commands";
	private String prompt = "Command > ";
	private boolean noPrint;
	
	private GamePrinter printer;
	
	public Controller(Game game, GamePrinter printer) {
		this.game = game;
		this.printer = printer;
	}
	
	public void setPrinter(GamePrinter printer) {
		this.printer = printer;
	}
	
	public boolean checkPrintState() {
		return noPrint;
	}
	
	public void setNoPrintGameState(){
		noPrint = true;
	}

	public void run() {
		while (!game.isFinished()) {
			
			printGame(noPrint);
			noPrint = false;
			
			if(!game.isFinished()) {
				
				System.out.print(prompt);
				String[] words = in.nextLine().toLowerCase().trim().split("\\s+");
				
				try {				
					Command command = CommandParser.parseCommand(words, this);
				
					if (command != null) {
						if (!command.execute(game, this)) setNoPrintGameState();
					}
					else {
						throw new CommandParseException(unknownCommandMsg);
					}
					
				} catch (CommandParseException | CommandExecuteException ex) {
					System.err.format(ex.getMessage() + "%n%n");
					setNoPrintGameState();
				}
			}
		}
		game.winner();
	}
	
	private void printGame(boolean noPrint) {
		if(!noPrint){
			game.update();
			printer.printGame(game);
			game.computerAction();
		}
	}
}