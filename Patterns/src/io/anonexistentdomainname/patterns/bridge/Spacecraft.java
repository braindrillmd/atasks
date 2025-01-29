package io.anonexistentdomainname.patterns.bridge;

//concrete implementation
public class Spacecraft implements TransportationDevice {
	//String for clarity
	//imagine SpaceStation object being here and also it being vastly different from an Airport object
	String departureSpaceStation; 
	String arrivalSpaceStation;
	Speed speed;
	String engineType;

	@Override
	public void setStartingLocation(String spaceStation) {
		departureSpaceStation = spaceStation;
		System.out.println("Departure space station set to: " + departureSpaceStation);

	}

	@Override
	public void setDestination(String spaceStation) {
		arrivalSpaceStation = spaceStation;
		System.out.println("Arrival space station set to: " + arrivalSpaceStation);

	}

	@Override
	public void setSpeed(Speed speed) {
		if(speed == Speed.ZZAP) {
			System.out.println("Sorry, this generation spacecraft can't go " + Speed.ZZAP + " yet. Setting speed to " + Speed.MODERATE);
			this.speed = Speed.MODERATE;
		}
		else {
			System.out.println("Speed set to " + speed);
			this.speed = speed;
		}

	}

	@Override
	public boolean go() {
		if(departureSpaceStation != null && arrivalSpaceStation != null && speed != null) {
			System.out.println("Enter your cryochambers and enjoy the flight!");
			return true;
		}
		
		System.out.println("Not enough data!");
		return false;
	}

}
