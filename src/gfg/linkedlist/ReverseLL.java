package gfg.linkedlist;

public class ReverseLL {

	public static void main(String[] args) {

		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);

		Node reverse = reverse(head);

		print(reverse);

		Node original = reverse(reverse);

		print(original);

		int k = 2;
		print(reverseInGroup(original, k));

	}

	private static Node reverseInGroup(Node head, int k) {
		if (head == null) {
			return head;
		}
		int counter = k;

		Node curr = head;
		Node prev = null;

		while (counter-- > 0 && curr != null) {
			Node tmp;
			tmp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = tmp;
		}

		head = prev;

		while (head.next != null) {
			head = head.next;
		}

//		if (head != null) {
			head.next = reverseInGroup(curr, k);
//		}

		return prev;
	}

	private static void print(Node reverse) {
		while (reverse != null) {
			System.out.print(reverse.data + " ");
			reverse = reverse.next;
		}
		System.out.println();
	}

	static Node reverse(Node head) {
		if (head == null) {
			return head;
		}
		Node curr = head;

		Node prev = null;

		while (curr != null) {
			Node tmp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = tmp;
		}

		return prev;
	}

}

class Node {

	int data;

	Node next;

	public Node(int data) {
		super();
		this.data = data;
	}

}
