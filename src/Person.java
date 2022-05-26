import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Person implements PhoneInterface {

    static Map<String, Long> contactList = new HashMap<>();
    static Long phone_number;
    static String contact_name;
    static Scanner input = new Scanner(System.in);

    @Override
    public void composeMessage(String message) {

    }

    @Override
    public void callContact(String contact_name) {
        long number = searchContact(contact_name);
        System.out.println("Calling " + contact_name + " on " + number);
    }

    public long searchContact(String contact_name) {
        long phone_number = 0;

        if(contactList.containsKey(contact_name)) {
            phone_number = contactList.get(contact_name);
        }
        return phone_number;
    }

    public void displayAllContact() {
        // Iterate through HashMap using Enhanced for loop

        for (Map.Entry<String, Long> pair : contactList.entrySet()) {
            System.out.format("Contact Name: %s =========== Phone Number: %d\n", pair.getKey(), pair.getValue());
        }
    }

    public void addContact() {
        boolean finish = false;
        int response;

        while(!finish){

            System.out.println("Press 1 to Enter new Contact Name or Press 2 to quit");
            System.out.print(">>> ");
            response = input.nextInt();

            if (response == 1) {
                System.out.println("Enter contact phone number: ");
                System.out.print(">>> ");
                phone_number = input.nextLong();

                input.nextLine();

                System.out.println("Enter contact name: ");
                System.out.print(">>> ");
                contact_name = input.nextLine();
            }
            else if (response == 2) {
                finish = true;
                Main.displayFirstMenu();
            }

            if(!contactList.containsKey(contact_name)){
                contactList.put(contact_name, phone_number);
            }
        }
    }

    public void deleteContact(String contact_name) {
        contactList.remove(contact_name);
    }
}
