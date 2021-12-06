package marc_project_4;

public class BinarySearchTree<T extends Comparable<T>> {

	protected BinaryTree<T> baseTree;

	public BinarySearchTree() {
		this.baseTree = null;
	}
	

	

	// augmented constructor
	// @paramater pass a binary tree and turn into a binary search tree
	public BinarySearchTree(BinaryTree<T> newTree) {

		// create an iterator from tree and set to preorder
		TreeIterator<T> spc = new TreeIterator<T>(newTree);
		spc.setPreorder();

		this.baseTree = new BinaryTree<T>(new TreeNode<T>(spc.next()));// use inital value in list to set as tree root

		while (spc.hasNext()) {// while there are more values, add them in the order of the iterator

			T element = spc.next();// new element to insert

			insert(element);// insert element
		}

	}
	
	public TreeNode<T> getRoot() {
		if(this.baseTree==null)
			return null;
		return this.baseTree.root;
	}
	
	public T getRootElement() {
		return this.baseTree.root.getElement();
	}
	
	public void setNewBase(T element) {
		TreeNode<T> newRoot = new TreeNode<T>(element);
		BinaryTree<T> newBase = new BinaryTree<T>(element);
		this.baseTree=newBase;
		
	}
	
	public void makeEmpty() {
		this.baseTree.makeEmpty();
	}
	
	public boolean isEmpty() {
		return this.baseTree.isEmpty();
	}

	// boolean return type
	// determines if item is in the list
	public boolean search(T element) {

		TreeNode<T> tempNode = this.baseTree.root;// create a temporary node, start at base

		while (tempNode.getElement() != null) {// while the temp node is NOT NULL, continue to go throw the tree

			switch (tempNode.compareTo(element)) {// compare the current node to the element to search for

			case 0:// they are equal

				return true;
			case 1:// continue through the tree on the left since the current node is larger
				if (tempNode.getLeft() == null) {// next node is null, meaning there is no item that could be the
													// element
					return false;
				} else {
					tempNode = tempNode.getLeft();// if the left node is not null, move to that tree node
				}
				break;
			case -1: // the current node is smaller, move to the right
				if (tempNode.getRight() == null) { // if next right node is null, return false
					return false;
				} else {
					tempNode = tempNode.getRight(); // swing to the right tree node
				}

			}
		}

		return false;
	}

	// insert an item into the list
	// used in the constrcutor class to instantiate a BinarySearchTree, also a
	// public class to insert elements into the list
	// @paramaters, element to insert into the list
	public void insert(T element) {
		
		if(this.getRoot()==null)
		{
			setNewBase(element);
		}
		else
		{
			TreeNode<T> tempNode = this.baseTree.root;// temporary node, this current root

			boolean inserted = false;// a boolean value to determine when to stop moving through the tree

			while (!inserted) {

				switch (tempNode.compareTo(element)) {// compare roOT OF SUB-TREE TO ELEMENT

				case 0:// they are equal do nothing
					inserted = true;// inserted turned to true, exit the loop
					break;
				case 1:// current node is larger, move to left tree node
					if (tempNode.getLeft() == null) {
						tempNode.setLeft(new TreeNode<T>(element));
						inserted = true;// elemented inserted
						break;
					} else {// if not null continue through list
						tempNode = tempNode.getLeft();
					}
					break;
				case -1:// current node is smaller, same as above but move to the right
					if (tempNode.getRight() == null) {
						tempNode.setRight(new TreeNode<T>(element));
						inserted = true;
						break;
					} else {
						tempNode = tempNode.getRight();
					}

				}
			}
		}



	}

	

	// remove item from list
	// @paramaters element to remove

	public void remove(T element) {

		TreeNode<T> tempNode = this.baseTree.root;// create a temporary node, start at base
		boolean removed = false;

		if (tempNode.getElement() == element)// remove base of tree [special case]
		{

			this.baseTree.root = removeElement(element, this);
		} else {
			while (tempNode.getElement() != null && !removed) {// while the temp node is NOT NULL, continue to go
																// through the tree

				switch (tempNode.compareTo(element)) {// compare the current node to the element to search for

				case 0:// they are equal
					break;
				case 1:// continue through the tree on the left since the current node is larger
					if (tempNode.getLeft() == null)
						removed = true;
					else if (tempNode.getLeft().getElement() == element)// if left tree node contains element searching
																		// for
					{
						BinarySearchTree<T> tempTree = new BinarySearchTree<T>(new BinaryTree<T>(tempNode.getLeft()));

						tempNode.setLeft(removeElement(element, tempTree));
						removed = true;
						break;
					}
					tempNode = tempNode.getLeft();
					break;
				case -1:
					if (tempNode.getRight() == null)
						removed = true;
					else if (tempNode.getRight().getElement() == element)// if left tree node contains element searching
																			// for
					{
						BinarySearchTree<T> tempTree = new BinarySearchTree<T>(new BinaryTree<T>(tempNode.getRight()));

						tempNode.setRight(removeElement(element, tempTree));
						removed = true;
						break;
					}
					tempNode = tempNode.getRight();

				}
			}
		}

	}

	// remove tree root and return the node of a new tree containing the remaining
	// values
	// @paramaters element, is the element to be removed, tree is the sub tree which
	// should contain the element as the root of this tree
	private TreeNode<T> removeElement(T element, BinarySearchTree<T> tree) {

		TreeNode<T> tempNode = tree.baseTree.root;// create a temporary node, start at base of tree

		if (tempNode.getElement() == element)// compare root value to element
		{

			if (tempNode.getLeft() != null)// if the left sub tree is not null
			{
				BinarySearchTree<T> leftCopy = new BinarySearchTree<T>(tree.baseTree.detachLeftSubtree());// copy left
																											// sub tree
																											// into new
																											// node
				if (tempNode.getRight() != null)// if teh right ALSO contains vales copy that sub tree
				{
					BinarySearchTree<T> rightCopy = new BinarySearchTree<T>(tree.baseTree.detachRightSubtree());

					// create iterator of left subtree
					TreeIterator<T> spc = new TreeIterator<T>(leftCopy.baseTree);
					spc.setPreorder();

					while (spc.hasNext()) {
						rightCopy.insert(spc.next());// since the root of the right tree MUST be larger, insert the left
														// into the right sub tree
					}

					tree.baseTree.root = rightCopy.baseTree.root;// pass the root of this tree as a return value, it now
																	// contains all the values of the sub tree except
																	// the root
					return tree.baseTree.root;
				} else
					tree.baseTree.root = leftCopy.baseTree.root;// if no right tree values, return the root of the left
																// sub tree, it contains all possible values

			} else {
				if (tempNode.getRight() == null)// if left AND right are null, return null
					return null;
				else// else, return the root of the right subtree, it contains all possible values
				{

					BinarySearchTree<T> rightCopy = new BinarySearchTree<T>(tree.baseTree.detachRightSubtree());

					tree.baseTree.root = rightCopy.baseTree.root;
					
					return tree.baseTree.root;
				}

			}

		}

		return null;// any missed case will return null
	}

}