package marc_project_4;

public class BinarySearchTree<T extends Comparable<T>> implements Comparable<T>{

	protected TreeNode<T> root;

	public BinarySearchTree() {
		this.root = null;
	}
	
	
	// augmented constructor
	// @paramater pass a binary tree and turn into a binary search tree
	public BinarySearchTree(T newTree) {
		
		this.root= new TreeNode<T>(newTree);
	}
	

	// augmented constructor
	// @paramater pass a binary tree and turn into a binary search tree
	public BinarySearchTree(TreeNode<T> newTree) {
		this.root=newTree;
	}
	
	//return root node
	public TreeNode<T> getRoot() {
		return this.root;
	}
	
	//return root element
	public T getRootElement() {
		return this.root.getElement();
	}
	
	//set root to new root node
	public void setRoot(T element) {
		TreeNode<T> newRoot = new TreeNode<T>(element);
		this.root=newRoot;
		
	}
	
	//set root to null node
	public void makeEmpty() {
		this.root=new TreeNode<T>();
	}
	
	//return if this root is null
	public boolean isEmpty() {
		return this.root==null;
	}

	// boolean return type
	// determines if item is in the list
	public boolean search(T element, BinarySearchTree<T> subTree) {
		
		
			switch (subTree.compareTo(element)) {// compare the current node to the element to search for

			case 0:// they are equal

				return true;
			case 1:// continue through the tree on the left since the current node is larger
				if (subTree.root.getLeft() == null) {// next node is null, meaning there is no item that could be the
													// element
					return false;
				} else {
					return search(element,new BinarySearchTree<T>(subTree.root.getLeft()));// if the left node is not null, move to that tree node
				}
			case -1: // the current node is smaller,move to the right
				if (subTree.root.getRight() == null) { // if next right node is null, return false
					return false;
				} else {
					return search(element, new BinarySearchTree<T>(subTree.root.getRight())); // swing to the right tree node
				}

			}
		

		return false;
	}
	
	public void insert(T element) {
		this.root = insert(element,this);
	}

	// insert an item into the list
	// used in the constrcutor class to instantiate a BinarySearchTree, also a
	// public class to insert elements into the list
	// @paramaters, element to insert into the list
	protected TreeNode<T> insert(T element, BinarySearchTree<T> subTree) {
		
		if(this.getRoot()==null)
		{
			setRoot(element);
			return this.root;
		}
		else
		{
				switch (subTree.compareTo(element)) {// compare roOT OF SUB-TREE TO ELEMENT

				case 0:// they are equal do nothing
					return this.root;
				case 1:// current node is larger, move to left tree node
					if (subTree.root.getLeft() == null) {
						subTree.root.setLeft(new TreeNode<T>(element));
						return subTree.root;
					} else {// if not null continue through list
						subTree.root.setLeft(insert(element,new BinarySearchTree<T>(subTree.root.getLeft())));
						return subTree.root;
					}
				case -1:// current node is smaller, same as above but move to the right
					if (subTree.root.getRight() == null) {
						subTree.root.setRight(new TreeNode<T>(element));
						return subTree.root;
					} else {
						subTree.root.setRight(insert(element,new BinarySearchTree<T>(subTree.root.getRight())));
						return subTree.root;
						
					}

				}
				
			return this.root;
		}



	}

	//helper to remove element
	public void remove(T element)
	{
		this.root=removeElement(element,this);
	}
	
	
	// remove tree root and return the node of a new tree containing the remaining
	// values
	// @paramaters element, is the element to be removed, tree is the sub tree which
	// should contain the element as the root of this tree
	protected TreeNode<T> removeElement(T element, BinarySearchTree<T> subTree) {
		
		if (subTree.root.getElement() == element)// compare root value to element
		{

			if (subTree.root.getLeft() != null)// if the left sub tree is not null
			{
				BinarySearchTree<T> leftCopy = subTree.detachLeftSubtree();// copy left
																											// sub tree
																											// into new
																											// node
				if (subTree.root.getRight() != null)// if teh right ALSO contains vales copy that sub tree
				{
					BinarySearchTree<T> rightCopy = subTree.detachRightSubtree();

					// create iterator of left subtree
					TreeIterator<T> spc = new TreeIterator<T>(leftCopy.root);
					spc.setPreorder();

					while (spc.hasNext()) {
						rightCopy.insert(spc.next());// since the root of the right tree MUST be larger, insert the left
														// into the right sub tree
					}

					subTree.root = rightCopy.root;// pass the root of this tree as a return value, it now
																	// contains all the values of the sub tree except
																	// the root
					return subTree.root;
				} else
					return leftCopy.root;// if no right tree values, return the root of the left
																// sub tree, it contains all possible values

			} else {
				if (subTree.root.getRight() == null)// if left AND right are null, return null
					return null;
				else// else, return the root of the right subtree, it contains all possible values
				{

					BinarySearchTree<T> rightCopy = subTree.detachRightSubtree();

					subTree.root = rightCopy.root;
					
					return subTree.root;
				}

			}

		}
		else
		{
			
			switch (subTree.compareTo(element)) {// compare roOT OF SUB-TREE TO ELEMENT
			
			
			case 1:// current node is larger, move to left tree node
				if (subTree.root.getLeft() == null) {
					subTree.root.setLeft(new TreeNode<T>(element));
					return subTree.root;
				} else {// if not null continue through list
					subTree.root.setLeft(removeElement(element,new BinarySearchTree<T>(subTree.root.getLeft())));
					return subTree.root;
				}
			case -1:// current node is smaller, same as above but move to the right
				if (subTree.root.getRight() == null) {
					subTree.root.setRight(new TreeNode<T>(element));
					return subTree.root;
				} else {
					subTree.root.setRight(removeElement(element,new BinarySearchTree<T>(subTree.root.getRight())));
					return subTree.root;
					
				}

			}
			
			
			
		}

		return null;// any missed case will return null
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
	public BinarySearchTree<T> detachLeftSubtree() throws TreeException{
		if(isEmpty()) {
			throw new TreeException("cannot detatch left-subtree on empty tree");
		}
		else if(this.root.getLeft()==null) {
			throw new TreeException("cannot detach left-subtree, left subtree is null");
		}
		else {
			BinarySearchTree<T> leftTree= new BinarySearchTree<T>(this.root.getLeft());
			this.root.setLeft(null);
			return leftTree;
		}
	}
	
	//copy left sub tree
	
	public BinarySearchTree<T> copyLeftSubTree() throws TreeException{
		if(isEmpty()) {
			throw new TreeException("cannot copy left-subtree on empty tree");
		}
		else if(this.root.getLeft()==null) {
			throw new TreeException("cannot copy left-subtree, left subtree is null");
		}
		else {
			BinarySearchTree<T> leftTree= new BinarySearchTree<T>(this.root.getLeft());
			return leftTree;
		}
		
	}
	
	//copy right subtree
	public BinarySearchTree<T> copyRightSubtree() throws TreeException{
		if(isEmpty()) {
			throw new TreeException("cannot copy right-subtree on empty tree");
		}
		else if(this.root.getRight()==null) {
			throw new TreeException("cannot copy right-subtree, right subtree is null");
		}
		else {
			BinarySearchTree<T> rightTree= new BinarySearchTree<T>(this.root.getRight());
			return rightTree;
		}
	}
	
	
	//detach and return the right subtree
	public BinarySearchTree<T> detachRightSubtree() throws TreeException{
		if(isEmpty()) {
			throw new TreeException("cannot detatch right-subtree on empty tree");
		}
		else if(this.root.getRight()==null) {
			throw new TreeException("cannot detach right-subtree, right subtree is null");
		}
		else {
			BinarySearchTree<T> rightTree= new BinarySearchTree<T>(this.root.getRight());
			this.root.setLeft(null);
			return rightTree;
		}
	}
	
	
	


	@Override
	public int compareTo(T o) {
		
		return this.root.getElement().compareTo(o);
	}

}