package gfg.tree;

import java.util.Stack;

public class IterativeTreeTraversals {

	static Stack<Node> stack = new Stack<Node>();

	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(6);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.left = new Node(5);
		root.right.right = new Node(7);

		preOrderIterative(root);
		inorder(root);
		MorrisTraversal(root);
	}

	static void preOrderIterative(Node root) {
		if (root != null) {
			stack.push(root);
		}
		while (!stack.isEmpty()) {
			Node pop = stack.pop();
			System.out.print(pop.data + " ");
			if (pop.right != null) {
				stack.push(pop.right);
			}

			if (pop.left != null) {
				stack.push(pop.left);
			}
		}
		System.out.println();
	}

	// InOrder Traversal without Stack
	static void MorrisTraversal(Node root) {
		Node current, pre;

		if (root == null)
			return;

		current = root;
		while (current != null) {
			if (current.left == null) {
				System.out.print(current.data + " ");
				current = current.right;
			} else {
				/* Find the inorder predecessor of current */
				pre = current.left;
				while (pre.right != null && pre.right != current)
					pre = pre.right;

				/* Make current as right child of its inorder predecessor */
				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				}

				/*
				 * Revert the changes made in if part to restore the original
				 * tree i.e.,fix the right child of predecssor
				 */
				else {
					pre.right = null;
					System.out.print(current.data + " ");
					current = current.right;
				} /* End of if condition pre->right == NULL */

			} /* End of if condition current->left == NULL */

		} /* End of while */

	}

	static void inorder(Node root) {
		if (root == null)
			return;

		Stack<Node> s = new Stack<Node>();
		Node curr = root;

		// traverse the tree
		while (curr != null || s.size() > 0) {

			/*
			 * Reach the left most Node of the curr Node
			 */
			while (curr != null) {
				/*
				 * place pointer to a tree node on the stack before traversing
				 * the node's left subtree
				 */
				s.push(curr);
				curr = curr.left;
			}

			/* Current must be NULL at this point */
			curr = s.pop();

			System.out.print(curr.data + " ");

			/*
			 * we have visited the node and its left subtree. Now, it's right
			 * subtree's turn
			 */
			curr = curr.right;
		}
		System.out.println();
	}

}
