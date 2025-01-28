package io.anonexistentdomainname.patterns.prototype;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class NpcCharacter extends GameCharacter {
	public Map<Integer, String> getDialogueLines() {
		return dialogueLines;
	}

	public void setDialogueLines(Map<Integer, String> dialogueLines) {
		this.dialogueLines = dialogueLines;
	}

	@Override
	public String toString() {
		return "NpcCharacter [dialogueLines=" + dialogueLines + ", strength=" + strength + ", dexterity=" + dexterity
				+ ", intelligence=" + intelligence + ", name=" + name + ", race=" + race + ", faction=" + faction
				+ ", lotsOfBinaryData=" + new String(lotsOfBinaryData) + "]";
	}

	Map<Integer, String> dialogueLines;
	
	public NpcCharacter() {
		dialogueStuff();
	}
	
	public NpcCharacter(Faction faction, Race race) {
		dialogueStuff();
		
		this.faction = faction;
		this.race = race;
	}
	

	public NpcCharacter(NpcCharacter that) {
		super(that);
		
		if(that != null) {
			this.dialogueLines = new HashMap<>();
			
			for(Entry<Integer, String> entry : that.dialogueLines.entrySet()) {
				this.dialogueLines.put(entry.getKey(), entry.getValue());
			}
		}
	}
	
	private void dialogueStuff() {
		dialogueLines = new HashMap<>();
		dialogueLines.put(1, "Get out of my sight, stranger!");
		dialogueLines.put(2, "Pleased to meet you!");
	}

	@Override
	public GameCharacter clone() {
		return new NpcCharacter(this);
	}

}
