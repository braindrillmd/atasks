package io.anonexistentdomainname.patterns;

import java.util.ArrayList;
import java.util.List;

import io.anonexistentdomainname.patterns.bridge.AdvancedTransportationSystem;
import io.anonexistentdomainname.patterns.bridge.Aeroplane;
import io.anonexistentdomainname.patterns.bridge.Spacecraft;
import io.anonexistentdomainname.patterns.bridge.Speed;
import io.anonexistentdomainname.patterns.bridge.Teleporter;
import io.anonexistentdomainname.patterns.bridge.TransportationSystem;

public class BridgeDemo {
	public static void main(String[] args) {
		//"abstraction"
		TransportationSystem tsa = new TransportationSystem(new Aeroplane());
		tsa.travel("Heathrow Intl", "LA Intl", Speed.SLOW);
		//"implementation" is hidden under the "abstraction" layer
		System.out.println();
		
		TransportationSystem tss = new TransportationSystem(new Spacecraft());
		tss.travel("Milky Way GAHQ", "Andromeda GAHQ", Speed.FAST);
		System.out.println();
		
		TransportationSystem tst = new TransportationSystem(new Teleporter());
		tst.travel("55°45′43″N 37°34′38″E", "33°49′N 117°55′W", Speed.FASTER);
		System.out.println();
		
		//"refined abstraction"
		AdvancedTransportationSystem atss = new AdvancedTransportationSystem(new Spacecraft());
		//additional functionality
		List<String> route = new ArrayList<>();
		route.add("ISS");
		route.add("Alpha Centauri ISS");
		route.add("Alpha Canis Majoris IGSS");
		route.add("ALpha Lyrae IGSS");
		route.add("Alpha Aquilae  IGSS");
		//"implementation" is still hidden
		atss.travelRoute(route, Speed.FASTER);
	}
}
