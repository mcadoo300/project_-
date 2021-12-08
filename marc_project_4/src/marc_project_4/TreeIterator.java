package marc_project_4;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class TreeIterator<T extends Comparable<T>> implements java.util.Iterator<T> {

	@Override
	public boolean hasNext() {
			return !this.list.isEmpty();
	}

	@Override
	public T next() throws NoSuchElementException {
		return this.list.remove().getElement();
	}
	
	
	private TreeNode<T> tree;//node represents root
	
	private LinkedList <TreeNode<T>> list;//linked list of nodes
	
	
	//default constructor
	//@paramater treenode
	public TreeIterator(TreeNode<T> tree) {
		this.tree=tree;
		
		this.list=new LinkedList<TreeNode<T>>();
		
	}

	public void remove() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	
	//helper method for setting preorder
	private void preorder(TreeNode<T> treeNode) {
		if(treeNode != null) {
			this.list.add(treeNode);
			preorder(treeNode.getLeft());
			preorder(treeNode.getRight());
		}
	}
	//set this list to preorder
	public void setPreorder() {
		this.list.clear();
		this.preorder(this.tree);
	}
	
	//helper method to setinorder
	private void inorder(TreeNode<T> treeNode) {
		if(treeNode != null) {
			inorder(treeNode.getLeft());
			this.list.add(treeNode);
			inorder(treeNode.getRight());
		}
	}
	
	//set this into inorder
	public void setInorder() {
		this.list.clear();
			this.inorder(this.tree);
	}
	
	//helper
	//set this list into post order
	public void postOrder(TreeNode<T> treeNode) {
		if(treeNode != null) {
			postOrder(treeNode.getLeft());
			postOrder(treeNode.getRight());
			this.list.add(treeNode);
		}
	}
	
	//set this list into postorder
	public void setPostOrder() {
		this.list.clear();
		this.postOrder(this.tree);
	}

}
