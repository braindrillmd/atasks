package io.anonexistentdomainname.Lists;

@SuppressWarnings("rawtypes")
public class MyLinkedListTest extends MyListTest<MyLinkedList> {

	@Override
	protected MyLinkedList createInstance() {
		return new MyLinkedList();
	}
}
