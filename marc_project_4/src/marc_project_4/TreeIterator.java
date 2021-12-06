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
	
	
	private BaseBinaryTree<T> tree;
	
	private LinkedList <TreeNode<T>> list;
	
	
	
	public TreeIterator(BaseBinaryTree<T> tree) {
		this.tree=tree;
		
		this.list=new LinkedList<TreeNode<T>>();
		
	}

	public void remove() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	
	private void preorder(TreeNode<T> treeNode) {
		if(treeNode != null) {
			this.list.add(treeNode);
			preorder(treeNode.getLeft());
			preorder(treeNode.getRight());
		}
	}
	
	public void setPreorder() {
		this.list.clear();
		this.preorder(this.tree.root);
	}
	
	private void inorder(TreeNode<T> treeNode) {
		if(treeNode != null) {
			inorder(treeNode.getLeft());
			this.list.add(treeNode);
			inorder(treeNode.getLeft());
		}
	}
	
	public void setInorder() {
		this.list.clear();
			this.inorder(this.tree.root);
	}
	
	public void postOrder(TreeNode<T> treeNode) {
		if(treeNode != null) {
			postOrder(treeNode.getLeft());
			postOrder(treeNode.getRight());
			this.list.add(treeNode);
		}
	}
	
	public void setPostOrder() {
		this.list.clear();
		this.postOrder(this.tree.root);
	}

}
