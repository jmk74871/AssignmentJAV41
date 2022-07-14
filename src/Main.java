import java.util.Optional;

public class Main {

    public static void main (String[] args){

        Register sampleRegister = new Register();

        // Abfrage im leeren register:
        sampleRegister.getFriendCount();

        // Hinzufügen von Freunden:
        sampleRegister.addFriend("Max", "Muster", "1990-12-24");
        sampleRegister.addFriend("Melinda", "Schneider", "1994-02-16");

       sampleRegister.getFriendCount();

        // Suchen nach Name:
        sampleRegister.searchFriendsByName("Muster");

        // Ändern des Namen und Überprüfung des Ergebnisses (beide werden gefunden):
        sampleRegister.editFriend(2, "Melinda", "Muster", "1994-02-16");
        sampleRegister.searchFriendsByName("Muster");

        // Fehlerhafter versuch Daten zu ändern:
        sampleRegister.editFriend(10, "Melinda", "Muster", "1994-02-16");

        // Suche über ID:
        Optional<Friend> friendOptional = sampleRegister.searchFriendById(2);
        System.out.print("\n" + friendOptional + "\n");
        if(friendOptional.isPresent()){
            System.out.print("Found the coresponding friend.\n");
            System.out.println(friendOptional.get());
        }


        // Löschen von Freunden:
        sampleRegister.deleteFried(2);
        sampleRegister.searchFriendsByName("Melinda");

        //Adresse anlegen:
        sampleRegister.addAddressToFriend(1, "Hauptstraße 3", "Reutlingen", "72770");
        sampleRegister.addAddressToFriend(1, "Schulstraße 12", "Wangerland", "26434");
        sampleRegister.getAddressesForFriend(1);

        // Adresse löschen:
        sampleRegister.deletAddressFromFriend(1,1001);
        sampleRegister.getAddressesForFriend(1);

        // Erneutes Hinzufügen von Freunden und Adressen:
        sampleRegister.addFriend("Melinda", "Schneider", "1994-02-16");
        sampleRegister.addFriend("Otto", "Müller", "1992-08-19");
        sampleRegister.addAddressToFriend(2, "Schulstraße 12", "Wangerland", "26434");
        sampleRegister.addAddressToFriend(3, "Schulstraße 12", "Wangerland", "26434");

        // Ausgeben der Adressliste:
        sampleRegister.printAddressList();
    }
}

