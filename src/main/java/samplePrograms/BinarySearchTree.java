package samplePrograms;

class Node {
	public int value;
	public Node left, right;

	public Node(int value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
}

public class BinarySearchTree {

	public static boolean contains(Node root, int value) {
		//To verify its Binary Tree
		if((root.value >= root.left.value) && (root.value < root.right.value))	{
			//to verify if value is present
			if((root.left != null && root.left.value == value) || (root.right!=null) && (root.right.value == value)) {
				return true;
			}
			return false || (root.left != null && contains(root.left, value)) || (root.right!=null && contains(root.right, value));
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Node n1 = new Node(1, null, null);
		Node n3 = new Node(3, null, null);
		Node n2 = new Node(2, n1, n3);

		System.out.println(contains(n2, 3));
	}
}
