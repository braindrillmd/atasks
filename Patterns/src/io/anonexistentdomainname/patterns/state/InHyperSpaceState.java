package io.anonexistentdomainname.patterns.state;

//concrete state
public class InHyperSpaceState extends State {

	public InHyperSpaceState(Spacecraft spacecraft) {
		super(spacecraft);
		
		spacecraft.setInHyperSpace(true);
		System.out.println(">>>@" + this.getClass().getCanonicalName());
		
		System.out.println("Arriving at sector " + spacecraft.getDesignatedSector());
	}

	@Override
	public void travelToCoordinates(String coordinates) {
		System.out.println("Denied! Currently in hyper spacee");
	}

	@Override
	public void travelToSector(String sector) {
		System.out.println("Denied! Relocation in progress");
	}

	@Override
	public void initWarpDrive() {
		System.out.println("Denied! Warp drive is active");
	}

	@Override
	public void hyperSpaceExitSequence() {
		System.out.println("Now exiting hyperspace...");
		System.out.println("Hyperdrive disengaged...");
		spacecraft.changeState(new IdleState(spacecraft));
	}

	@Override
	public void engageAuxillaryPowerSource() {
		System.out.println("Denied! Emergency state security override required");
	}

	@Override
	public void activateDistressBeacon() {
		System.out.println("Denied! Activating distress beacon in hyper space is futile");
	}

	@Override
	public void stopWarpDrive() {
		System.out.println("Denied! We're in hyper space, are you nuts, Captain?");
	}

}
