package marc_project_4;



public class AddressBook {
	

	//PDM
	
	private AdNode root;
	
	public AddressBook() {
		this.root=null;
	}
	
	public AddressBook(Contact newContact) {
		AdNode newRoot = new AdNode(newContact);
		
		this.root=newRoot;
		
	}
	
	public AddressBook(AdNode newNode) {
		AdNode newRoot = newNode;
		
		this.root=newRoot;
		
	}
	
	public AddressBook(AddressBook copyBook)
	{
		this.root=copyBook.root;
	}
	
	public AdNode getRoot() {
		return this.root;
	}
	
	public void setRoot(AdNode newRoot) {
		this.root = newRoot;
	}
	
	
	//return weather or not this root is null
		public boolean isEmpty() {
			return this.root == null;
		}
		
		//set root to null
		public void makeEmpty() {
			this.root=new AdNode();
		}
		
		//retuturn node ELEMENT of root
		public AdNode getRootElement() throws TreeException{
			if(this.root==null) {
				throw new TreeException("Tree is empty");
			}
			else
			{
				return this.root;
			}
		}
		
		
		
		
		
		//attach new node to the left
		public void attachLeft(Contact newItem) throws TreeException{
			if(!isEmpty() && this.root.getLeft()==null){
				this.root.setLeft(new AdNode(newItem));//the element has been added to the left
			}
			else if(isEmpty()) {
				throw new TreeException("Empty tree, cannot attach to left");//if empty throw exception
			}
			else if(this.root.getLeft()!=null) {//if alright a child throw exception
				throw new TreeException("there is already a left child");
			}
		}
		
		
		//attach new node to the right
		public void attachRight(Contact newItem) throws TreeException{
			if(!isEmpty() && this.root.getRight()==null){
				this.root.setRight(new AdNode(newItem));//new node added to the right
			}
			else if(isEmpty()) {
				throw new TreeException("Empty tree, cannot attach to right");//if root is null throw exception
			}
			else if(this.root.getRight()!=null) {
				throw new TreeException("there is already a right child");//if already a right node throw excpetion
			}
		}
		
		
		//attach sub tree to the left
		public void attachLeftSubtree(AddressBook leftTree) throws TreeException{
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
		public void attachRightSubtree(AddressBook rightTree) throws TreeException{
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
		public AddressBook detachLeftSubtree() throws TreeException{
			if(isEmpty()) {
				throw new TreeException("cannot detatch left-subtree on empty tree");
			}
			else if(this.root.getLeft()==null) {
				throw new TreeException("cannot detach left-subtree, left subtree is null");
			}
			else {
				AddressBook leftTree= new AddressBook(this.root.getLeft());
				this.root.setLeft(null);
				return leftTree;
			}
		}
		
		//copy left sub tree
		
		public AddressBook copyLeftSubTree() throws TreeException{
			if(isEmpty()) {
				throw new TreeException("cannot copy left-subtree on empty tree");
			}
			else if(this.root.getLeft()==null) {
				throw new TreeException("cannot copy left-subtree, left subtree is null");
			}
			else {
				AddressBook leftTree=new AddressBook(this.root.getLeft());
				return leftTree;
			}
			
		}
		
		//copy right subtree
		public AddressBook copyRightSubtree() throws TreeException{
			if(isEmpty()) {
				throw new TreeException("cannot copy right-subtree on empty tree");
			}
			else if(this.root.getRight()==null) {
				throw new TreeException("cannot copy right-subtree, right subtree is null");
			}
			else {
				AddressBook rightTree= new AddressBook(this.root.getRight());
				return rightTree;
			}
		}
		
		
		//detach and return the right subtree
		public AddressBook detachRightSubtree() throws TreeException{
			if(isEmpty()) {
				throw new TreeException("cannot detatch right-subtree on empty tree");
			}
			else if(this.root.getRight()==null) {
				throw new TreeException("cannot detach right-subtree, right subtree is null");
			}
			else {
				AddressBook rightTree= new AddressBook(this.root.getRight());
				this.root.setLeft(null);
				return rightTree;
			}
		}
		
		//////
		
		// insert an item into the list
		// used in the constrcutor class to instantiate a BinarySearchTree, also a
		// public class to insert elements into the list
		// @paramaters, element to insert into the list
		public void insert(Contact element) {
			
			if(this.getRoot()==null)
			{
				setRoot(new AdNode(element));
			}
			else
			{
				AdNode tempNode = this.root;// temporary node, this current root

				int comp = 0;
				boolean inserted = false;// a boolean value to determine when to stop moving through the tree

				while (!inserted) {

					switch (tempNode.compareTo(element.getKey())) {// compare roOT OF SUB-TREE TO ELEMENT

					case 0:// they are equal do nothing
						inserted = true;// inserted turned to true, exit the loop
						break;
					case 1:// current node is larger, move to left tree node
						if (tempNode.getLeft() == null) {
							tempNode.setLeft(new AdNode(element));
							inserted = true;// elemented inserted
							break;
						} else {// if not null continue through list
							tempNode = tempNode.getLeft();
						}
						break;
					case -1:// current node is smaller, same as above but move to the right
						if (tempNode.getRight() == null) {
							tempNode.setRight(new AdNode(element));
							inserted = true;
							break;
						} else {
							tempNode = tempNode.getRight();
						}

					}
				}
			}



		}
		
		
		// boolean return type
		// determines if item is in the list
		public boolean search(Contact element) {

			AdNode tempNode = this.root;// create a temporary node, start at base

			while (tempNode.getElement() != null) {// while the temp node is NOT NULL, continue to go throw the tree

				switch (tempNode.compareTo(element.getKey())) {// compare the current node to the element to search for

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
		
		
		// remove item from list
		// @paramaters element to remove
/*
		public void remove(Contact element) {

			AdNode tempNode = this.root;// create a temporary node, start at base
			boolean removed = false;

			if (tempNode.getElement() == element)// remove base of tree [special case]
			{

				this.root = removeElement(element, this);
			} else {
				while (tempNode.getElement() != null && !removed) {// while the temp node is NOT NULL, continue to go
																	// through the tree

					switch (tempNode.compareTo(element.getKey())) {// compare the current node to the element to search for

					case 0:// they are equal
						break;
					case 1:// continue through the tree on the left since the current node is larger
						if (tempNode.getLeft() == null)
							removed = true;
						else if (tempNode.getLeft().getElement() == element)// if left tree node contains element searching
																			// for
						{
							AddressBook tempTree = new AddressBook(tempNode.getLeft());

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
							AddressBook tempTree = new AddressBook(tempNode.getRight());

							tempNode.setRight(removeElement(element, tempTree));
							removed = true;
							break;
						}
						tempNode = tempNode.getRight();

					}
				}
			}

		}
		
		
	*////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		
		
//		// remove tree root and return the node of a new tree containing the remaining
//		// values
//		// @paramaters element, is the element to be removed, tree is the sub tree which
//		// should contain the element as the root of this tree
//		private AdNode removeElement(Contact element, AddressBook tree) {
//
//			AdNode tempNode = tree.root;// create a temporary node, start at base of tree
//
//			if (tempNode.getElement().getKey() == element.getKey())// compare root value to element
//			{
//
//				if (tempNode.getLeft() != null)// if the left sub tree is not null
//				{
//					AddressBook leftCopy = new AddressBook(tree.detachLeftSubtree());// copy left
//																												// sub tree
//																												// into new
//																												// node
//					if (tempNode.getRight() != null)// if teh right ALSO contains vales copy that sub tree
//					{
//						AddressBook rightCopy = new AddressBook(tree.detachRightSubtree());
//
////						// create iterator of left subtree
////						AddressIterator spc = new AddressIterator(leftCopy);
////						spc.setPreorder();
//
//						while (spc.hasNext()) {
//							rightCopy.insert(spc.next().getElement());// since the root of the right tree MUST be larger, insert the left
//															// into the right sub tree
//						}
//
//						tree.root = rightCopy.root;// pass the root of this tree as a return value, it now
//																		// contains all the values of the sub tree except
//																		// the root
//						return tree.root;
//					} else
//						tree.root = leftCopy.root;// if no right tree values, return the root of the left
//																	// sub tree, it contains all possible values
//
//				} else {
//					if (tempNode.getRight() == null)// if left AND right are null, return null
//						return null;
//					else// else, return the root of the right subtree, it contains all possible values
//					{
//
//						AddressBook rightCopy = new AddressBook(tree.detachRightSubtree());
//
//						tree.root = rightCopy.root;
//						
//						return tree.root;
//					}
//
//				}
//
//			}
//
//			return null;// any missed case will return null
//		}
//		

}
