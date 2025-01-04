package io.anonexistentdomainname.Lists;

/**
 * Naive ArrayList implementation
 * @param <E> the type to work with
 */
public class MyArrayList<E> implements MyList<E> {
	private final static int DEFAULT_CAPACITY = 10;
	
	int size;
	int capacity = DEFAULT_CAPACITY;
	Object[] array;
	
	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		
		sBuilder.append("MyArrayList<sz=" + size + ", cpt=" + capacity +">[");
		for(int i = 0; i < size; i++) {
			sBuilder.append(array[i] + "<" + i + ">");
			if(i != size - 1) {
				sBuilder.append(", ");
			}
		}
		
		return sBuilder.append("]").toString();
	}
	
	public MyArrayList(){
		array = new Object[DEFAULT_CAPACITY];
	}

	@Override
	public boolean add(E element) {
		memoryManagement();
		
		array[size] = element;
		
		incSize();
		
		return true;
	}

	@Override
	public void add(int index, E element) {
		checkIndex(index);
		memoryManagement();
		shiftArrayRight(index);
		array[index] = element;
		
		incSize();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) {
		checkIndex(index);
		
		Object element = array[index];
		
		shiftArrayLeft(index);
		
		size--;
		
		return (E)element;
	}

	@Override
	public boolean remove(Object element) {
		int elIndex = -1;
		for(int i = 0; i < size; i++) {
			if((element == null && array[i] == null) ||
					(element != null && element.equals(array[i]))) {
				elIndex = i;
			}
		}
		
		if(elIndex == -1) {
			return false;
		}else {
			shiftArrayLeft(elIndex);
			size--;
			return true;
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		checkIndex(index);
		
		return (E)array[index];
	}

	@SuppressWarnings("unchecked")
	@Override
	public E set(int index, E element) {
		checkIndex(index);
		
		Object old = array[index];
		
		array[index] = element;
		
		return (E)old;
	}

	@SuppressWarnings("unchecked")
	@Override
	public MyList<E> subList(int fromIndex, int toIndex) {
		MyList<E> view = new MyArrayList<>();
		
		for(int i = fromIndex; i <= toIndex; i++) {
			view.add((E)array[i]);
		}
		
		return view;
	}

	@Override
	public int size() {
		return size;
	}

	private void memoryManagement() {
		if(size >= capacity - 1) {
			capacity = capacity + (capacity >> 1);
			Object[] newArray = new Object[capacity];
			
			for(int i = 0; i < array.length; i++) {
				newArray[i] = array[i];
			}
			
			array = newArray;
		}
	}
	
	private void checkIndex(int index) {
		if(!(index >=0 && index < size)) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	private void shiftArrayRight(int index) {
		Object temp = null;
		boolean firstReloc = true;
		for(int i = index; i <= size; i++) {
			if(firstReloc) {
				firstReloc = false;	
				temp = array[i];
				array[i] = null;
				continue;
			}
			
			Object buffer = array[i];
			array[i] = temp;
			temp = buffer;
		}
	}
	
	private void shiftArrayLeft(int index) {
		for(int i = index; i <= size; i++) {
			array[i]=array[i+1];
			
			if(i == size) {
				array[i] = null;
			}
		}
	}
	
	private void incSize() {
		if(size <= Integer.MAX_VALUE) {
			size++;
		}
	}
}
