package marc_project_4;

public class Contact {
	
	//PDMs
	
	private Address address;//address object
	
	private String firstName;//string first name
	
	private String lastName;//last name
	
	private String fullName;//fullname
	
	private String phoneNum;//phone number
	
	private String areaCode;//area code
	
	private String key;//key
	
	public Contact() {
		
		this.address=null;
		
		this.firstName=null;
		
		this.lastName=null;
		
		this.fullName=null;
		
		this.phoneNum=null;
		
		this.areaCode=null;
		
		this.key=null;
		
		
	}
	
	
	public Contact(Address address, String firstName, String lastName, String phoneNum) {
		
		this.address=address;
		
		this.firstName=firstName;
		
		this.lastName=lastName;
		
		this.fullName=firstName + ' ' + lastName;
		
		this.phoneNum=phoneNum;
		
		this.areaCode=phoneNum.substring(0, 3);
		
		
		this.key= firstName+lastName;
		
	}
	
	public String getKey() {
		return this.key;
	}
	
	

}
