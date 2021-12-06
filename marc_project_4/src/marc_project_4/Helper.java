package marc_project_4;

public class Helper {
	
	//testing space for basic tree
	public static void BasicTreeTest() {
	
//		TreeNode<Integer> treeNode1 = new TreeNode<Integer>(5);
//		TreeNode<Integer> treeNode2 = new TreeNode<Integer>(2);
//		TreeNode<Integer> treeNode3 = new TreeNode<Integer>(8);
//		TreeNode<Integer> treeNode4 = new TreeNode<Integer>(3);
//		TreeNode<Integer> treeNode5 = new TreeNode<Integer>(1);
//		TreeNode<Integer> treeNode6 = new TreeNode<Integer>(9);
//		TreeNode<Integer> treeNode7 = new TreeNode<Integer>(15);
//		TreeNode<Integer> treeNode8 = new TreeNode<Integer>(20);
		
		
		
		//testing space for treeNode
		/*
		 * 		System.out.println(treeNode1.getElement());
		
				treeNode1.setLeft(treeNode2);
		
				treeNode1.setRight(treeNode8);
			
				System.out.println(treeNode1.getLeft().getElement());
				System.out.println(treeNode1.getRight().getElement());
		 * 
		 */
		
		BinarySearchTree<Integer> testTree1 = new BinarySearchTree<Integer>();
		
		//test insert
		testTree1.insert(5);
		
		System.out.println(testTree1.getRootElement());
		testTree1.insert(2);

		
		testTree1.insert(8);
		testTree1.insert(4);
		testTree1.insert(7);
		testTree1.insert(9);
		
		testTree1.remove(5);
		
		
		 //tree assembled correctly
		/*				TREE::
		 * 					5
		 * 				  /   \
		 * 				 2     8
		 * 				/ \   / \
		 * 			       4  7  9
		 */
		
		//test remove
	//	testTree1.remove(8);
		
		 //tree removal correctly [elemeent in middle]
		/*				TREE::
		 * 					5
		 * 				  /   \
		 * 				 2     9
		 * 				/ \   / \
		 * 			       4  7  
		 */
		
//		testTree1.remove(7);
		 //tree removal correctly [leaf]
		/*				TREE::
		 * 					5
		 * 				  /   \
		 * 				 2     9
		 * 				/ \   / \
		 * 			       4  7  
		 */

	//	testTree1.remove(5);
		 //tree removal correctly [base]
		/*				TREE::
		 * 					5
		 * 				  /   \
		 * 				 2     9
		 * 				/ \   / \
		 * 			       4  7  
		 */
		
		
		
	//	System.out.println(testTree1.baseTree.getRootElement());
		
		//search testing space
	//	System.out.println(testTree1.search(4));
		
	//	System.out.println(testTree1.search(100));
		
		
		System.out.println(testTree1.getRootElement());
		System.out.println(testTree1.getRoot().getLeft().getElement());
	}

	/*
	public static void AddressTesting() {
		
		Address address1 = new Address("street","city","ST","zip");
		
		Contact contact1 = new Contact(address1, "Marc", "McAdoo", "123-456-7890");
		Contact contact2 = new Contact(address1, "Aarc", "McAdoo", "123-456-7890");
		Contact contact3 = new Contact(address1, "Carc", "McAdoo", "123-456-7890");
		Contact contact4 = new Contact(address1, "Varc", "McAdoo", "123-456-7890");
		Contact contact5 = new Contact(address1, "Jarc", "McAdoo", "123-456-7890");
		Contact contact6 = new Contact(address1, "Parc", "McAdoo", "123-456-7890");
		Contact contact7 = new Contact(address1, "Warc", "McAdoo", "123-456-7890");
		
		
		AddressBook book1 = new AddressBook();
		
		book1.insert(contact1);
		book1.insert(contact2);
		book1.insert(contact3);
		book1.insert(contact4);
		book1.insert(contact5);
		book1.insert(contact6);
		
		
		System.out.println(book1.search(contact1));
		
		book1.remove(contact1);
		
		System.out.println(book1.search(contact1));
		
	}
	*/
	
}
