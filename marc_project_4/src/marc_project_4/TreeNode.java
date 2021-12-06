package marc_project_4;

//individual nodes of the binary tree

public class TreeNode<T>{
	
	private T element;//element of specified node
	
	//protected String key;
	
	private TreeNode<T> left;//pointer to the next left node
	
	private TreeNode<T> right;//pointer to the next right node
	
	
	
	//default TreeNode construction
	public TreeNode(){
		this.element=null;//everything is set to null
		
		this.left=null;//everything is set to null
		
		this.right=null;//everything is set to null
		
	}
	
	//augmented constructor 
	//will only set a node value, no pointers
	//@paramater: element is the value of the individual node
	public TreeNode(T element) {
		this.element=element;//element is the passed paramter
		
		//this.key = String.valueOf(element);
		
		this.left=null;//left is set to null
		
		this.right=null;//right is set to null
	}
	
	//augmented constructor
	//will set all PDMs
	//@parameters, element is the new element, left is the pointer to the left node
	//right is the pointer to the right node
	public TreeNode(T element, TreeNode<T> left, TreeNode<T> right) {
		this.element=element;
		
		//this.key = String.valueOf(element);
		
		this.left=left;
		
		this.right=right;
	}
	
	//return element of node
	public T getElement() {
		return this.element;
	}
	
	//set element of node to a specific element
	//@parameter element
	public void setElement(T element) {
		this.element=element;
	}
	
	//return the node the right is pointing to
	public TreeNode<T> getRight() {
		return this.right;
	}
	
	//return the nnode the left is pointing too
	public TreeNode<T> getLeft() {
		return this.left;
	}
	
	//set the right node to a new pointer
	public void setRight(TreeNode<T> newNode) {
		this.right=newNode;
	}
	
	//set the left node to a new pointer
	public void setLeft(TreeNode<T> newNode) {
		this.left=newNode;
	}
	
	
//	@Override
//	public int compareTo(T o) throws TreeException{
//		if(this.element!=null && o != null)
//		{
//			if ((int) this.element < (int) o)
//				return -1;
//			else if (this.element == o)
//				return 0;
//			else {
//				return 1;
//			}
//		}
//		else
//		{
//				throw new TreeException("Cannot compare to null");
//		}
//	}
	
	

}
