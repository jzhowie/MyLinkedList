//TODO:
//ISSUES: TBD
//NOTES:

public class Node {

public Node(String value){
	data = value;
	next = null;
	prev = null;
}

private String data;
private Node next,prev;

public String getValue() {
	return data;
}

public Node getNext() {
	return next;
}

public Node getPrevious() {
	return prev;
}


public void setValue(String val) {
	data = val;
}

public void setNext(Node set) {
	next = set;
}

public void setPrevious(Node set) {
	prev = set;
}
}
