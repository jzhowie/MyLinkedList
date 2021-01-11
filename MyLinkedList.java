//TODO: Testing
//ISSUES: TBD
//NOTES: Helper methods returning Nodes must be private

public class MyLinkedList {

private int size;
private Node start,end;

public MyLinkedList() {
	size = 0;
	start = null;
	end = null;
}

private Node getStart() {
	return start;
}

private Node getEnd() {
	return end;
}

private void clear() {
	start = null;
	end = null;
	size = 0;
}

public int size() {
	return size;
}

public boolean add(String value) {
	if (size() == 0) {
		Node a = new Node(value);
		start = a;
		end = a;
	}
	else {
		Node a = new Node(value);
		end.setNext(a);
		a.setPrevious(end);
		end = a;
	}
	size++;
	return true;
}

public void add(int index, String value) {
	if (index < 0 || index > size()) {
		throw new IndexOutOfBoundsException("Index (" + index + ") out of range.");
	}
	if (size() == 0 || index == size()) {
		add(value);
	}
	else if (index == 0) {
		Node a = new Node(value);
		a.setNext(start);
		start.setPrevious(a);
		start = a;
		size++;
	}
	else {
		Node current = start;
		for (int i = 0; i < index - 1; i++) {
			current = current.getNext();
		}
		Node temp = current;
		Node temp2 = current.getNext();
		Node a = new Node(value);
		a.setNext(temp2);
		a.setPrevious(temp);
		temp.setNext(a);
		temp2.setPrevious(a);
		size++;
	}
}

public String get(int index) {
	if (index < 0 || index >= size()) {
		throw new IndexOutOfBoundsException("Index (" + index + ") out of range.");
	}
	Node current = start;
	for (int i = 0; i < index; i++) {
		current = current.getNext();
	}
	return current.getValue();
}

public String set(int index, String value) {
	if (index < 0 || index >= size()) {
		throw new IndexOutOfBoundsException("Index (" + index + ") out of range.");
	}
	Node current = start;
	for (int i = 0; i < index; i++) {
		current = current.getNext();
	}
	String temp = current.getValue();
	current.setValue(value);
	return temp;
}

public String toString() {
	Node current = start;
	String thing = "[";
	while (current != null) {
		thing += current.getValue();
		current = current.getNext();
		if (current != null) {
			thing += ", ";
		}
	}
	return thing + "]";
}

public String toStringReversed() {  // test function
	Node current = end;
	String thing = "[";
	while (current != null) {
		thing += current.getValue();
		current = current.getPrevious();
		if (current != null) {
			thing += ", ";
		}
	}
	return thing + "]";
}

public String remove(int index) {
	if (index < 0 || index >= size()) {
		throw new IndexOutOfBoundsException("Index (" + index + ") out of range.");
	}
	String temp = start.getValue();
	if (size() == 1) {
		start = null;
		end = null;
	}
	else if (index == 0) {
		start = start.getNext();
		start.getPrevious().setNext(null);
		start.setPrevious(null);
	}
	else if (index == size() - 1) {
		temp = end.getValue();
		end = end.getPrevious();
		end.getNext().setPrevious(null);
		end.setNext(null);
	}
	else {
		Node current = start;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		temp = current.getValue();
		current.getNext().setPrevious(current.getPrevious());
		current.getPrevious().setNext(current.getNext());
		current.setPrevious(null);
		current.setNext(null);
	}
	size--;
	return temp;
}

public void extend(MyLinkedList other) {
	if (other.size() == 0) {
		return;
	}
	else if (size() == 0) {
		start = other.getStart();
		end = other.getEnd();
		size = other.size();
		other.clear();
	}
	else {
		getEnd().setNext(other.getStart());
		other.getStart().setPrevious(getEnd());
		end = other.getEnd();
		size = size() + other.size();
		other.clear();
	}
}
}
