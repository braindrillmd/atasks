package io.anonexistentdomainname;

import io.anonexistentdomainname.Lists.MyArrayList;
import io.anonexistentdomainname.Lists.MyLinkedList;
import io.anonexistentdomainname.Lists.MyList;

public class MyListsTest {

	public static void main(String[] args) {
		System.out.println("MyLinkedList demo");
		listDemo(new MyLinkedList<>(), new MyLinkedList<>());
		System.out.println("\n\nMyArrayList demo");
		listDemo(new MyArrayList<>(), new MyArrayList<>());
	}
	
	public static void listDemo(MyList<String> list, MyList<Double> list2) {
		list.add("a-00");
		list.add("a-01");
		list.add("a-02");
		list.add("a-03");
		list.add("a-04");
		list.add("a-05");
		list.add("a-06");
		list.add("a-07");
		list.add("a-08");
		list.add("a-09");
		list.add("a-10");
		list.add("a-11");
		list.add("a-12");
		list.add("a-13");
		list.add("a-14");
		System.out.println("list: " + list.toString());
		
		list.add("b-15");
		System.out.println("add(\"b-15\"): " + list.toString());
		
		System.out.println("Let's add some more stuff:");
		list.add("b-16");
		list.add("b-17");
		list.add("b-18");
		list.add("b-19");
		System.out.println(list.toString());
		
		System.out.println("Let's add something in the middle:");
		list.add(15, "a-14.1");
		System.out.println("add(15, \"a-14.1\"): " + list.toString());
		
		System.out.println("And even more: ");
		list.add(15, "a-14.01");
		list.add(15, "a-14.001");
		list.add(15, "a-14.0001");
		System.out.println(list.toString());
		
		System.out.println("get(5): " + list.get(5));
		
		System.out.println("Let's remove something. For example this: " + list.get(16));
		list.remove(16);
		System.out.println("remove(16): " + list.toString());
		
		System.out.println("...and this: " + list.get(15));
		list.remove(15);
		System.out.println("remove(15): " + list.toString());
		
		System.out.println("Let's also remove these weird values: a-14.1, a-14.01");
		list.remove("a-14.1");
		System.out.println("remove(\"a-14.1\"): " + list.toString());
		list.remove("a-14.01");
		System.out.println("remove(\"a-14.01\"): " + list.toString());
		
		System.out.println("Let's replace some stuff, shall we?");
		list.set(3, "D-03");
		System.out.println("set(3, \"D-03\"): " + list.toString());
		list.set(4, "D-004");
		System.out.println("set(4, \"D-004\"): " + list.toString());
		list.set(5, "D-0005");
		System.out.println("set(5, \"D-0005\"): " + list.toString());
		list.set(6, "D-00006");
		System.out.println("set(6, \"D-00006\"): " + list.toString());
		
		System.out.println("Finally, let's make a view for our fancy 'D' values: " + "view = list.subList(3, 6)");
		MyList<String> view = list.subList(3, 6);
		System.out.println("view: " + view.toString());
		
		System.out.println("Wait, what about edge cases and another types?");
		list2.add(0.0);
		System.out.println("dList: " + list2.toString());
		list2.remove(0.0);
		System.out.println("remove(0.0) " + list2.toString());
		list2.add(1.1);
		list2.add(0, 10500.0);
		System.out.println("..., add(0, 10500.0) ,...");
		list2.add(2.2);
		list2.add(3.3);
		System.out.println("dList: " + list2.toString());
		list2.remove(10500.0);
		System.out.println("remove(10500.0): " + list2.toString());
		list2.remove(3.3);
		System.out.println("remove(3.3): " + list2.toString());
	}
}
