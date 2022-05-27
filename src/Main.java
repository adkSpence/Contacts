import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static int response;
    static String username;
    static String contact_name;

    public static void main(String[] args) {
        System.out.println("Welcome! Enter your name");
        System.out.print(">>> ");
        username = input.nextLine();

        displayWelcomeMessage(username);
    }
    static void displayWelcomeMessage(String username) {

            System.out.println("\nWelcome " + username + ". Choose an option by inputting the menu number\n");
            System.out.println("""
                    1. Manage contacts
                    2. Messages
                    3. Make a phone call
                    4. Quit
                    """);
            System.out.print(">>> ");
            response = input.nextInt();

            if (response == 1) {
                displayFirstMenu();
            }
            else if (response == 2) {
                displaySecondMenu();
            }
            else if (response == 3) {
                String contact_name;

                PhoneInterface callInterface = new Person();

                System.out.println("\nEnter name of your contact you want to Call:");
                System.out.print(">>> ");
                input.nextLine();
                contact_name = input.nextLine();

                callInterface.callContact(contact_name);
                displayWelcomeMessage(username);
            }
            else if (response == 4) {
                System.out.println("\nThank you for using our system " + username);
            }
    }

    static void displayFirstMenu() {

        Person contact = new Person();

        System.out.println("""
                \n
                1. Show all contacts
                2. Add a new contact
                3. Search for a contact
                4. Delete a contact
                5. Go back to previous menu
                """);
        System.out.print(">>> ");
        response = input.nextInt();

        if (response == 1) {
            contact.displayAllContact();
        }
        else if (response == 2) {
            contact.addContact();
        }
        else if (response == 3) {
            System.out.println("\nEnter name of your contact you want to Search:");
            System.out.print(">>> ");
            input.nextLine();
            contact_name = input.nextLine();

            System.out.println("\nPhone number for " + contact_name + " is " + contact.searchContact(contact_name));
            displayFirstMenu();
        }
        else if (response == 4) {
            System.out.println("Enter the name of contact you want to Delete ");
            String name = input.nextLine();

            input.nextLine();

            System.out.println(name);

            //contact.deleteContact(name);
        }
        else if (response == 5) {
            displayWelcomeMessage(username);
        }
    }

    public static void displaySecondMenu() {

        Person messages = new Person();

        System.out.println("""
                \n
                1. See all messages
                2. Compose new message
                3. Go back to previous menu
                """);
        System.out.print(">>> ");
        response = input.nextInt();

        if (response == 1) {
            messages.displayAllMessages();
        }
        else if (response == 2) {
            System.out.println("\nSelect Contact to whom you want to send a message");
            System.out.print(">>> ");

            input.nextLine();

            String name = input.nextLine();

            messages.composeMessage(name);
        }
    }
}