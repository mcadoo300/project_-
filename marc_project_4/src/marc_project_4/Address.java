package marc_project_4;

public class Address {
	
	//PDMS
	
	private String street;//street address
	
	private String city;//city name
	
	private String state;//state abrev
	
	private String zipcode;//zipcode
	
	
	//default contstructor
	public Address() {
		
		this.street=null;
		
		this.city=null;
		
		this.state=null;
		
		this.zipcode=null;
		
	}
	//augmented contstructor
	public Address(String street, String city, String state, String zipcode) {
		this.street=street;
		this.city=city;
		this.state=state;
		this.zipcode=zipcode;
	}
	
	
	
	
	
	
	

}
