package io.anonexistentdomainname.patterns.state;

//abstract state ("interface")
public abstract class State {
	protected Spaceship spacecraft;
	
	public State(Spaceship spacecraft) {
		this.spacecraft = spacecraft;
	}
	
	public abstract void travelToCoordinates(String coordinates);
	public abstract void travelToSector(String sector);
	public abstract void initWarpDrive();
	public abstract void stopWarpDrive();
	public abstract void hyperSpaceExitSequence();
	public abstract void engageAuxillaryPowerSource();
	public abstract void activateDistressBeacon();
}
