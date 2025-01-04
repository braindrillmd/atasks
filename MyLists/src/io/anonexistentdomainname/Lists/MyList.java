package io.anonexistentdomainname.Lists;

/**
 * My fancy list interface. Does stuff lists usually do. Go figure!
 * @param <E> the type we're gonna work with
 */
public interface MyList<E> {
	/**
	 * Insert an element into the list
	 * @param element the thing to insert
	 * @return true if successful, false if not
	 */
	boolean add(E element);
	
	/**
	 * Insert element into the list into a specific place
	 * @param index where to insert 
	 * @param element what to insert
	 */
	void add(int index, E element);
	
	/**
	 * Removes a thing from the list and returns it
	 * @param index the index of the element to be removed 
	 * @return the removed element
	 */
	E remove(int index);
	
	/**
	 * Remove the first occurrence of an element from the list
	 * @param element an element to remove
	 * @return true if there was something to remove 
	 */
	boolean remove(Object element);
	
	/**
	 * Get and element with the specified index
	 * @param index the index of the element
	 * @return the element itself
	 */
	E get(int index);
	
	/**
	 * Replace an element at the specified index with a new one
	 * @param index the specified index
	 * @param element the new element
	 * @return the element that was replaced
	 */
	E set(int index, E element);
	
	/**
	 * Get a view of the portion of the list (NB: not a new list) specified by the following indices 
	 * @param fromIndex the start of the view
	 * @param toIndex the end of the view
	 * @return the view (not a new list)
	 */
	MyList<E> subList(int fromIndex, int toIndex);
	
	/**
	 * Returns the size of the list
	 * @return the size, duh
	 */
	int size();
}
