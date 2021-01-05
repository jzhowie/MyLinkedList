//TODO: Add, get, set, toString, double linked
//ISSUES: TBD
//NOTES: Prioritize toString once you get the list working, helper methods returning Nodes must be private

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
		start = new Node(value);
		size++;
		return true;
	}
	else {
		return true;
	}
}

public boolean add(int index, String value) {
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
		thing += current.value() + ", ";
		current = current.next();
	}
	return thing;
}

}
