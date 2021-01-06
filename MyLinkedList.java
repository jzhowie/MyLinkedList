//TODO: Add, get, set, double linked
//ISSUES: TBD
//NOTES: Setting node addresses, helper methods returning Nodes must be private

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
		return true;
	}
}

public boolean add(int index, String value) {
	if (size() == 0 || index == size - 1) {
		add(value);
		return true;
	}
	return true;
}

public String get(int index) {
	return "";
}

public String set(int index, String value) {
	return "";
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
