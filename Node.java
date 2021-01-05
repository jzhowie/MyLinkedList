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

public String value() {
	return data;
}

public Node next() {
	return next;
}

public Node previous() {
	return prev;
}
}
