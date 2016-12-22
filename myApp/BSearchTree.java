import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
// Tree Nodes
 class TreeNode{
	int data;
	TreeNode left,right;

	//Creation of node
	public TreeNode(int value){
		data = value;
		left = null;
		right = null;
	}

	//getting and setting the values
	public void setData(int data){
		this.data = data;
	}

	public int getData(){
		return data;
	}

	public void setLeft(TreeNode left){
		this.left = left;
	}

	public TreeNode getLeft(){
		return left;
	}

	public void setRight(TreeNode right){
		this.right = right;
	}

	public TreeNode getRight(){
		return right;
	}
}

// Binary tree methods

 class BTMethods {
	TreeNode root, node;
	int total = 0;

	public void insert(int value) {
		insert(this.root, value);
	}

	// inserting the data at perticular position
	public void insert(TreeNode current, int value) {
		node = new TreeNode(value);
		if (root == null) {
			root = node;
			total++;
			System.out.println("Root is: " + root.data);
		} else {
			// Checking for left position
			if (value < current.getData()) {
				if (current.getLeft() == null) {
					current.setLeft(node);
					total++;
					System.out.println("root node " + current.data);
					System.out.println("left value: " + current.getLeft().data);
				} else {
					current = current.getLeft();
					this.insert(current, value);
				}
			}

			// Checking for Right position
			else {
				if (current.getRight() == null) {
					current.setRight(node);
					total++;
					System.out.println("root node " + current.data);
					System.out.println("right value: " + current.getRight().data);
				} else {
					current = current.getRight();
					this.insert(current, value);
				}
			}

		}
	}// end of insert

	public void getTreeCount() {
		int num = total;
		System.out.println("Total Elements:" + total);
		long result = catalan(num);
		System.out.println("Total Combinatios Possible: " + result);
	}

	public static long catalan(int num) {
		int res = 0;
		if (num <= 1) {
			return 1;
		}
		for (int i = 0; i < num; i++) {
			res += catalan(i) * catalan(num - i - 1);
		}
		return res;
	}
	public static void search(int key)
	{
			node = new TreeNode(value);
		if(root==null){
			System.out.println("Tree is Empty");	
		}
		else {
			node=root;
			if(node.data==key)
			{
				System.out.println("Element is Present at Root");	
			
			}
			
		}
	}
}

// Main class
public class BSearchTree{
	public static void main(String[] args) throws IOException{
		 BTMethods tree = new  BTMethods();
		boolean check = true;
		Scanner scanner=new Scanner(System.in);

		while(check){
			System.out.println("Please Select Your choice:\n1.Add Element\n2.Possible no. of Combinations\n3.Exit");
			int choice = scanner.nextInt();
			switch(choice){
				case 1:{
					System.out.print("Please Enter Value: ");
					int value = scanner.nextInt();
					tree.insert(value);
					break;
				}
				case 2:{
					tree.getTreeCount();
					break;
				}

				case 3:{
					check = false;
					break;	
				}

				default: {
					System.out.println("Entered Wrong Choice");
				}

			}
		}
		
	}
}

