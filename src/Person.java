import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Person implements PhoneInterface {

    static Map<String, Long> contactList = new HashMap<>();
    static Map<String, String> sentMessages = new HashMap<>();
    static Long phone_number;
    static String contact_name;
    static Scanner input = new Scanner(System.in);

    @Override
    public void composeMessage(String contact_name) {

        boolean finish = false;
        int response;

        while(!finish) {

            System.out.println("\nPress 1 to Compose New Message or Press 2 to quit");
            System.out.print(">>> ");
            response = input.nextInt();
            
            if (response == 1) {
                if (contactList.containsKey(contact_name)) {
                    System.out.println("\nType your message here........");
                    System.out.println(">>> ");

                    String message_content = input.nextLine();
                    input.nextLine();

                    sentMessages.put(contact_name, message_content);
                    System.out.println("\nMessage Sent");

                } else {
                    System.out.println("\nSorry, but " + contact_name + " not found in directory");
                }
            } 
            
            else if (response == 2) {
                finish = true;
                Main.displaySecondMenu();
            }

        }
    }

    @Override
    public void callContact(String contact_name) {
        phone_number = searchContact(contact_name);
        System.out.println("\nCalling " + contact_name + " on " + phone_number);
    }

    public long searchContact(String contact_name) {

        if(contactList.containsKey(contact_name)) {
            phone_number = contactList.get(contact_name);
        }
        return phone_number;
    }

    public void displayAllContact() {
        // Iterate through HashMap using Enhanced for loop

        for (Map.Entry<String, Long> pair : contactList.entrySet()) {
            System.out.format("\nContact Name: %s \t\t\t\t Phone Number: %d\n", pair.getKey(), pair.getValue());
        }
        Main.displayFirstMenu();
    }

    public void displayAllMessages() {
        for (Map.Entry<String, String> pair : sentMessages.entrySet()) {
            System.out.format("\nContact Name: %s \t\t\t\t Message Sent: %s\n", pair.getKey(), pair.getValue());
        }
    }

    public void addContact() {
        boolean finish = false;
        int response;

        while(!finish){

            System.out.println("\nPress 1 to Enter new Contact Name or Press 2 to quit");
            System.out.print(">>> ");
            response = input.nextInt();

            if (response == 1) {
                System.out.println("\nEnter contact phone number: ");
                System.out.print(">>> ");
                phone_number = input.nextLong();

                input.nextLine();

                System.out.println("\nEnter contact name: ");
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
        System.out.println("Contact Deleted\n");
        
        Main.displayFirstMenu();
    }
}
