package io.anonexistentdomainname.Lists;

/**
 * Naive LinkedList implementation
 * @param <E> the type to work with
 */
public class MyLinkedList<E> implements MyList<E> {
	private class Node{
		E value;
		Node nextNode;
		Node prevNode;
		
		Node(E value, Node nextNode, Node prevNode){
			this.value = value;
			this.nextNode = nextNode;
			this.prevNode = prevNode;
		}
	}
	private Node head;
	private Node tail;
	private int size;
	
	@Override
	public String toString() {
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append("LinkedList<size=" + size + ">[");
		Node currentNode = head;
		String nullStr = "null";
		
		while(currentNode != null) {
			sbuilder.append(currentNode.value.toString())
					.append("<").append(currentNode.prevNode != null ? currentNode.prevNode.value.toString() : nullStr)
					.append(",").append(currentNode.nextNode != null ? currentNode.nextNode.value.toString() : nullStr)
					.append(">");
			
			currentNode = currentNode.nextNode;
			
			
			if(currentNode != null && currentNode.nextNode != null) {
				sbuilder.append(", ");
			}
		}
		return sbuilder.append("]").toString();
	}
	
	@Override
	public boolean add(E element) {
		if(size == 0) {
			head = new Node(element, null, null);
			tail = head;
		}else {
			Node newNode;
			if(size == 1) {
				newNode = new Node(element, null, head);
				head.nextNode = newNode;
			}else {
				newNode = new Node(element, null, tail);
				tail.nextNode = newNode;
			}
			tail = newNode;
		}
		
		incSize();
		
		return true;
	}

	@Override
	public void add(int index, E element) {
		checkBounds(index);
		
		Node nodeAfter = findNode(index);
		Node nodeBefore = nodeAfter.prevNode;
		
		Node newNode = new Node(element, nodeAfter, nodeBefore);
		if(nodeBefore != null) {
			nodeBefore.nextNode = newNode;
		}
		if(nodeAfter != null) {
			nodeAfter.prevNode = newNode;
		}
		
		if(index == 0) {
			head = newNode;
		}
		
		incSize();
	}
	
	@Override
	public E remove(int index) {
		checkBounds(index);
	
		E element = null;
		Node node = findNode(index);
		element = node.value;
		
		removeNode(node);
		
		if(index == 0) {
			head = node.nextNode;
		}
		if(index == size - 1){
			tail = node.prevNode;
		}
		
		size--;
		
		return element;
	}
	
	@Override
	public boolean remove(Object element) {
		Node currentNode = head;
		Node toDelete = null;
		boolean nodeFound = false;
		
		
		while(currentNode != null) {
			if((currentNode.value == null && element == null) ||
					(element != null && element.equals(currentNode.value))) {
				toDelete = currentNode;
				nodeFound = true;
				break;
			}else {
				currentNode = currentNode.nextNode;
			}
		}
		
		if(!nodeFound) {
			return false;
		}else {
			removeNode (toDelete);
		}
		
		size--;
		
		return true;
	}

	@Override
	public E get(int index) {
		checkBounds(index);
		
		Node elemAtIndex = findNode(index);
		
		return elemAtIndex.value;
	}

	@Override
	public E set(int index, E element) {
		Node node = findNode(index);
		E oldValue = node.value;
		node.value = element;
		
		return oldValue;
	}

	@Override
	public MyList<E> subList(int fromIndex, int toIndex) {
		checkBounds(toIndex);
		checkBounds(fromIndex);
		
		MyList<E> view = new MyLinkedList<>();
		
		if(fromIndex > toIndex) {
			return view;
		}
		
		Node currentNode = findNode(fromIndex);
		
		for(int i = fromIndex; i <= toIndex; i++) {
			view.add(currentNode.value);
			currentNode = currentNode.nextNode;
		}
		
		return view;
	}

	@Override
	public int size() {
		return size;
	}

	private Node getToIndexFromHead(int index) {
		if(size == 0) {
			return null;
		}
		
		Node currentNode = head;	
		if(size == 1) {
			return currentNode;
		}
		for(int i = 0; i < index; i++) {
			currentNode = currentNode.nextNode;
		}
		
		return currentNode;
	}
	
	private Node getToIndexFromTail(int index) {
		if(size == 0) {
			return null;
		}
		
		Node currentNode = tail;
		if(size == 1) {
			return currentNode;
		}
		
		for(int i = size - 1; i > index; i--) {
			currentNode = currentNode.prevNode;
		}
		
		return currentNode;
	}
	
	private Node findNode(int index) {
		Node elemAtIndex;
		
		if(index == 0) {
			return head;
		}
		
		if(Math.round(size / 2.0) <= 0) {
			elemAtIndex = getToIndexFromHead(index);
		}else {
			elemAtIndex = getToIndexFromTail(index);
		}
		
		return elemAtIndex;
	}
	
	private void checkBounds(int index) {
		boolean check = true;
		
		check &= index >= 0;
		check &= index < size;
		
		if(!check) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	private void removeNode(Node node) {
		Node nodeBefore = node.prevNode;
		Node nodeAfter = node.nextNode;
		
		if(nodeBefore != null) {
			nodeBefore.nextNode = nodeAfter;
		}
		
		if(nodeAfter != null) {
			nodeAfter.prevNode = nodeBefore;
		}
	}
	
	private void incSize() {
		if(size < Integer.MAX_VALUE) {
			size++;
		}
	}
}