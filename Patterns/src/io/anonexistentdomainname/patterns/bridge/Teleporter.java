package io.anonexistentdomainname.patterns.bridge;

//concrete implementation
public class Teleporter implements TransportationDevice {
	String initialCoordinates;
	String endpointCoordinates;

	@Override
	public void setStartingLocation(String coordinates) {
		initialCoordinates = coordinates;
		System.out.println("Initial coordinates set: " + initialCoordinates);
		

	}

	@Override
	public void setDestination(String coordinates) {
		endpointCoordinates = coordinates;
		System.out.println("Endpoint coordinates set: " + endpointCoordinates);

	}

	@Override
	public void setSpeed(Speed speed) {
		System.out.println("'Speed' parameter is ignored. Teleporters can only go " + Speed.ZZAP);

	}

	@Override
	public boolean go() {
		
		if(initialCoordinates != null && endpointCoordinates != null) {
			System.out.println("Zzap!!");
			System.out.println("Hope our automatic surface level adjustment system worked!");
			return true;
		}
		
		System.out.println("Not enough data!");
		return false;
	}

}
