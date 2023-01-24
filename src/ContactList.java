import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that stores subclasses of Person as a contact list.
 * The user is presented with a menu of options and may add, sort,
 * search, or list the contacts.
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 * Editor: Aarav Gupta
 * Due Date: 1/21/23
 */

public class ContactList
{
    ArrayList<Person> contacts;
    public ContactList(ArrayList<Person> contacts) {
        this.contacts = contacts;
    }
    public void printMenuOptions() {
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search by Phone Number");
        System.out.println("0. Exit");
    }
    /**
     * Asks user for input to create and add a new Person
     * to the contact list.
     */
    public void addContact() {
        Scanner s = new Scanner(System.in);
        System.out.println("Select a type of contact to add: ");
        System.out.println("1. Student");
        System.out.println("2. Worker");
        int type = s.nextInt();
        s.nextLine();
        System.out.println("Please fill in the following information.");
        System.out.println("First Name:");
        String firstName = s.nextLine();
        System.out.println("Last Name:");
        String lastName = s.nextLine();
        System.out.println("Phone Number:");
        String phoneNumber = s.nextLine();
        if (type == 1)
        {
            System.out.println("Grade: ");
            int theGrade = s.nextInt();
            s.nextLine();
            Student newStudent = new Student(firstName, lastName, phoneNumber, theGrade);
            contacts.add(newStudent);

        }
        else if (type == 2)
        {
            System.out.println("Salary: ");
            int theSalary = s.nextInt();
            s.nextLine();
            Worker newWorker = new Worker(firstName, lastName, phoneNumber, theSalary);
            contacts.add(newWorker);

        }
    }
    /**
     * Loops through and prints all contacts
     */
    public void printContacts() {
        for (Person contact : contacts) {
            System.out.println(contact);
        }
    }
    public void printFirstName() {
        for (Person contact : contacts) {
            System.out.println(contact.getFirstName());
        }
    }
    public void printLastName() {
        for (Person contact : contacts) {
            System.out.println(contact.getLastName());
        }
    }
    public void printPhoneNumber() {
        for (Person contact : contacts) {
            System.out.println(contact.getPhoneNumber());
        }
    }
    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    public void sort(int sortBy) {
        int n = contacts.size();
        // Sorts by first name
        if (sortBy == 0)
        {
            for (int pass = 1; pass < n; pass++)
            {
                for (int comp = 0; comp < n - pass; comp++)
                {
                    // Compares first name of initial contact with following contact
                    if (contacts.get(comp).getFirstName().compareTo(contacts.get(comp + 1).getFirstName()) > 0)
                    {
                        // Switches the order of contacts if the contact after precedes the initial contact by first name
                        contacts.set(comp + 1, contacts.get(comp));
                    }
                }
            }
        }
        else if (sortBy == 1)
        {
            for (int pass = 1; pass < n; pass++)
            {
                for (int comp = 0; comp < n - pass; comp++)
                {
                    // Here, look at compareTo notes in class and on assignment
                    if (contacts.get(comp).getLastName().compareTo(contacts.get(comp + 1).getLastName()) > 0)
                    {
                        // Not sure about this
                        contacts.set(comp + 1, contacts.get(comp));
                    }
                }
            }
        }
        if (sortBy == 2)
        {
            for (int pass = 1; pass < n; pass++)
            {
                for (int comp = 0; comp < n - pass; comp++)
                {
                    // Here, look at compareTo notes in class and on assignment
                    if (contacts.get(comp).getPhoneNumber().compareTo(contacts.get(comp + 1).getPhoneNumber()) > 0)
                    {
                        // Not sure about this
                        contacts.set(comp + 1, contacts.get(comp));
                    }
                }
            }
        }
    }
    /**
    Searches contact by firstName, lastName, or phoneNumber
     */
    public Person searchByFirstName(String firstName)
    {
        for (Person contact : contacts) {
            if (contact.getFirstName().equals(firstName)) {
                return contact;
            }
        }
        return null;
    }
    public Person searchByLastName(String lastName)
    {
        for (Person contact : contacts) {
            if (contact.getLastName().equals(lastName)) {
                return contact;
            }
        }
        return null;
    }
    public Person searchByPhoneNumber(String phoneNumber)
    {
        for (Person contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }
        return null;
    }
    /**
     * Lists just the Student objects in the Contact List
     */
    public void listStudents() {
        for (Person contact : contacts) {
            if (contact instanceof Student) {
                System.out.println(contact);
            }

        }
    }
    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    public void run() {
        Scanner s = new Scanner(System.in);
        Scanner a = new Scanner(System.in);
        System.out.println("Welcome to your Contacts List");
        System.out.println("Please pick from the following menu options");
        System.out.println();
        System.out.println();
        printMenuOptions();
        int input = s.nextInt();
        if (input == 0)
        {
            System.exit(0);
        }
        while (input != 0)
        {
            if (input == 1)
            {
                addContact();
            }
            else if (input == 2)
            {
                printFirstName();
            }
            else if (input == 3)
            {
                printLastName();
            }
            else if (input == 4)
            {
                printPhoneNumber();
            }
            else if (input == 5)
            {
                listStudents();
            }
            else if (input == 6)
            {
                System.out.println("Enter a name:");
                String name = a.nextLine();
                if (searchByFirstName(name) == null)
                {
                    System.out.println(name + " is not in the list");
                }
                else
                {
                    System.out.println(searchByFirstName(name));
                }
            }
            else if (input == 7)
            {
                System.out.println("Enter a name:");
                String name = a.nextLine();
                if (searchByLastName(name) == null)
                {
                    System.out.println(name + " is not in the list");
                }
                else
                {
                    System.out.println(searchByLastName(name));
                }
            }
            else if (input == 8)
            {
                System.out.println("Enter a phone number:");
                String phoneNumber = a.nextLine();
                if (searchByPhoneNumber(phoneNumber) == null)
                {
                    System.out.println(phoneNumber + " is not in the list");
                }
                else
                {
                    System.out.println(searchByPhoneNumber(phoneNumber));
                }
            }
            System.out.println();
            printMenuOptions();
            input = s.nextInt();
        }
    }
    public static void main(String[] args)
    {
        ArrayList<Person> list = new ArrayList<>();
        ContactList cl = new ContactList(list);
        cl.run();
    }
}
