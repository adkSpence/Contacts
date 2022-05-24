import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static int response;

    public static void main(String[] args) {
        String username;
        System.out.println("Welcome! Enter your name");
        System.out.print(">>> ");
        username = input.nextLine();

        displayWelcomeMessage(username);
    }
    static void displayWelcomeMessage(String username) {

            System.out.println("Welcome " + username + ". Choose an option by inputting the menu number");
            System.out.println("""
                    1. Manage contacts
                    2. Messages
                    3. Quit
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
                System.out.println("Thank you for using our system " + username);
            }
    }

    static void displayFirstMenu() {

        Person contact = new Person();
        String contact_name;

        System.out.println("""
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
            System.out.println("Enter name of your contact you want to Search:");
            System.out.print(">>> ");
            input.nextLine();
            contact_name = input.nextLine();

            contact.searchContact(contact_name);
        }
        else if (response == 4) {
            System.out.println("Enter name of your contact you want to Delete:");
            System.out.print(">>> ");

            contact_name = input.nextLine();

            contact.deleteContact(contact_name);
        }
    }

    private static void displaySecondMenu() {
        System.out.println("""
                1. See all messages
                2. Compose new message
                3. Go back to previous menu
                """);
    }
}