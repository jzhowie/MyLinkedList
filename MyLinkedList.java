//TODO: double linked, index-based exceptions (look at java doc for that)
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
		size++;
		return true;
	}
	else {
		Node a = new Node(value);
		end.setNext(a);
		end = a;
		size++;
		return true;
	}
}

public boolean add(int index, String value) {
	if (size() == 0 || index == size()) {
		add(value);
		return true;
	}
	else if (index == 0) {
		Node a = new Node(value);
		a.setNext(start);
		start = a;
		size++;
		return true;
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
		temp.setNext(a);
		size++;
		return true;
	}
}

public String get(int index) {
	Node current = start;
	for (int i = 0; i < index; i++) {
		current = current.getNext();
	}
	return current.getValue();
}

public String set(int index, String value) {
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
	String thing = "";
	while (current != null) {
		thing += current.getValue() + ", ";
		current = current.getNext();
	}
	return thing;
}

}
