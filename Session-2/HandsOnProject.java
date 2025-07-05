/*
Overview of Project Goals: Develop a simple application to manage student records, demonstrating the use of Java Collections and Exception Handling.
Use of `ArrayList` to store student data: An `ArrayList<Student>` can be used to maintain a list of `Student` objects, allowing easy addition and retrieval by index.
Use of `HashMap` for fast lookup: A `HashMap<String, Student>` can store student records where the student ID (String) is the key and the `Student` object is the value, enabling quick retrieval of student data by ID.
*/

import java.util.*;

class Student {
    private final String id;
    private final String name;
    private final int marks;

    public Student(String id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getMarks() { return marks; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}

class StudentRepository {
    private final List<Student> studentList = new ArrayList<>();
    private final Map<String, Student> studentMap = new HashMap<>();

    public boolean addStudent(Student student) {
        if (studentMap.containsKey(student.getId())) return false;
        studentList.add(student);
        studentMap.put(student.getId(), student);
        return true;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(studentList);
    }

    public Student getStudentById(String id) {
        return studentMap.get(id);
    }
}

class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public boolean addStudent(String id, String name, int marks) {
        if (id == null || name == null || marks < 0 || marks > 100) return false;
        Student student = new Student(id.trim(), name.trim(), marks);
        return repository.addStudent(student);
    }

    public List<Student> getAllStudents() {
        return repository.getAllStudents();
    }

    public Student findStudentById(String id) {
        return repository.getStudentById(id.trim());
    }

    public List<Student> sortByName() {
        List<Student> students = repository.getAllStudents();
        students.sort(Comparator.comparing(s -> s.getName().toLowerCase()));
        return students;
    }

    public List<Student> sortByMarks() {
        List<Student> students = repository.getAllStudents();
        students.sort(Comparator.comparingInt(Student::getMarks).reversed());
        return students;
    }
}

class StudentConsoleUI {
    private final Scanner scanner = new Scanner(System.in);
    private final StudentService service;

    public StudentConsoleUI(StudentService service) {
        this.service = service;
    }

    public void start() {
        int choice;
        do {
            printMenu();
            choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> handleAddStudent();
                case 2 -> displayStudents(service.getAllStudents(), "All Students");
                case 3 -> handleSearchStudent();
                case 4 -> displayStudents(service.sortByName(), "Sorted by Name");
                case 5 -> displayStudents(service.sortByMarks(), "Sorted by Marks");
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private void printMenu() {
        System.out.println("\n--- Student Management ---");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Sort Students by Name");
        System.out.println("5. Sort Students by Marks");
        System.out.println("0. Exit");
    }

    private void handleAddStudent() {
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        int marks = readInt("Enter Marks (0-100): ");

        if (service.addStudent(id, name, marks)) {
            System.out.println("Student added.");
        } else {
            System.out.println("Failed to add. ID may exist or marks invalid.");
        }
    }

    private void handleSearchStudent() {
        System.out.print("Enter Student ID to search: ");
        String id = scanner.nextLine();
        Student student = service.findStudentById(id);
        if (student != null) {
            System.out.println("Found: " + student);
        } else {
            System.out.println("No student found with ID: " + id);
        }
    }

    private void displayStudents(List<Student> students, String title) {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            System.out.println("\n--- " + title + " ---");
            students.forEach(System.out::println);
        }
    }

    private int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}


public class HandsOnProject {
    public static void main(String[] args) {
        StudentRepository repository = new StudentRepository();
        StudentService service = new StudentService(repository);
        StudentConsoleUI consoleUI = new StudentConsoleUI(service);
        consoleUI.start();
    }
}
