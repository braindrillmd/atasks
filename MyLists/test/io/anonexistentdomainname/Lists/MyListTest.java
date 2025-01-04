package io.anonexistentdomainname.Lists;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import io.anonexistentdomainname.Utils;

@SuppressWarnings("rawtypes")
public abstract class MyListTest<T extends MyList> {
	@SuppressWarnings("unused")
	private T instance;
	protected abstract T createInstance();
	//got this technique from here:
	//https://stackoverflow.com/questions/16237135/writing-a-single-unit-test-for-multiple-implementations-of-an-interface
	
	MyList<String> myList;
	MyList<String> myBigList;
	List<String> testList;
	
	@SuppressWarnings("unchecked")
	@Before
	public void doInitialisation() {
		instance = createInstance();
		
		myList = createInstance();
		myBigList = createInstance();
		testList = new ArrayList<>();
		
		for(int i = 0; i < 25; i++) {
			myBigList.add(String.valueOf(i));
			testList.add(String.valueOf(i));
		}
	}

	@Test
	public void sizeIncreasesAfterAddingElem() {
		myList.add("bar");
		int initialSize = myList.size();
		myList.add(0, "foo");
		
		assertTrue(initialSize + 1 == myList.size());
	}
	
	@Test
	public void sizeIncreasesAfterAddingElemWithIndex() {
		int initialSize = myList.size();
		
		myList.add("foo");
		
		assertTrue(initialSize + 1 == myList.size());
	}
	
	@Test
	public void newElementAvailableAfterAddingToEmptyList() {
		String addVal = "foo";
		
		myList.add(addVal);
		
		assertTrue(addVal.equals(myList.get(0)));
	}
	
	@Test
	public void newElementAvailableAfterAddingToNonEmptyList() {
		String addVal = "foo";
		myList.add("a");
		myList.add("b");
		myList.add("&");
		
		myList.add(addVal);
		
		assertTrue(addVal.equals(myList.get(3)));
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void throwsExceptionWhenTryingAccessOutOfBounds() {
		myList.add("foo");
		myList.add("bar");
		
		myList.get(42);
	}
	
	@Test
	public void findsElementCloseToHead() {
		assertTrue("3".equals(myBigList.get(3)));
	}
	
	@Test
	public void findsElementCloseToTail() {
		assertTrue("23".equals(myBigList.get(23)));
	}
	

	@Test
	public void addElemWorksSameAsListProper() {
		testList.add("foo");
		myBigList.add("foo");
		
		assert(Utils.listsAreEqual(testList, myBigList));
	}
	
	@Test
	public void removeByIndexRemoveThings() {
		@SuppressWarnings("unchecked")
		MyList<String> list1 = createInstance();
		@SuppressWarnings("unchecked")
		MyList<String> list2 = createInstance();
		list1.add("0 blah");
		list1.add("1 foo");
		list1.add("2 bar");
		list1.add("3 123");
		list2.add("0 blah");
		list2.add("1 foo");
		list2.add("2* doh");
		list2.add("2 bar");
		list2.add("3 123");
		
		list2.remove(2);
		
		if(list1.size() == 0 || list2.size() == 0) {
			fail();
		}
		assertTrue(Utils.listsAreEqual(list1, list2));
	}
	
	@Test
	public void removeByIndexReturnsRemovedElement() {
		@SuppressWarnings("unchecked")
		MyList<String> list = createInstance();
		String elementToRemoveValue = "doh";
		list.add("foo");
		list.add(elementToRemoveValue);
		list.add("bar");
		
		String returnedValue = list.remove(1);
		
		assertTrue(elementToRemoveValue.equals(returnedValue));
	}
	
	@Test
	public void removeByValueDoesTheThing() {
		@SuppressWarnings("unchecked")
		MyList<Double> list1 = createInstance();
		@SuppressWarnings("unchecked")
		MyList<Double> list2 = createInstance();
		list1.add(0.0);
		list1.add(1.0);
		list1.add(2.0);
		list1.add(3.0);
		list2.add(0.0);
		list2.add(1.0);
		list2.add(42.0);
		list2.add(2.0);
		list2.add(3.0);
		
		list2.remove(42.0);
		
		if(list1.size() == 0 || list2.size() == 0) {
			fail();
		}
		assertTrue(Utils.listsAreEqual(list1,list2));
	}
	
	@Test
	public void removeByValueOnlyRemovesFirstOccurence() {
		@SuppressWarnings("unchecked")
		MyList<Double> list1 = createInstance();
		@SuppressWarnings("unchecked")
		MyList<Double> list2 = createInstance();
		list1.add(42.0);
		list1.add(42.0);
		list1.add(42.0);
		list1.add(42.0);
		list2.add(42.0);
		list2.add(42.0);
		list2.add(42.0);
		list2.add(42.0);
		list2.add(42.0);
		
		list2.remove(42.0);
		
		if(list1.size() == 0 || list2.size() == 0) {
			fail();
		}
		assertTrue(Utils.listsAreEqual(list1,list2));
	}
	
	@Test
	public void removingElementFromListWithSoleElementWorks() {
		@SuppressWarnings("unchecked")
		MyList<String> list = createInstance();
		list.add("foobar");
		
		if(list.size() == 0) {
			fail();
		}
		
		list.remove("foobar");
		
		assert(list.size() == 0);
	}
	
	@Test
	public void setReplacesValueCorrectly() {
		@SuppressWarnings("unchecked")
		MyList<String> list = createInstance();
		String replacementValue = "bar";
		list.add("1");
		list.add("foo");
		list.add("2");
		list.add("3");
		
		list.set(1, replacementValue);
		
		assertTrue(replacementValue.equals(list.get(1)));
	}
	
	@Test
	public void setReturnsPreviousValue() {
		@SuppressWarnings("unchecked")
		MyList<String> list = createInstance();
		String prevValue = "bar";
		list.add("1");
		list.add("foo");
		list.add(prevValue);
		list.add("3");
		
		String oldValue = list.set(2, "whatever");
		
		assertTrue(prevValue.equals(oldValue));
	}
	
	@Test
	public void subListReturnsCorrectView() {
		@SuppressWarnings("unchecked")
		MyList<String> source = createInstance();
		source.add("0");
		source.add("1");
		source.add("2");
		source.add("foo");
		source.add("a");
		source.add("b");
		source.add("c");
		source.add("bar");
		source.add("8");
		source.add("9");
		source.add("10");
		@SuppressWarnings("unchecked")
		MyList<String> whatWeShouldGet = createInstance();
		whatWeShouldGet.add("foo");
		whatWeShouldGet.add("a");
		whatWeShouldGet.add("b");
		whatWeShouldGet.add("c");
		whatWeShouldGet.add("bar");
		
		MyList<String> view = source.subList(3, 7);
		
		if(source.size() == 0 || whatWeShouldGet.size() == 0 || view == null) {
			fail();
		}
		
		assertTrue(Utils.listsAreEqual(view, whatWeShouldGet));
	}
	
	@Test
	public void removingHeadWorksCorrect() {
		@SuppressWarnings("unchecked")
		MyList<String> list1 = createInstance();
		list1.add("head");
		list1.add("not a head");
		list1.add("also not a head");
		@SuppressWarnings("unchecked")
		MyList<String> list2 = createInstance();
		list2.add("not a head");
		list2.add("also not a head");
		
		list1.remove(0);
		
		if(list1.size() == 0 || list2.size() == 0) {
			fail();
		}
		assertTrue(Utils.listsAreEqual(list1,list2));
	}
	
	@Test
	public void removingTailWorksCorrect() {
		@SuppressWarnings("unchecked")
		MyList<String> list1 = createInstance();
		list1.add("not a tail");
		list1.add("still not a tail");
		list1.add("2");
		list1.add("3");
		list1.add("4");
		list1.add("5");
		list1.add("tail");
		
		list1.remove(6);

		//fails if tail doesn't get reset because if (index > round(size / 2) == true)
		//the search starts from the tail
		//well, for MyLinkedList anyway
		assertTrue("4".equals(list1.get(4)));
	}
	
	@Test
	public void sizeGetsDeterminedCorrectly() {
		@SuppressWarnings("unchecked")
		MyList<Integer> list = createInstance();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		assertTrue(list.size() == 4);
	}
	
	@Test
	public void addingLotsOfStuffWorks() {
		@SuppressWarnings("unchecked")
		MyList<Integer> likeALot = createInstance();
		int reasonableNumber = Integer.MAX_VALUE/100;
		likeALot.add(-1);
		
		if(likeALot.size() == 0) {
			fail();
		}
		
		for(int i = 0; i < reasonableNumber; i++) {
			likeALot.add(Integer.valueOf(i));
		}
		
		assertTrue(likeALot.size() == reasonableNumber + 1);
	}
}
