/**
 * @author: Aarav Gupta
 * A subclass of Person that represents a Worker
 */
public class Worker extends Person {

    // Instance Variables
    private final int salary;

    // Constructor
    public Worker (String firstName, String lastName, String phoneNumber, int salary) {
        super(firstName, lastName, phoneNumber);
        this.salary = salary;
    }

    // Methods
    public int getSalary() {
        return salary;
    }
    @Override
    public String toString() {
        return super.getFirstName() + " " + super.getLastName() + " - #" + super.getPhoneNumber() + " Salary: "
                + salary;
    }
}
