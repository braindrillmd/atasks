package io.anonexistentdomainname.patterns.state;

//concrete state
public class EmergencyState extends State {
	
	public EmergencyState(Spaceship spacecraft) {
		super(spacecraft);
		
		System.out.println(">>>@" + this.getClass().getCanonicalName());
		
		spacecraft.setAuxillaryPowerEngaged(true);
		spacecraft.setCryochambersActive(true);
		spacecraft.setDistressBeaconActive(true);
	}

	private void emergencyMessage() {
		System.out.println("Unnable to perform following action! Emergency situation!");
		System.out.println("All non-LSS related system shut down, distress beacon activated");
	}
	
	@Override
	public void travelToCoordinates(String coordinates) {
		emergencyMessage();

	}

	@Override
	public void travelToSector(String sector) {
		emergencyMessage();

	}

	@Override
	public void initWarpDrive() {
		emergencyMessage();

	}

	@Override
	public void hyperSpaceExitSequence() {
		emergencyMessage();

	}

	@Override
	public void engageAuxillaryPowerSource() {
		System.out.println("Auxillary power source is already engaged");

	}

	@Override
	public void activateDistressBeacon() {
		System.out.println("Distress beacon is already activated");

	}

	@Override
	public void stopWarpDrive() {
		emergencyMessage();
		
	}

}
