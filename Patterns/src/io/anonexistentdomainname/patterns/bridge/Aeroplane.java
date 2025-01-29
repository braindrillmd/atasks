package io.anonexistentdomainname.patterns.bridge;

//concrete implementation
public class Aeroplane implements TransportationDevice {
	//String for clarity
	//Imagine an Aeroport object here
	String departureAeroport;
	String arrivalAeroport;
	Speed speed;
	

	@Override
	public void setStartingLocation(String aeroport) {
		departureAeroport = aeroport;
		System.out.println("Departure aeroport set to: " + departureAeroport);

	}

	@Override
	public void setDestination(String aeroport) {
		arrivalAeroport = aeroport;
		System.out.println("Arrival aeroport set to: " + arrivalAeroport);

	}

	@Override
	public void setSpeed(Speed speed) {
		if(speed != Speed.FAST && speed != Speed.FASTER) {
			System.out.println("Can only go " + Speed.FAST + " or " + Speed.FASTER + ". Setting the speed to " + Speed.FASTER);
			this.speed = Speed.FASTER;
		}
		else {
			System.out.println("Speed set to " + speed);
			this.speed = speed;
		}

	}

	@Override
	public boolean go() {
		if(departureAeroport != null && arrivalAeroport != null && speed != null) {
			System.out.println("Fasten your seat belts and ejoy the flight!");
			return true;
		}
		
		System.out.println("Not enough data!");
		return false;
	}
}