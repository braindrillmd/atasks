package io.anonexistentdomainname.patterns.state;

//concrete state
public class IdleState extends State {

	public IdleState(Spacecraft spacecraft) {
		super(spacecraft);
		
		System.out.println(">>>@" + this.getClass().getCanonicalName());
		
		spacecraft.setAuxillaryPowerEngaged(false); 
		spacecraft.setCryochambersActive(false);
		spacecraft.setDistressBeaconActive(false);
		spacecraft.setInHyperSpace(false); 
		spacecraft.setPrimaryFusionEngineOnline(true);
		spacecraft.setDesignatedSector(null);
		
		System.out.println("All systems online. Awaiting directions");
	}

	@Override
	public void travelToCoordinates(String coordinates) {
		if(spacecraft.isPrimaryFusionEngineOnline()) {
			System.out.println("Arriving at following coordinates: " + coordinates);
			System.out.println("All systems ready");
		}else {
			System.out.println("Warning! Primary fusion engines offline. Activating emergency mode!");
			spacecraft.changeState(new EmergencyState(spacecraft));
		}

	}

	@Override
	public void travelToSector(String sector) {
		System.out.println("Denied! Warp drive initialisation required.");

	}

	@Override
	public void hyperSpaceExitSequence() {
		System.out.println("Denied. Not in hyper space qurrently!");

	}


	@Override
	public void activateDistressBeacon() {
		System.out.println("Distress beacon activated! Auxillary power source engaged! Entering emergency mode!");
		spacecraft.changeState(new EmergencyState(spacecraft));

	}

	@Override
	public void engageAuxillaryPowerSource() {
		System.out.println("Denied! Emergency state security override required");
		
	}

	@Override
	public void initWarpDrive() {
		System.out.println("Warning! Warpdrive initalised. Crew is adviced to proceed to cryochambers as soon as possible");
		spacecraft.changeState(new WarpDriveActiveState(spacecraft));
	}

	@Override
	public void stopWarpDrive() {
		System.out.println("Denied! Warp drive is already shut down");
	}

}
