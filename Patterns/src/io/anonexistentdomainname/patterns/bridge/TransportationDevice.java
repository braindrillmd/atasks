package io.anonexistentdomainname.patterns.bridge;

//"implementation" part
public interface TransportationDevice {
	void setStartingLocation(String location);
	void setDestination(String location);
	void setSpeed(Speed speed);
	boolean go();
}
