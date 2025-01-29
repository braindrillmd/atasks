package io.anonexistentdomainname.patterns;

import io.anonexistentdomainname.patterns.state.Spacecraft;

public class StateDemo {

	public static void main(String[] args) {
		Spacecraft sc1 = new Spacecraft();
		sc1.engageAuxillaryPowerSource(); //nope!
		sc1.travelToCoordinates("x18388021/y430470327/z98504397"); //just a string
		sc1.setPrimaryFusionEngineOnline(false); //let's sabotage the ship
		sc1.travelToCoordinates("x12345y54321z12321");
		sc1.activateDistressBeacon();
		sc1.initWrpDrive(); //this one's toast
		System.out.println();
		
		//let's make a new one
		Spacecraft sc2 = new Spacecraft();
		sc2.initWrpDrive();
		sc2.travelToCoordinates("x012/y345/z678"); //nope
		sc2.engageAuxillaryPowerSource(); //nope
		sc2.travelToSector("UCSC0057XFG"); //just a string
		sc2.hyperSpaceExitSequence();
		sc2.stopWarpDrive();
		sc2.initWrpDrive();
		sc2.travelToCoordinates("x1/y2/z3");
		sc2.travelToSector("UCSC7875AAM");
		sc2.activateDistressBeacon();
	}

}
