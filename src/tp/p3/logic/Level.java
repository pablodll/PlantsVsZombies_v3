package tp.p3.logic;

public enum Level {
	
	EASY(3, 0.1), HARD(5, 0.2), INSANE(10, 0.3);
	
	private int numZombies;
	private double freq;	
	
	Level(int num_zombies, double freq) {
		this.numZombies = num_zombies;
		this.freq = freq;
	}
	
	public int getNumZombies() {
		return numZombies;
	}
	
	public double getFreq() {
		return freq;
	}
	
}
