import java.util.HashSet;
import java.util.Optional;
import java.util.Set;




public class Register{

	private final Set<Friend> friends;

	public Register(){
		this.friends = new HashSet<>();
	}

	private Integer getIdForFriend(){
		return this.friends.size() +1;
	}
	
	public void addFriend(String firstName, String lastName, String dateOfBirth) {
		Friend newFriend = new Friend(getIdForFriend(), firstName, lastName, dateOfBirth);
		friends.add(newFriend);
		System.out.printf("%nYou added %s to your register.%n", newFriend);
	}

	public void deleteFried(int friendId) {
		this.friends.removeIf(friend -> friend.getId() == friendId);
	}

	public void editFriend(int id, String newFirstName, String newLastName, String newDateOfBirth) {
		Optional<Friend> friendOptional = this.searchFriendById(id);
		if (friendOptional.isPresent()){
			Friend friendToEdit = friendOptional.get();
			friendToEdit.setFirstName(newFirstName);
			friendToEdit.setLastName(newLastName);
			friendToEdit.setDateOfBirth(newDateOfBirth);

			System.out.printf("%nEntry with id %d edited to %s%n", friendToEdit.getId(), friendToEdit);
		}
		if(friendOptional.isEmpty()){System.out.printf("%nNo entry found for id %d %n", id);}
	}

	public void searchFriendsByName(String name) {
		for (Friend friend :
				friends) {
			if(friend.getFirstName().equals(name) || friend.getLastName().equals(name)){
				System.out.printf("%n[%d] %s %n", friend.getId(), friend);
			}
		}
	}

	public Optional<Friend> searchFriendById(int id) {
		for (Friend friend : friends) {
			if(friend.getId() == id){
				return Optional.of(friend);
			}
		}
		return Optional.empty();
	}

	public void getFriendCount(){
		System.out.printf("%nYou have %d friends in your register.%n", this.friends.size());
	}

	public void addAddressToFriend(Integer friendId, String street, String city, String postalcode){
		Optional<Friend> friendOptional = this.searchFriendById(friendId);
		if(friendOptional.isEmpty()){
			System.out.printf("%nNo entry fond for friend with id %d%n", friendId);
		}
		if(friendOptional.isPresent()){
			Friend friend = friendOptional.get();
			friend.addAddress(street, city, postalcode);
			System.out.printf("%nAddress in %s added to %s %n", street, friend);
		}
	}

	public void deletAddressFromFriend(Integer friendId,Integer addressId){
		//TODO implement me
		Optional<Friend> friendOptional = this.searchFriendById(friendId);
		if(friendOptional.isEmpty()){
			System.out.printf("%nNo entry fond for friend with id %d%n", friendId);
		}
		if(friendOptional.isPresent()){
			Friend friend = friendOptional.get();

			if (friend.deleteAddress(addressId)) {
				System.out.printf("%nAddress with id %d deleted from to %s%n", addressId, friend);
			}else{
				System.out.printf("%nNo entry fond for address with id %d%n", addressId);
			}
		}
	}

	public void getAddressesForFriend(Integer friendId){
		Optional<Friend> friendOptional = this.searchFriendById(friendId);
		if(friendOptional.isEmpty()){
			System.out.printf("%nNo entry fond for friend with id %d %n", friendId);
		}
		if(friendOptional.isPresent()){
			friendOptional.get().getAddresses();
		}
	}


}

