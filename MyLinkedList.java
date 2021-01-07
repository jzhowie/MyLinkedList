//TODO: remove / extend
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
	return;
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

public String remove(int index) {
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
	size--;
	return temp;
}

}
