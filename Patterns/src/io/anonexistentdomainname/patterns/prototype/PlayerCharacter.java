package io.anonexistentdomainname.patterns.prototype;

import java.util.Arrays;

public class PlayerCharacter extends GameCharacter {
	public int[] getInventory() {
		return inventory;
	}

	public void setInventory(int[] inventory) {
		this.inventory = inventory;
	}

	public ClassName getClassName() {
		return className;
	}

	public void setClassName(ClassName className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "PlayerCharacter [inventory=" + Arrays.toString(inventory) + ", className=" + className + ", strength="
				+ strength + ", dexterity=" + dexterity + ", intelligence=" + intelligence + ", name=" + name
				+ ", race=" + race + ", faction=" + faction + ", lotsOfBinaryData=" + new String(lotsOfBinaryData)
				+ "]";
	}

	enum ClassName{RANGER, KNIGHT, BARBARIAN, MAGE, UNDEFINED}
	
	private int[] inventory;
	private ClassName className;
	
	static {
		
	}
	
	public PlayerCharacter() {
		inventory = new int[] {Weapons.BEGINNER_AXE_ID,
				Weapons.BEGINNER_BOW_ID,
				Weapons.BEGINNER_SWORD_ID,
				Weapons.BEGINNER_WARHAMMER_ID};
		className = ClassName.UNDEFINED;
	}

	public PlayerCharacter(PlayerCharacter that) {
		super(that);
		
		if(that != null) {
			this.inventory = Arrays.copyOf(that.inventory, that.inventory.length);
		}
		this.className = that.className;
	}
	
	@Override
	public PlayerCharacter clone() {
		return new PlayerCharacter(this);
	}

}
