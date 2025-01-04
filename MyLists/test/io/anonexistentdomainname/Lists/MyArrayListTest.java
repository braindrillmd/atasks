package io.anonexistentdomainname.Lists;

@SuppressWarnings("rawtypes")
public class MyArrayListTest extends MyListTest<MyArrayList> {

	@Override
	protected MyArrayList createInstance() {
		return new MyArrayList();
	}
}
