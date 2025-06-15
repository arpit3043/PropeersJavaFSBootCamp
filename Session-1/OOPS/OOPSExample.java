package OOPS;

class Person {
    String name;
    int age;
    // Constructor to initialize the Person object
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    // printDetailsWithThis() method to print the details of the Person
    public void printDetailsWithThis() {
        System.out.println("Person Details: ");
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
    }
}


// Inheritance
class Student extends Person {
    int rollNumber;
    String section;

    // Constructor to initialize the Student object
    // calling from parent to child class --> Super keyword
    // calling from child to parent class --> this keyword
    Student(String name, int age, int rollNumber, String section) {
        super(name, age); // Call the constructor of the Person class
        this.rollNumber = rollNumber;
        this.section = section;
    }

    public void printDetailsWithThis() {
        System.out.println("Student Details: ");
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Roll Number: " + this.rollNumber);
        System.out.println("Section: " + this.section);
    }

    public void printDetailsWithThis(boolean hideSection) {
        System.out.println("Student Details: ");
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Roll Number: " + this.rollNumber);
        if (!hideSection) {
            System.out.println("Section: " + this.section);
        } else {
            System.out.println("Section is hidden.");
        }
        
    }

    // Method Overloading : performed in the same class where we have multiple methods with same name
    // but different parameters

    // Method Overriding: performed in the child class where we have same method name as parent class

    // public void printDetailsWithoutThis() {
    //     System.out.println("Student Details: ");
    //     System.out.println("Name: " + name);
    //     System.out.println("Age: " + age);
    //     System.out.println("Roll Number: " + rollNumber);
    //     System.out.println("Section: " + section);
    // }

    // Abstraction : hidden implementation details
    // Encapsulation : hiding the data members of a class and providing public methods to access them --> Map<Character, Integer>map
    /**
     * Encapsulation Example:
     * {
     *  A: 1, 
     *  B: 2, 
     *  C: 3
     * }
     */
}

public class OOPSExample {
    public static void main(String[] args) {
       Person person1 = new Person("Arpit", 50);
    //    System.out.println(person1.age);
    //    System.out.println(person1.name);
       Student student1 = new Student("Arpit", 50, 101, "A");
    //    student1.printDetailsWithoutThis();
    //    student1.printDetailsWithThis(true);
    //    System.out.println(student1.name);
    //    System.out.println(student1.rollNumber);
    //    System.out.println(student1.age);
    student1.printDetailsWithThis(false);
    person1.printDetailsWithThis();
    }
}