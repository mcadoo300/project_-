package marc_project_4;

public class AdNode implements Comparable{
	
	
	private Contact element;
	
	private String key;
	
	private AdNode right;
	
	private AdNode left;
	
	public AdNode() {
		this.element=null;
		this.key=null;
		this.right=null;
		this.left=null;
	}
	
	public AdNode(Contact newContact) {
		this.element=newContact;
		this.key=newContact.getKey();
		this.right=null;
		this.left=null;
	}

	
	
	//return element of node
	public Contact getElement() {
		return this.element;
	}
	
	//set element of node to a specific element
	//@parameter element
	public void setElement(Contact element) {
		this.element=element;
	}
	
	//return the node the right is pointing to
	public AdNode getRight() {
		return this.right;
	}
	
	//return the nnode the left is pointing too
	public AdNode getLeft() {
		return this.left;
	}
	
	//set the right node to a new pointer
	public void setRight(AdNode newNode) {
		this.right=newNode;
	}
	
	//set the left node to a new pointer
	public void setLeft(AdNode newNode) {
		this.left=newNode;
	}
	
	
	
	
	
	
	@Override
	public int compareTo(Object o) {
		

		

		if(this.key!=null && o != null)
		{
			int[] thisKey = new int[this.key.length()];
			int[] key1 = new int[String.valueOf(o).length()];
			
			thisKey = insertValues(this.key,thisKey);
			
			key1= insertValues(String.valueOf(o),key1);
			
			int compValue=0;
			
			for(int i=0; i < this.key.length();i++)
			{
				
				compValue=compare(thisKey[i],key1[i]);
				
					if(compValue==0)//if the comparison is equal check for end of string
					{
						if(i==(this.key.length()-1))//if i is one less than the length of array then its the end of the key, longer key is "more" by default
						{
							if(i==(String.valueOf(o).length()-1))//if both strings are at the end and equal they are the same
								return 0;//return 0
							else
								return -1;//set comp value to -1 since "this" key is less than the comparison key
						}
						//if the characters are equal move to the next character
						
					}
					else//if not 0, then the characters are not equal and a comparison can be made
						return compValue;
			}
			
		}
		else
		{
				throw new TreeException("Cannot compare to null");
		}
		
		return-2;//catch all
	}
	
	public int[] insertValues(String key, int[] list)
	{
		for(int i=0; i<key.length();i++) {
			list[i] = (int) key.charAt(i);
		}
		
		return list;
	}
	
	public int compare(int int1, int int2) {
		if(int1 == int2)
			return 0;
		else if(int1 > int2)
			return 1;
		else return -1;
	}

}
