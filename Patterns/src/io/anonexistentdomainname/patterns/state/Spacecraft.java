package io.anonexistentdomainname.patterns.state;

public class Spacecraft {
	public boolean isAuxillaryPowerEngaged() {
		return auxillaryPowerEngaged;
	}

	public void setAuxillaryPowerEngaged(boolean auxillaryPowerEngaged) {
		this.auxillaryPowerEngaged = auxillaryPowerEngaged;
	}

	public boolean isCryochambersActive() {
		return cryochambersActive;
	}

	public void setCryochambersActive(boolean cryochambersActive) {
		this.cryochambersActive = cryochambersActive;
	}

	public boolean isDistressBeaconActive() {
		return distressBeaconActive;
	}

	public void setDistressBeaconActive(boolean distressBeaconActive) {
		this.distressBeaconActive = distressBeaconActive;
	}

	public boolean isInHyperSpace() {
		return inHyperSpace;
	}

	public void setInHyperSpace(boolean inHyperSpace) {
		this.inHyperSpace = inHyperSpace;
	}

	public boolean isPrimaryFusionEngineOnline() {
		return primaryFusionEngineOnline;
	}

	public void setPrimaryFusionEngineOnline(boolean primaryFusionEngineOnline) {
		this.primaryFusionEngineOnline = primaryFusionEngineOnline;
	}
	
	public Spacecraft() {
		state = new IdleState(this);
	}
	
	public void changeState(State state) {
		this.state = state;
	}

	private boolean auxillaryPowerEngaged;
	private boolean cryochambersActive;
	private boolean distressBeaconActive;
	private boolean inHyperSpace;
	private boolean primaryFusionEngineOnline;
	
	private String designatedSector;
	
	private State state;

	public String getDesignatedSector() {
		return designatedSector;
	}

	public void setDesignatedSector(String designatedSector) {
		this.designatedSector = designatedSector;
	}
	
	public void travelToCoordinates(String coordinates) {
		state.travelToCoordinates(coordinates);	
	}
	
	public void travelToSector(String sector) {
		state.travelToSector(sector);
	}
	
	public void initWrpDrive() {
		state.initWarpDrive();
	}
	
	public void hyperSpaceExitSequence() {
		state.hyperSpaceExitSequence();
	}
	
	public void engageAuxillaryPowerSource() {
		state.engageAuxillaryPowerSource();
	}
	
	public void activateDistressBeacon() {
		state.activateDistressBeacon();
	}
	
	public void stopWarpDrive() {
		state.stopWarpDrive();
	}
}
