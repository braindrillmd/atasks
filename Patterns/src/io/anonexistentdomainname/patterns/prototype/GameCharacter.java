package io.anonexistentdomainname.patterns.prototype;

import java.util.Arrays;
import java.util.Random;

public abstract class GameCharacter {
	public enum Race{ELF, ORK, HUMAN, DWARF, MONSTER, UNDEFINED};
	public enum Faction{GOODDIES, BADDIES, NEUTRAL}
	
	protected final static int DEFAULT_STR = 10;
	protected final static int DEFAULT_DEXT = 10;
	protected final static int DEFAULT_INT = 10;
	
	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Faction getFaction() {
		return faction;
	}

	public void setFaction(Faction faction) {
		this.faction = faction;
	}

	public byte[] getLotsOfBinaryData() {
		return lotsOfBinaryData;
	}

	public void setLotsOfBinaryData(byte[] lotsOfBinaryData) {
		this.lotsOfBinaryData = lotsOfBinaryData;
	}

	protected int strength;
	protected int dexterity;
	protected int intelligence;
	protected String name;
	
	protected Race race;
	protected Faction faction;
	
	protected byte[] lotsOfBinaryData; //just imagine it
	
	public GameCharacter() {
		race = Race.UNDEFINED;
		faction = Faction.NEUTRAL;
		strength = DEFAULT_STR;
		dexterity = DEFAULT_DEXT;
		name = "John Doe";
		intelligence = DEFAULT_INT;
		lotsOfBinaryData = busyWork();
		
	}
	
	public GameCharacter(GameCharacter that) {
		if(that != null) {
			this.race = that.race;
			this.faction = that.faction;
			this.strength = that.strength;
			this.dexterity = that.dexterity;
			this.intelligence = that.intelligence;
			this.lotsOfBinaryData = Arrays.copyOf(that.lotsOfBinaryData, that.lotsOfBinaryData.length);
		}
	}
	
	public abstract GameCharacter clone();
	
	private byte[] busyWork() {
		Random random = new Random();
		
		StringBuilder strBuilder = new StringBuilder();
		for(int i = 0; i < 10; i++) {
			strBuilder.append(String.valueOf(Math.abs(random.nextInt() %10)));
		}
		
		System.out.println("Starting very long and costly computations...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Oof... Computations complete!");
		
		return ("Hella complex computations=" + strBuilder.toString()).getBytes();
	}
}
