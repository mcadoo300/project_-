package marc_project_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class AddressBook {

	// PDM

	private BinarySearchTree<Contact> tree;

	public AddressBook() {
		this.tree = null;
	}

	public AddressBook(Contact newTree) {

		this.tree = new BinarySearchTree<Contact>(newTree);
	}
	//returns if empty or not
	public boolean isEmpty() {
		return this.tree==null;
	}
	
	//makes list empty
	public void makeEmpty() {
		this.tree=null;
	}
	
	
	//for testing, print out list alphabetically
	public void PrintList() {
		
		// create iterator of left subtree
				TreeIterator<Contact> spc = new TreeIterator<Contact>(this.tree.root);
				spc.setInorder();
				while (spc.hasNext()) {
					System.out.println(spc.next().getName());
				}
		
	}
	
	
	public void FillAddressBook(String fileName) throws FileNotFoundException
	{
		File text = new File(fileName);
		
		Scanner sc = new Scanner(text);
		
		String inputLine = "";
		
		while(sc.hasNextLine())
		{
			inputLine= sc.nextLine();
			
			
					String[] input = inputLine.split("\t");
					
					Address address = new Address(input[2],input[3],input[4],input[5]);
					
					Contact contact1 = new Contact(address, input[0],input[1],input[6]);
					
					this.insert(contact1);
			

		}
		
		sc.close();//end file assocation
		

	}

	//search a specific zipCode
	//paramater String zipCode
	public LinkedList<Contact> zipcodeSearch(String zipcode) {

		// create iterator of left subtree
		TreeIterator<Contact> spc = new TreeIterator<Contact>(this.tree.root);
		spc.setInorder();

		LinkedList<Contact> returnList = new LinkedList<Contact>();

		Contact temp = new Contact();

		while (spc.hasNext()) {
			temp = spc.next();
			if (temp.getZipcode().compareTo(zipcode) == 0) {
				returnList.add(temp);
			}
		}

		return returnList;

	}

	//search a specific city
	//paramater String city
	public LinkedList<Contact> citySearch(String city) {

		// create iterator of left subtree
		TreeIterator<Contact> spc = new TreeIterator<Contact>(this.tree.root);
		spc.setInorder();

		LinkedList<Contact> returnList = new LinkedList<Contact>();

		Contact temp = new Contact();

		while (spc.hasNext()) {
			temp = spc.next();
			if (temp.getCity().compareTo(city) == 0) {
				returnList.add(temp);
			}
		}

		return returnList;

	}
	//search a specific phone are code
	//paramater String areacode
	public LinkedList<Contact> phoneSearch(String areaCode) {

		// create iterator of left subtree
		TreeIterator<Contact> spc = new TreeIterator<Contact>(this.tree.root);
		spc.setInorder();

		LinkedList<Contact> returnList = new LinkedList<Contact>();

		Contact temp = new Contact();

		while (spc.hasNext()) {
			temp = spc.next();
			if (Integer.parseInt(temp.getAreaCode())  == Integer.parseInt(areaCode)) {
				returnList.add(temp);
			}
		}

		return returnList;

	}

	//insert contact element
	//helper
	public void insert(Contact element) {

		if (this.tree == null)
			this.tree = new BinarySearchTree<Contact>(element);
		else if (this.search(element))
			;// do nothing
		else
			this.tree.root = (insert(element, this.tree));
	}

	// insert an item into the list
	// used in the constrcutor class to instantiate a BinarySearchTree, also a
	// public class to insert elements into the list
	// @paramaters, element to insert into the list
	protected TreeNode<Contact> insert(Contact element, BinarySearchTree<Contact> subTree) {

		switch (subTree.compareTo(element)) {// compare roOT OF SUB-TREE TO ELEMENT

		case 0:// they are equal do nothing
			return this.tree.root;
		case 1:// current node is larger, move to left tree node
			if (subTree.root.getLeft() == null) {
				subTree.root.setLeft(new TreeNode<Contact>(element));
				return subTree.root;
			} else {// if not null continue through list
				subTree.root.setLeft(insert(element, new BinarySearchTree<Contact>(subTree.root.getLeft())));
				return subTree.root;
			}
		case -1:// current node is smaller, same as above but move to the right
			if (subTree.root.getRight() == null) {
				subTree.root.setRight(new TreeNode<Contact>(element));
				return subTree.root;
			} else {
				subTree.root.setRight(insert(element, new BinarySearchTree<Contact>(subTree.root.getRight())));
				return subTree.root;

			}

		}

		return this.tree.root;

	}

	//hlper for search
	public boolean search(Contact element) {
		return search(element, this.tree);
	}

	// boolean return type
	// determines if item is in the list
	protected boolean search(Contact element, BinarySearchTree<Contact> subTree) {

		switch (subTree.compareTo(element)) {// compare the current node to the element to search for

		case 0:// they are equal

			return true;
		case 1:// continue through the tree on the left since the current node is larger
			if (subTree.root.getLeft() == null) {// next node is null, meaning there is no item that could be the
													// element
				return false;
			} else {
				return search(element, new BinarySearchTree<Contact>(subTree.root.getLeft()));// if the left node is not
																								// null, move to that
																								// tree node
			}
		case -1: // the current node is smaller,move to the right
			if (subTree.root.getRight() == null) { // if next right node is null, return false
				return false;
			} else {
				return search(element, new BinarySearchTree<Contact>(subTree.root.getRight())); // swing to the right
																								// tree node
			}

		}

		return false;
	}

	//hlper to remove
	public void remove(Contact element) {
		this.tree.root = removeElement(element, this.tree);
	}

	// remove tree root and return the node of a new tree containing the remaining
	// values
	// @paramaters element, is the element to be removed, tree is the sub tree which
	// should contain the element as the root of this tree
	protected TreeNode<Contact> removeElement(Contact element, BinarySearchTree<Contact> subTree) {

		if (subTree.root.getElement() == element)// compare root value to element
		{

			if (subTree.root.getLeft() != null)// if the left sub tree is not null
			{
				BinarySearchTree<Contact> leftCopy = subTree.detachLeftSubtree();// copy left
																					// sub tree
																					// into new
																					// node
				if (subTree.root.getRight() != null)// if teh right ALSO contains vales copy that sub tree
				{
					BinarySearchTree<Contact> rightCopy = subTree.detachRightSubtree();

					// create iterator of left subtree
					TreeIterator<Contact> spc = new TreeIterator<Contact>(leftCopy.root);
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

					BinarySearchTree<Contact> rightCopy = subTree.detachRightSubtree();

					subTree.root = rightCopy.root;

					return subTree.root;
				}

			}

		} else {

			switch (subTree.compareTo(element)) {// compare roOT OF SUB-TREE TO ELEMENT

			case 1:// current node is larger, move to left tree node
				if (subTree.root.getLeft() == null) {
					subTree.root.setLeft(new TreeNode<Contact>(element));
					return subTree.root;
				} else {// if not null continue through list
					subTree.root.setLeft(removeElement(element, new BinarySearchTree<Contact>(subTree.root.getLeft())));
					return subTree.root;
				}
			case -1:// current node is smaller, same as above but move to the right
				if (subTree.root.getRight() == null) {
					subTree.root.setRight(new TreeNode<Contact>(element));
					return subTree.root;
				} else {
					subTree.root
							.setRight(removeElement(element, new BinarySearchTree<Contact>(subTree.root.getRight())));
					return subTree.root;

				}

			}

		}

		return null;// any missed case will return null
	}

}
