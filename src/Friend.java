import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Friend{
	
	private Integer id;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private final Set<Address> addresses;

	public Friend(Integer id ,String firstName, String lastName, String dateOfBirth){
		this.setId(id);
		this.setDateOfBirth(dateOfBirth);
		this.setLastName(lastName);
		this.setFirstName(firstName);
		this.addresses = new HashSet<>();
	}

	private Integer getAddressId(){
		return this.id * 1000 + this.addresses.size();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName(){
		return this.firstName;
	}
	
	public void setFirstName(String fName) {
		this.firstName = fName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lName) {
		this.lastName = lName;
	}
	
	public String getDateOfBirth() {
		return this.dateOfBirth;
	}
	
	public void setDateOfBirth(String dateOfB) {
		if(!Pattern.matches("[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])", dateOfB)){
			System.err.println("Date format must be yyyy-mm-dd and a valid date!");
		}
		this.dateOfBirth = dateOfB;
	}

	public void addAddress(String street, String city, String postalcode) {
		Address newAddress = new Address(getAddressId() ,street, city, postalcode);
		addresses.add(newAddress);
	}
	
	public boolean deleteAddress(int AddressId) {
		return addresses.removeIf(address -> address.getId() == AddressId);
	}
	
	public void getAddresses() {
		System.out.printf("\nAddresses saved for %s:\n", this.toString());
		for (Address address :
				addresses) {
			System.out.println(address.toString());
		}
	}

	@Override
	public String toString() {
		return String.format("%s %s (%s)", this.firstName, this.lastName, this.dateOfBirth);
	}
}

