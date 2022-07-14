import java.util.regex.Pattern;

public class Address
{
	private final Integer id;
	private String street;
	private String city;
	private String postalcode;

	public Address(Integer id ,String street, String city, String postalcode){
		this.setPostalcode(postalcode);
		this.setCity(city);
		this.setStreet(street);
		this.id = id;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPostalcode(String postalcode) {
		if(!(Pattern.matches("[0-9]{5}", postalcode))){
			System.err.println("Postalcode in wrong format! Postalcode must be exactly 5 digits!");
		}
		this.postalcode = postalcode;

	}

	public Integer getId() {
		return id;
	}

	public String toString() {
		return String.format("[%2d] %s, %s %s", this.id, this.street, this.postalcode, this.city);
	}
	
}

