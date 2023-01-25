import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class AddressBook {
    static HashMap<String, AddressBook> addressBooks = new HashMap<>();
    ArrayList<Contact> contact_Details = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public void addContacts() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number of contacts you want to save");
            int numberOfContacts = sc.nextInt();
            for (int i = 0; i < numberOfContacts; i++) {
                System.out.println("Enter the details of contact number " + (i + 1));
                System.out.println("Enter first name");
                String firstName = sc.next();
                boolean isPresent = contact_Details.stream().anyMatch(n->n.getFirstname().equalsIgnoreCase(firstName));
                if(isPresent){
                    System.out.println("Contact already present");
                    return;
                }
                System.out.println("Last name");
                String lastName = sc.next();
                System.out.println("Enter address");
                String address = sc.next();
                System.out.println("Enter city ");
                String city = sc.next();
                System.out.println("Enter state ");
                String state = sc.next();
                System.out.println("Enter zip ");
                int zipCode = sc.nextInt();
                System.out.println("Enter phone number ");
                long phoneNumber = sc.nextInt();
                System.out.println("Contact number " + (i + 1) + " saved");
                Contact details = new Contact(firstName, lastName, address, city, state,zipCode, phoneNumber);
                contact_Details.add(details);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void editContacts(String name) {
        for (Contact contact : contact_Details) {
            if (name.equalsIgnoreCase(contact.getFirstname())) {
                System.out.println("Entered Name found in the contacts");
                System.out.println("Enter the updated first name");
                String firstName = sc.next();
                contact.setFirstname(firstName);
                System.out.println("Enter the updated last name");
                String lastName = sc.next();
                contact.setLastname(lastName);
                System.out.println("Enter the updated address");
                String address = sc.next();
                contact.setAddress(address);
                System.out.println("Enter the updated city");
                String city = sc.next();
                contact.setCity(city);
                System.out.println("Enter the updated state");
                String state = sc.next();
                contact.setState(state);
                System.out.println("Enter the updated zipcode");
                int zipcode = sc.nextInt();
                contact.setZip(zipcode);
                System.out.println("Enter the updated phoneNumber");
                long phoneNumber = sc.nextInt();
                contact.setMobileno(phoneNumber);
            } else
                System.out.println("Entered name not  found in the AddressBook");
        }
    }

    public void deleteContact(String name) {
        for (Contact contact : contact_Details) {
            if (name.equalsIgnoreCase(contact.getFirstname())) {
                System.out.println("Entered Name found in the contacts, deleting contact");
                contact_Details.remove(contact);
            } else
                System.out.println("Entered name not found in the AddressBook");
        }
    }

    public void searchByCityOrState(){
        System.out.println("Enter 1 for searching by the city \n Enter 2 for searching by state ");
        int input = sc.nextInt();
        if(input == 1){
            System.out.println("Enter city name for search contacts");
            String city = sc.next();
            contact_Details.stream().filter(contact -> contact.getCity().equalsIgnoreCase(city)).forEach(contact ->
                    System.out.println(contact));
        }else if(input == 2) {
            System.out.println("Enter state name to search contact");
            String state = sc.next();
            contact_Details.stream().filter(contact -> contact.getState().equalsIgnoreCase(state)).forEach(contact ->
                    System.out.println(contact));
        }

    }

    public void showContacts() {
        int i = 1;
        for (Contact contact : contact_Details) {
            System.out.println("Details  of contact number " + i + " is");
            System.out.println(contact.toString());
            i++;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddressBook book1 = new AddressBook();
        AddressBook book2 = new AddressBook();
        AddressBook book3 = new AddressBook();
        addressBooks.put("AddressBook1", book1);
        addressBooks.put("AddressBook2", book2);
        addressBooks.put("AddressBook3", book3);

        System.out.println("Welcome to Address Book");
        int i = 1;
        while (i != 0) {
            System.out.println("Enter 1 to for AddressBook1 2 for AddressBook2 and 3 for AddressBook3");
            int choose_AddressBook = sc.nextInt();
            System.out.println(
                    "Enter 1 to add contact \nEnter 2 to edit details of contacts \nEnter 3 for deleting contact \nEnter 4 for showing details of contacts \nEnter 5 Search by city or state");
            int userChoice = sc.nextInt();
            switch (userChoice) {
                case 1:
                    if (choose_AddressBook == 1)
                        book1.addContacts();
                    else if (choose_AddressBook == 2)
                        book2.addContacts();
                    else if (choose_AddressBook == 3)
                        book3.addContacts();
                    else
                        System.out.println("Option not found");
                    break;
                case 2:
                    if (choose_AddressBook == 1) {
                        System.out.println("Enter the first name by which u want to edit contact");
                        String name = sc.next();
                        book1.editContacts(name);
                        break;
                    } else if (choose_AddressBook == 2) {
                        System.out.println("Enter the first name by which u want to edit contact");
                        String name = sc.next();
                        book2.editContacts(name);
                        break;
                    } else if (choose_AddressBook == 3) {
                        System.out.println("Enter the first name by which u want to edit contact");
                        String name = sc.next();
                        book3.editContacts(name);
                        break;
                    }

                case 3:
                    if (choose_AddressBook == 1) {
                        System.out.println("Enter the first name by which u want to edit contact");
                        String search_Name = sc.next();
                        book1.deleteContact(search_Name);
                        break;
                    } else if (choose_AddressBook == 2) {
                        System.out.println("Enter the first name by which u want to edit contact");
                        String search_Name = sc.next();
                        book2.deleteContact(search_Name);
                        break;
                    }
                    if (choose_AddressBook == 3) {
                        System.out.println("Enter the first name by which u want to edit contact");
                        String search_Name = sc.next();
                        book3.deleteContact(search_Name);
                        break;
                    }
                case 4:
                    if (choose_AddressBook == 1) {
                        book1.showContacts();
                        break;
                    } else if (choose_AddressBook == 2) {
                        book2.showContacts();
                        break;
                    } else if (choose_AddressBook == 3) {
                        book3.showContacts();
                        break;
                    }
                case 5:
                    if (choose_AddressBook == 1) {
                        book1.searchByCityOrState();
                        break;
                    } else if (choose_AddressBook == 2) {
                        book2.searchByCityOrState();
                        break;
                    } else if (choose_AddressBook == 3) {
                        book3.searchByCityOrState();
                        break;
                    }

                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }
}
