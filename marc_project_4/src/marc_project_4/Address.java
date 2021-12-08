package marc_project_4;

public class Address {
	
	//PDMS
	
	private String street;//street address
	
	private String city;//city name
	
	private String state;//state abrev
	
	private String zipcode;//zipcode
	
	
	//default contstructor
	//is empty
	public Address() {
		
		this.street=null;
		
		this.city=null;
		
		this.state=null;
		
		this.zipcode=null;
		
	}
	//augmented contstructor
	//pass strings into each individual component
	public Address(String street, String city, String state, String zipcode) {
		this.street=street;
		this.city=city;
		this.state=state;
		this.zipcode=zipcode;
	}
	//return this zipcode
	public String getZipcode() {
		return this.zipcode;
	}
	//return this city
	public String getCity() {
		return this.city;
	}
	
	//set this street to new string
	public void setStreet(String newStreet){
		this.street=newStreet;
		
	}
	
	//set this city to new city
	public void setCity(String newCity){
		this.city=newCity;
		
	}
	
	//set this state to new state
	public void setState(String newState){
		this.state=newState;
		
	}
	
	//set this zipcode to new zipcode
	public void setZipcode(String newZipcode){
		this.zipcode=newZipcode;
		
	}
	
	
	
	
	
	
	

}
