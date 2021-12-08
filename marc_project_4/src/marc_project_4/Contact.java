package marc_project_4;

public class Contact implements Comparable<Contact>{
	
	//PDMs
	
	private Address address;//address object
	
	private String firstName;//string first name
	
	private String lastName;//last name
	
	private String fullName;//fullname
	
	private String phoneNum;//phone number
	
	private String areaCode;//area code
	
	private String key;//key
	
	//default constructor everything is emptry
	public Contact() {
		
		this.address=null;
		
		this.firstName=null;
		
		this.lastName=null;
		
		this.fullName=null;
		
		this.phoneNum=null;
		
		this.areaCode=null;
		
		this.key=null;
		
		
	}

	//create a copy of an existing contact
	public Contact(Contact copy) {
		
		this.address=copy.address;
		
		this.firstName=copy.firstName;
		
		this.lastName=copy.lastName;
		
		this.fullName=copy.firstName + ' ' + copy.lastName;
		
		this.phoneNum=copy.phoneNum;
		
		this.areaCode=copy.phoneNum.substring(0, 3);
		
		
		this.key= copy.firstName+copy.lastName;
		
	}
	
	public Contact(String inputLine) {
		
		String[] input = inputLine.split("\t");
		
		Address address = new Address(input[2],input[3],input[4],input[5]);
		
		Contact contact1 = new Contact(address, input[0],input[1],input[6]);
		
		this.address =address;
		
		this.firstName=contact1.firstName;
		
		this.lastName=contact1.lastName;
		
		this.fullName=contact1.fullName;
		
		this.phoneNum=contact1.phoneNum;
		
		this.areaCode=contact1.areaCode;
		
		this.key= contact1.key;
		
	}
	
	
	//create a contact through individual strings and an address
	public Contact(Address address, String firstName, String lastName, String phoneNum) {
		
		this.address=address;
		
		this.firstName=firstName;
		
		this.lastName=lastName;
		
		this.fullName=firstName + ' ' + lastName;
		
		this.phoneNum=phoneNum;
		
		this.areaCode=phoneNum.substring(0, 3);
		
		
		this.key= firstName+lastName;
		
	}
	
	//return this key
	public String getKey() {
		return this.key;
	}
	
	//return zipcode of this address
	public String getZipcode() {
		return this.address.getZipcode();
	}
	
	//return city of this address
	public String getCity() {
		return this.address.getCity();
	}

	//return area code of phone number
	public String getAreaCode() {
		return this.areaCode;
	}
	
	//return area code of phone number
	public String getName() {
		return this.fullName;
	}


	@Override
	public int compareTo(Contact o) {
		
		if(this.key!=null && o != null)//if either are null exit
		{
			char[] thisKey = new char[this.key.length()];//create an array of characters equal the length of this key
			char[] key1 = new char[String.valueOf(o.getKey()).length()];//create an array of characters equal the length of the o key
			
			thisKey = insertValues(this.key,thisKey);//populate with values of key
			
			key1= insertValues(String.valueOf(o.getKey()),key1);//populate with values of key
			
			int compValue=0;//comparison value
			
			for(int i=0; i < this.key.length();i++)
			{
				compValue=compare(thisKey[i],key1[i]);//compare the characters
				
					if(compValue==0)//if the comparison is equal check for end of string
					{
						if(i==(this.key.length()-1))//if i is one less than the length of array then its the end of the key, longer key is "more" by default
						{
							if(i==(String.valueOf(o.getKey()).length()-1))//if both strings are at the end and equal they are the same
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
	
	public char[] insertValues(String key, char[] list)
	{
		for(int i=0; i<key.length();i++) {
			list[i] = Character.toUpperCase(key.charAt(i));//all values compared as uppercase values
		}
		
		return list;
	}
	
	public int compare(char int1, char int2) {
		if(int1 == int2)
			return 0;
		else if(int1 > int2)
			return 1;
		else return -1;
	}
	
	

}
