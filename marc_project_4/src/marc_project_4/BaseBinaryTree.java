package marc_project_4;

//super class of tree
public class BaseBinaryTree<T extends Comparable<T>> {
	
	protected TreeNode<T> root;//root of the tree is a node
	
	//default constructor
	//set root to null
	public BaseBinaryTree() {
		this.root=null;
	}

	//augmented constrcutor
	//paramater: new item that will serve as the root
	public BaseBinaryTree(T rootItem) {
		this.root=new TreeNode<T>(rootItem,null,null);
	}
	
	//augmented constrcutor
	//paramater: new item that will serve as the root
	protected BaseBinaryTree(TreeNode<T> rootItem) {
		this.root=rootItem;//copy new node into root
		}
	
	//return weather or not this root is null
	public boolean isEmpty() {
		return this.root == null;
	}
	
	//set root to null
	public void makeEmpty() {
		this.root=new TreeNode<T>();
	}
	
	//retuturn node of root
	public TreeNode<T> getRoot(){
			return this.root;
	}
	
	//retuturn node ELEMENT of root
	public T getRootElement() throws TreeException{
		if(this.root==null) {
			throw new TreeException("Tree is empty");
		}
		else
		{
			return this.root.getElement();
		}
	}
	
	
	
}
