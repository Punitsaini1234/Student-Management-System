import java.io.*;
import java.util.*;

// Student class
class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private int age;
    private String gender;
    private String email;
    private String phone;
    private String course;
    private String department;
    private double marks;
    private double percentage;

    // Constructor
    public Student(int id, String name, int age, String gender,
                   String email, String phone, String course,
                   String department, double marks, double percentage) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.course = course;
        this.department = department;
        this.marks = marks;
        this.percentage = percentage;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCourse() {
        return course;
    }

    public String getDepartment() {
        return department;
    }

    public double getMarks() {
        return marks;
    }

    public double getPercentage() {
        return percentage;
    }

    // Display student information
    @Override
    public String toString() {
        return "ID: " + id +
                " | Name: " + name +
                " | Age: " + age +
                " | Gender: " + gender +
                " | Email: " + email +
                " | Phone: " + phone +
                " | Course: " + course +
                " | Department: " + department +
                " | Marks: " + marks +
                " | Percentage: " + percentage;
    }
}


// Main class
public class Main {

    private static final String FILE_NAME = "students.dat";

    // Save students to file
    public static void saveStudents(List<Student> students) {

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(
                             new FileOutputStream(FILE_NAME))) {

            oos.writeObject(students);

        } catch (IOException e) {
            System.out.println("Error while saving data: " + e.getMessage());
        }
    }


    // Load students from file
    @SuppressWarnings("unchecked")
    public static List<Student> loadStudents() {

        File file = new File(FILE_NAME);

        // If file does not exist
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(
                             new FileInputStream(FILE_NAME))) {

            return (List<Student>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while loading data: " + e.getMessage());
            return new ArrayList<>();
        }
    }


    // Check whether ID already exists
    public static boolean isIdExists(List<Student> students, int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return true;
            }
        }

        return false;
    }


    // Add student
    public static void addStudent(List<Student> students, Scanner sc) {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        // Prevent duplicate ID
        if (isIdExists(students, id)) {
            System.out.println("Student ID already exists!");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Gender: ");
        String gender = sc.nextLine();

        System.out.print("Enter Student Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Student Phone: ");
        String phone = sc.nextLine();

        System.out.print("Enter Student Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Student Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Student Marks: ");
        double marks = sc.nextDouble();

        System.out.print("Enter Student Percentage: ");
        double percentage = sc.nextDouble();
        sc.nextLine();

        Student student = new Student(
                id,
                name,
                age,
                gender,
                email,
                phone,
                course,
                department,
                marks,
                percentage
        );

        students.add(student);

        saveStudents(students);

        System.out.println("Student added successfully!");
    }


    // Display students
    public static void displayStudents(List<Student> students) {

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n================ STUDENT RECORDS ================");

        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("==================================================");
    }


    // Search student
    public static void searchStudent(List<Student> students, Scanner sc) {

        System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean found = false;

        for (Student student : students) {

            if (student.getId() == id) {

                System.out.println("\nStudent Found:");
                System.out.println(student);

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Record not found.");
        }
    }


    // Delete student
    public static void deleteStudent(List<Student> students, Scanner sc) {

        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        Iterator<Student> iterator = students.iterator();

        boolean found = false;

        while (iterator.hasNext()) {

            Student student = iterator.next();

            if (student.getId() == id) {

                iterator.remove();
                found = true;
                break;
            }
        }

        if (found) {

            saveStudents(students);

            System.out.println("Student deleted successfully!");

        } else {

            System.out.println("Record not found.");
        }
    }


    // Update student
    public static void updateStudent(List<Student> students, Scanner sc) {

        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        ListIterator<Student> iterator = students.listIterator();

        boolean found = false;

        while (iterator.hasNext()) {

            Student oldStudent = iterator.next();

            if (oldStudent.getId() == id) {

                System.out.print("Enter New Name: ");
                String name = sc.nextLine();

                System.out.print("Enter New Age: ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New Gender: ");
                String gender = sc.nextLine();

                System.out.print("Enter New Email: ");
                String email = sc.nextLine();

                System.out.print("Enter New Phone: ");
                String phone = sc.nextLine();

                System.out.print("Enter New Course: ");
                String course = sc.nextLine();

                System.out.print("Enter New Department: ");
                String department = sc.nextLine();

                System.out.print("Enter New Marks: ");
                double marks = sc.nextDouble();

                System.out.print("Enter New Percentage: ");
                double percentage = sc.nextDouble();
                sc.nextLine();

                Student updatedStudent = new Student(
                        id,
                        name,
                        age,
                        gender,
                        email,
                        phone,
                        course,
                        department,
                        marks,
                        percentage
                );

                iterator.set(updatedStudent);

                found = true;

                break;
            }
        }

        if (found) {

            saveStudents(students);

            System.out.println("Student updated successfully!");

        } else {

            System.out.println("Record not found.");
        }
    }


    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Load previous records
        List<Student> students = loadStudents();

        int choice = 0;

        do {

            System.out.println("\n==================================");
            System.out.println("     STUDENT MANAGEMENT SYSTEM");
            System.out.println("==================================");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("0. Exit");
            System.out.println("==================================");

            System.out.print("Enter your choice: ");

            // Handle invalid menu input
            if (!sc.hasNextInt()) {

                System.out.println("Please enter a valid number.");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addStudent(students, sc);
                    break;

                case 2:
                    displayStudents(students);
                    break;

                case 3:
                    searchStudent(students, sc);
                    break;

                case 4:
                    deleteStudent(students, sc);
                    break;

                case 5:
                    updateStudent(students, sc);
                    break;

                case 0:
                    System.out.println("Thank you for using Student Management System!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}
