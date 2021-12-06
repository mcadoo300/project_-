package marc_project_4;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class AddressIterator  implements java.util.Iterator{
	
	@Override
	public boolean hasNext() {
			return !this.list.isEmpty();
	}

	@Override
	public AdNode next() throws NoSuchElementException {
		return this.list.remove();
	}
	
	
	private AddressBook tree;
	
	private LinkedList <AdNode> list;
	
	
	public AddressIterator(AddressBook tree) {
		this.tree=tree;
		
		this.list=new LinkedList<AdNode>();
		
	}
	
	public void remove() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	
	private void preorder(AdNode AdNode) {
		if(AdNode != null) {
			this.list.add(AdNode);
			preorder(AdNode.getLeft());
			preorder(AdNode.getRight());
		}
	}
	
	public void setPreorder() {
		this.list.clear();
		this.preorder(this.tree.getRoot());
	}
	
	private void inorder(AdNode treeNode) {
		if(treeNode != null) {
			inorder(treeNode.getLeft());
			this.list.add(treeNode);
			inorder(treeNode.getLeft());
		}
	}
	
	public void setInorder() {
		this.list.clear();
			this.inorder(this.tree.getRoot());
	}
	
	public void postOrder(AdNode treeNode) {
		if(treeNode != null) {
			postOrder(treeNode.getLeft());
			postOrder(treeNode.getRight());
			this.list.add(treeNode);
		}
	}
	
	public void setPostOrder() {
		this.list.clear();
		this.postOrder(this.tree.getRoot());
	}
	

}
