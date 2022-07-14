public class Main {

    public static void main (String[] args){

        Register sampleRegister = new Register();

        sampleRegister.getFriendCount();

        sampleRegister.addFriend("Jonas", "Kuhlo", "1990-12-24");
        sampleRegister.addFriend("Yulia", "Kuhlo", "1994-02-16");

        sampleRegister.getFriendCount();

        sampleRegister.searchFriendsByName("Jonas");
        sampleRegister.searchFriendsByName("Kuhlo");

        System.out.println(sampleRegister.searchFriendById(2));


        sampleRegister.editFriend(2, "Yulia", "Mkhayan", "1994-02-16");
        sampleRegister.editFriend(10, "Yulia", "Mkhayan", "1994-02-16");

        sampleRegister.addAddressToFriend(1, "Ringelbachstr. 233", "Reutlingen", "72762");
        sampleRegister.getAddressesForFriend(1);

    }
}

