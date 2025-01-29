package io.anonexistentdomainname.patterns.bridge;

import java.util.List;

//refined abstraction
public class AdvancedTransportationSystem extends TransportationSystem {
	public AdvancedTransportationSystem(TransportationDevice device) {
		super(device);
	}
	
	public void travelRoute(List<String> route, Speed speed) {
		System.out.println("Route entered: " + route);
		
		for(int i = 0 ; i < route.size() - 1; i++) {
			travel(route.get(i), route.get(i + 1), speed);
		}
		
		System.out.println("See ya!");
	}
}
