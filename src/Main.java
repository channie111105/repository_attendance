import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Student Attendance Management System");
            System.out.println("1. Add new student");
            System.out.println("2. Display student list");
            System.out.println("3. Delete student by ID");
            System.out.println("4. Sort students by attendance (descending)");
            System.out.println("5. Search student by ID or name");
            System.out.println("6. Mark attendance for a student");
            System.out.println("7. Filter students with attendance >= x");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    input();
                    break;
                case 2:
                    output();
                    break;
                case 3:
                    System.out.print("Enter student ID to delete: ");
                    String id = scanner.nextLine();
                    removeByID(id);
                    break;
                case 4:
                    sortByAttendanceDesc();
                    break;
                case 5:
                    System.out.print("Enter student ID or name to search: ");
                    String keyword = scanner.nextLine();
                    Student foundStudent = findByIDOrName(keyword);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 6:
                    System.out.print("Enter student ID to mark attendance: ");
                    String studentID = scanner.nextLine();
                    markAttendance(studentID);
                    break;
                case 7:
                    System.out.print("Enter attendance threshold: ");
                    int x = scanner.nextInt();
                    List<Student> filteredStudents = filterByAttendance(x);
                    if (!filteredStudents.isEmpty()) {
                        System.out.println("Students with attendance >= " + x + ":");
                        for (Student student : filteredStudents) {
                            System.out.println(student);
                        }
                    } else {
                        System.out.println("No students found with attendance >= " + x);
                    }
                    break;
                case 8:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Add new student
    public static void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student information:");
        System.out.print("Student ID: ");
        String studentID = scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Class: ");
        String className = scanner.nextLine();
        System.out.print("Major: ");
        String major = scanner.nextLine();
        int attendance = 0; // New students start with 0 attendance

        Student student = new Student(studentID, name, className, major, attendance);
        studentList.add(student);
    }

    // Display student list
    public static void output() {
        System.out.println("Student list:");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    // Delete student by ID
    public static void removeByID(String studentID) {
        studentList.removeIf(student -> student.getStudentID().equalsIgnoreCase(studentID));
        System.out.println("Student with ID " + studentID + " has been removed.");
    }

    // Sort students by attendance in descending order
    public static void sortByAttendanceDesc() {
        studentList.sort(Comparator.comparingInt(Student::getAttendance).reversed());
        System.out.println("Students sorted by attendance in descending order.");
    }

    // Search student by ID or name
    public static Student findByIDOrName(String keyword) {
        for (Student student : studentList) {
            if (student.getStudentID().equalsIgnoreCase(keyword) || student.getName().equalsIgnoreCase(keyword)) {
                return student;
            }
        }
        return null;
    }

    // Mark attendance for a student
    public static void markAttendance(String studentID) {
        for (Student student : studentList) {
            if (student.getStudentID().equalsIgnoreCase(studentID)) {
                student.setAttendance(student.getAttendance() + 1);
                System.out.println("Attendance marked for student: " + student.getName());
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Filter students with attendance >= x
    public static List<Student> filterByAttendance(int x) {
        List<Student> result = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getAttendance() >= x) {
                result.add(student);
            }
        }
        return result;
    }
}