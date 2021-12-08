package marc_project_4;

//create a binary tree 
public class BinaryTree<T extends Comparable<T>> extends BaseBinaryTree<T> {
	
	//default constrcutor
	//call the super, setting everything to null
	public BinaryTree() {
		super();
	}
	
	//creat a binary tree from a single element
	//call super
	public BinaryTree(T rootItem) {
		super(rootItem);
	}
	
	//creat a binary tree from a node
	//call super
	public BinaryTree(TreeNode<T> rootItem) {
		super(rootItem);
	}
	
	//set root item to new root Item
	public void setRoot(T newItem) {
		if(this.root != null) {
			this.root.setElement(newItem);
		}
		else
		{
			this.root = new TreeNode<T>(newItem,null,null);
		}
	}
	
	//attach new node to the left
	public void attachLeft(T newItem) throws TreeException{
		if(!isEmpty() && this.root.getLeft()==null){
			this.root.setLeft(new TreeNode<T>(newItem,null,null));//the element has been added to the left
		}
		else if(isEmpty()) {
			throw new TreeException("Empty tree, cannot attach to left");//if empty throw exception
		}
		else if(this.root.getLeft()!=null) {//if alright a child throw exception
			throw new TreeException("there is already a left child");
		}
	}
	//attach new node to the right
	public void attachRight(T newItem) throws TreeException{
		if(!isEmpty() && this.root.getRight()==null){
			this.root.setRight(new TreeNode<T>(newItem,null,null));//new node added to the right
		}
		else if(isEmpty()) {
			throw new TreeException("Empty tree, cannot attach to right");//if root is null throw exception
		}
		else if(this.root.getRight()!=null) {
			throw new TreeException("there is already a right child");//if already a right node throw excpetion
		}
	}
	
	//attach sub tree to the left
	public void attachLeftSubtree(BinaryTree<T> leftTree) throws TreeException{
		if(isEmpty()) {
			throw new TreeException("Cannot add subtree to empty tree");//throw excpetion if empty
		}
			else if(this.root.getLeft()!=null) {
				throw new TreeException("cannot overwrite pre-existing left subtree");//throw exception if left already has a tree
			}
			else {
				this.root.setLeft(leftTree.root);//copy the node into the tree
				leftTree.makeEmpty();//erease the original root
			}
	}
	
	//attach tree to the right
	public void attachRightSubtree(BinaryTree<T> rightTree) throws TreeException{
		if(isEmpty()) {
			throw new TreeException("Cannot add subtree to empty tree");
		}
			else if(this.root.getRight()!=null) {
				throw new TreeException("cannot overwrite pre-existing right subtree");
			}
			else {
				this.root.setRight(rightTree.root);//copy the node into the tree
				rightTree.makeEmpty();//erease the original node root
			}
	}
	
	//return and remove the left subtree
	public BinaryTree<T> detachLeftSubtree() throws TreeException{
		if(isEmpty()) {
			throw new TreeException("cannot detatch left-subtree on empty tree");
		}
		else if(this.root.getLeft()==null) {
			throw new TreeException("cannot detach left-subtree, left subtree is null");
		}
		else {
			BinaryTree<T> leftTree= new BinaryTree<T>(this.root.getLeft());
			this.root.setLeft(null);
			return leftTree;
		}
	}
	
	//copy left sub tree
	
	public BinaryTree<T> copyLeftSubTree() throws TreeException{
		if(isEmpty()) {
			throw new TreeException("cannot copy left-subtree on empty tree");
		}
		else if(this.root.getLeft()==null) {
			throw new TreeException("cannot copy left-subtree, left subtree is null");
		}
		else {
			BinaryTree<T> leftTree= new BinaryTree<T>(this.root.getLeft());
			return leftTree;
		}
		
	}
	
	//copy right subtree
	public BinaryTree<T> copyRightSubtree() throws TreeException{
		if(isEmpty()) {
			throw new TreeException("cannot copy right-subtree on empty tree");
		}
		else if(this.root.getRight()==null) {
			throw new TreeException("cannot copy right-subtree, right subtree is null");
		}
		else {
			BinaryTree<T> rightTree= new BinaryTree<T>(this.root.getRight());
			return rightTree;
		}
	}
	
	
	//detach and return the right subtree
	public BinaryTree<T> detachRightSubtree() throws TreeException{
		if(isEmpty()) {
			throw new TreeException("cannot detatch right-subtree on empty tree");
		}
		else if(this.root.getRight()==null) {
			throw new TreeException("cannot detach right-subtree, right subtree is null");
		}
		else {
			BinaryTree<T> rightTree= new BinaryTree<T>(this.root.getRight());
			this.root.setLeft(null);
			return rightTree;
		}
	}
	
	
	
	
	
}
