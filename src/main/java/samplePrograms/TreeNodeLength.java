package samplePrograms;

public class TreeNodeLength {
	
private TreeNodeLength leftChild, rightChild;
    
    public TreeNodeLength(TreeNodeLength leftChild, TreeNodeLength rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
    
    public TreeNodeLength getLeftChild() {
        return this.leftChild;
    }
    
    public TreeNodeLength getRightChild() {
        return this.rightChild;
    }

    public int height() {
      TreeNodeLength right = getRightChild();
  	  TreeNodeLength left = getLeftChild();
  	  int c = 1;
  	  int cLeft = 0;
  	  int cRight = 0;
  	 
  	  if ( left != null ) cLeft = left.height();
  	  if ( right != null ) cRight = right.height();
  	  
  	  c = left == null && right == null ? 0 : 1;
  	  
  	  return cLeft > cRight ? cLeft+c : cRight+c;
    }

    public static void main(String[] args) {
        TreeNodeLength leaf1 = new TreeNodeLength(null, null);
        TreeNodeLength leaf2 = new TreeNodeLength(null, null);
        TreeNodeLength node = new TreeNodeLength(leaf1, null);
        TreeNodeLength root = new TreeNodeLength(node, leaf2);
//        Node root = new Node(leaf1, null);

        System.out.println(root.height());
    }
}
