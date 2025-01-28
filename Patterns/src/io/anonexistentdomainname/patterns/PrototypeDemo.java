package io.anonexistentdomainname.patterns;

import java.util.LinkedList;
import java.util.List;

import io.anonexistentdomainname.patterns.prototype.GameCharacter;
import io.anonexistentdomainname.patterns.prototype.NpcCharacter;
import io.anonexistentdomainname.patterns.prototype.PlayerCharacter;

public class PrototypeDemo {

	public static void main(String[] args) {
		System.out.println("Creating a new character takes time");
		PlayerCharacter pc1 = new PlayerCharacter();
		System.out.println(pc1);
		System.out.println("Cloning is much faster");
		GameCharacter pc2 = pc1.clone();
		pc2.setStrength(30);
		pc2.setRace(GameCharacter.Race.DWARF);
		pc2.setName("Bjorn Stormhelmoakgardnung");
		System.out.println(pc2);
		
		System.out.println("\nLet's make some NPCs");
		NpcCharacter npcc = new NpcCharacter(GameCharacter.Faction.BADDIES, GameCharacter.Race.ORK);
		System.out.println(npcc);
		System.out.println("Cloning 3 times and changing NPCs' names");
		GameCharacter npcc1 = npcc.clone();
		npcc1.setName("Ghrzak Barghlrash");
		GameCharacter npcc2 = npcc.clone();
		npcc2.setName("Burglum Ur'Grock");
		GameCharacter npcc3 = npcc.clone();
		npcc3.setName("Urlock Or'Burgush");
		System.out.println(npcc1);
		System.out.println(npcc2);
		System.out.println(npcc3);
		
		System.out.println("\nAlso we can put different characters into a collection and clone them without caring about their precise type");
		List<GameCharacter> gcList = new LinkedList<>();
		gcList.add(pc1);
		gcList.add(pc2);
		gcList.add(npcc);
		gcList.add(npcc1);
		gcList.add(npcc2);
		gcList.add(npcc3);
		for(GameCharacter gc : gcList) {
			GameCharacter newGc = gc.clone();
			System.out.println("Cloned: " + newGc);
		}
	}

}
