package tp.p3.logic;

public enum Level {
	EASY(3, 0.1), HARD(5, 0.2), INSANE(10, 0.3);
	
	private int numberOfZombies;
	private double zombieFrequency;
	
	private Level(int zombieNum, double zombieFreq){
		numberOfZombies = zombieNum;
		zombieFrequency = zombieFreq;
	}
	
	public int getNumZombies() {
		return numberOfZombies;
	}
	
	public double getFreq() {
		return zombieFrequency;
	}
	
	public static Level parse(String inputString) {
		for (Level level : Level.values() )
			if (level.name().equalsIgnoreCase(inputString)) return level;
		return null;
	}
	
	public static String all (String separator) {
		StringBuilder sb = new StringBuilder();
		
		for (Level level : Level.values() )
			sb.append(level.name() + separator);
		
		String allLevels = sb.toString();
		
		return allLevels.substring(0, allLevels.length()-separator.length());
	}
}

//package tp.p3.logic;
//
//public enum Level {
//	
//	EASY(3, 0.1), HARD(5, 0.2), INSANE(10, 0.3);
//	
//	private int numZombies;
//	private double freq;	
//	
//	Level(int num_zombies, double freq) {
//		this.numZombies = num_zombies;
//		this.freq = freq;
//	}
//	
//	public int getNumZombies() {
//		return numZombies;
//	}
//	
//	public double getFreq() {
//		return freq;
//	}
//	
//}
