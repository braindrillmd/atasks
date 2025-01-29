package io.anonexistentdomainname.patterns.bridge;

//"abstraction" part of the bridge
public class TransportationSystem {
	protected TransportationDevice device;
	
	public TransportationSystem(TransportationDevice device) {
		this.device = device;
	}
	
	public void travel(String from, String to, Speed speed)
	{
		device.setDestination(to);
		device.setStartingLocation(from);
		device.setSpeed(speed);
		
		if(!device.go()) {
			System.out.println("Oops! Something went wrong");
		}else {
			System.out.println("Welcome to " + to + "!");
		}
	}
}
