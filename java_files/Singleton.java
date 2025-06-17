//Create a class to which only one object can be created:

import java.util.Scanner; // Import Scanner class for user input

// Define the Person class
class Person {
    private int id; // Private variable to store id
    private String name; // Private variable to store name
    private char gender; // Private variable to store gender
    private String location; // Private variable to store location
    private static Person person; // Static reference to the single Person object (Singleton)

    // Private constructor to prevent direct object creation from outside the class
    private Person() {
        System.out.println("Person object is created"); // Print message when object is created
    }

    // Static method to create or return the single instance of Person
    public static Person createPerson() {
        if (person == null) { // If no object exists
            person = new Person(); // Create new Person object
        }
        return person; // Return the single Person object
    }

    // Method to set the details of the Person object
    public void setPerson(int id, String name, char gender, String location) {
        this.id = id; // Set id
        this.name = name; // Set name
        this.gender = gender; // Set gender
        this.location = location; // Set location
    }

    // Override toString() to display Person details
    @Override
    public String toString() {
        return "Person Details = Id:" + id + ", Name:" + name +
         ", Gender:" + gender + ", Location:" + location; // Return formatted string
    }
}


public class Singleton {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 

        Person person1 = Person.createPerson(); // Create first Person object (actually creates the singleton)
        person1.setPerson(101, "nithin", 'm', "mysuru"); // Set details for person1
        System.out.println(person1); // Print details of person1

        Person person2 = Person.createPerson(); // Try to create another Person object (returns the same singleton)
        System.out.println(person2); // Print details of person2 (same as person1 at this point)
        person2.setPerson(102, "aadya", 'f', "mysuru"); // Update details using person2 reference
        System.out.println(person1); // Print details of person1 (shows updated details, since both references point to the same object)
    }
}