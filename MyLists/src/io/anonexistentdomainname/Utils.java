package io.anonexistentdomainname;

import java.util.ArrayList;
import java.util.List;

import io.anonexistentdomainname.Lists.MyList;

public class Utils {
	static public <E> boolean listsAreEqual(MyList<E> myList1, MyList<E> myList2) {
		if(myList1.size() != myList2.size()) {
			return false;
		}
		
		List<E> myList1Converted = new ArrayList<E>();
		
		for(int i = 0; i < myList1.size(); i++) {
			myList1Converted.add(myList1.get(i));
		}
		
		return listsAreEqual(myList1Converted, myList2);
	}
	
	static public <E> boolean listsAreEqual(List<E> list, MyList<E> myList) {
		if(list.size() != myList.size()) {
			return false;
		}
		
		List<E> myListConverted = new ArrayList<E>();
		
		for(int i = 0; i < list.size(); i++) {
			myListConverted.add(myList.get(i));
		}
		
		return listsAreEqual(list, myListConverted);
	}
	
	static public <E> boolean listsAreEqual(List<E> list, List<E> myList) {
		if(list == null || myList == null) {
			return false;
		}
		
		if(myList.size() != list.size()) {
			return false;
		}
		
		//I'd like to check if elements' order is the same, so...
		for(int i = 0; i < myList.size(); i++) {
			if((myList.get(i) == null && list.get(i) != null ) || 
					(myList.get(i) != null && !myList.get(i).equals(list.get(i)))) {
				return false;
			}
		}
		
		return true;
	}
}

