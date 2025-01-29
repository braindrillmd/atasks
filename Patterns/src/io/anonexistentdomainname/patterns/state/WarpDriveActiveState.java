package io.anonexistentdomainname.patterns.state;

//concrete state
public class WarpDriveActiveState extends State {

	public WarpDriveActiveState(Spaceship spacecraft) {
		super(spacecraft);
		
		System.out.println(">>>@" + this.getClass().getCanonicalName());
	}

	@Override
	public void travelToCoordinates(String coordinates) {
		System.out.println("Denied! Disengaged warp drive first");

	}

	@Override
	public void travelToSector(String sector) {
		System.out.println("Jumping to sector " + sector + "... Godspeed!");
		spacecraft.setDesignatedSector( sector);
		spacecraft.changeState(new InHyperSpaceState(spacecraft));

	}

	@Override
	public void initWarpDrive() {
		System.out.println("Warpdrive already active");

	}

	@Override
	public void hyperSpaceExitSequence() {
		System.out.println("Denied! Not in hyper space");

	}

	@Override
	public void engageAuxillaryPowerSource() {
		System.out.println("Denied! Emergency state security override required");

	}

	@Override
	public void activateDistressBeacon() {
		System.out.println("Distress beacon activated! Auxillary power source engaged! Entering emergency mode!");
		spacecraft.changeState(new EmergencyState(spacecraft));

	}

	@Override
	public void stopWarpDrive() {
		System.out.println("Deactivating warpdrive...");
		spacecraft.changeState(new IdleState(spacecraft));
		
	}

}
