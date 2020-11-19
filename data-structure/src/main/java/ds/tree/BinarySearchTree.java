package ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

	private static Queue<Node> queue = new LinkedList<>();
	
	public static void main(String[] args) {
		Node root = null;
//		root = insert(root,5);
		root = insert(root,15);
		root = insert(root,10);
		root = insert(root,12);
		root = insert(root,20);
		root = insert(root,25);
		root = insert(root,30);
		root = insert(root,5);
		root = insert(root,24);
//		root = insert(root,5);
		
		printNode(root);
		printNode(search(root, 0));
		System.out.println(min(root));
		System.out.println(max(root));
		System.out.println(height(root));
		System.out.println("--Pre Order");
		showTreePreOrder(root);
		
		System.out.println();
		System.out.println("--In Order");
		showTreeInOrder(root);
		
		System.out.println();
		System.out.println("--Post Order");
		showTreePostOrder(root);
		
		System.out.println();
		System.out.println("--Level Order");
		showTreeByLevel(root);
		
		// check Binary Search Tree
		Node node = new Node(10);
		Node left = new Node(5);
		Node right = new Node(12);
		node.left = left;
		node.right = right;
		left.left = new Node(2);
		left.right = new Node(8);
		System.out.println();
		System.out.println("Binary Search Tree->"+isBinarySearchTree(node));
		
	}
	
	public static Node insert(Node root, int data) {
		if(root==null)
			root = new Node(data);
		else if(data<=root.data)
			root.left = insert(root.left,data);
		else
			root.right = insert(root.right,data);
		return root;
	}
	
	public static Node search(Node root, int data) {
		if(root==null) 
			return null;
		else if(root.data==data)
			return root;
		else if(data<=root.data)
			return search(root.left, data);
		else
			return search(root.right, data);
	}
	
	public static int min(Node root) {
		if(root==null)
			System.out.println("Tree in Empty!!");
//		while(root.left!=null) {
//			root=root.left;
//		}
		if(root.left!=null)
			return min(root.left);
		else
			return root.data;
	}
	
	public static int max(Node root) {
		if(root==null)
			System.out.println("Tree in Empty!!");
//		while(root.right!=null) {
//			root=root.right;
//		}
		
		if(root.right==null)
			return root.data;
		else 
			return max(root.right);
	}
	
	public static int height(Node root) {
		if(root==null)
			return -1;
		else
			return Math.max(height(root.left), height(root.right))+1;
	}
	
	public static void printNode(Node node) {
		if(node==null) 
			System.out.println("Empty Node!");
		else
			System.out.println("left:"+(node.left==null?null:node.left.data)+"<-data:"+node.data+"->"+"right:"+(node.right==null?null:node.right.data));
	}
	
	public static void showTreePreOrder(Node root){
		if(root==null) return;
		
		System.out.print(root.data+",");
		showTreePreOrder(root.left);
		showTreePreOrder(root.right);
			
	}
	
	public static void showTreeInOrder(Node root){
		if(root==null) return;
		
		showTreeInOrder(root.left);
		System.out.print(root.data+",");
		showTreeInOrder(root.right);
			
	}
	
	public static void showTreePostOrder(Node root){
		if(root==null) return;
		
		showTreePostOrder(root.left);
		showTreePostOrder(root.right);
		System.out.print(root.data+",");
	}
	
	public static void showTreeByLevel(Node root) {
		queue.add(root);
		while(!queue.isEmpty()) {
			Node currentNode = queue.poll();
			System.out.print(currentNode.data+",");
			if(currentNode.left!=null)
				queue.add(currentNode.left);
			if(currentNode.right!=null)
				queue.add(currentNode.right);
		}
	}
	
	public static boolean isBinarySearchTree(Node root) {
		if(root==null) {
			return true;
		} else if(isLeftSubTreeLesser(root.left, root.data)
				&& isRightSubTreeGreater(root.right, root.data)
				&& isBinarySearchTree(root.left)
				&& isBinarySearchTree(root.right)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isLeftSubTreeLesser(Node root, int val) {
		if (root == null)
			return true;
		if(root.data <= val 
				&& isLeftSubTreeLesser(root.left, val) 
				&& isLeftSubTreeLesser(root.right, val))
			return true;
		else
			return false;
	}
	
	public static boolean isRightSubTreeGreater(Node root, int val) {
		if (root == null)
			return true;
		if(root.data > val 
				&& isRightSubTreeGreater(root.left, val) 
				&& isRightSubTreeGreater(root.right, val))
			return true;
		else
			return false;
	}
}
