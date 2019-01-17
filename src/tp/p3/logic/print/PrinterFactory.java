package tp.p3.logic.print;

import tp.p3.logic.Game;

public class PrinterFactory {

	private static GamePrinter[] availablePrinters = {
		new ReleasePrinter(),
		new DebugPrinter(),
	};
	
	public static GamePrinter parsePrinter(String printerName, Game game) {
		GamePrinter printer = null;
		int i = 0;
		while(printer == null && i < availablePrinters.length) {
			printer = availablePrinters[i].parse(printerName, game);
			i++;
		}
		return printer;
	}

}
