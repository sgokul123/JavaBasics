public class TreeNode{
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
