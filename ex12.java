import java.util.Scanner;

class Student {

    private int id;
    private String name;
    private String department;
    private int mark1, mark2, mark3;
    private int total;
    private double average;
    private char grade;

    // Constructor
    Student(int id, String name, String department,
            int mark1, int mark2, int mark3) {

        this.id = id;
        this.name = name;
        this.department = department;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;

        calculateResult();
    }

    // Calculate total, average and grade
    void calculateResult() {

        total = mark1 + mark2 + mark3;
        average = total / 3.0;

        if (average >= 90)
            grade = 'A';
        else if (average >= 75)
            grade = 'B';
        else if (average >= 60)
            grade = 'C';
        else if (average >= 50)
            grade = 'D';
        else
            grade = 'F';
    }

    // Display student details
    void display() {

        System.out.println("--------------------------------");
        System.out.println("Student ID    : " + id);
        System.out.println("Student Name  : " + name);
        System.out.println("Department    : " + department);
        System.out.println("Mark 1        : " + mark1);
        System.out.println("Mark 2        : " + mark2);
        System.out.println("Mark 3        : " + mark3);
        System.out.println("Total Marks   : " + total);
        System.out.printf("Average       : %.2f%n", average);
        System.out.println("Grade         : " + grade);
        System.out.println("--------------------------------");
    }

    // Return student ID
    int getId() {
        return id;
    }
}

public class StudentManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Student[] students = new Student[50];

        int count = 0;
        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    if (count >= 50) {
                        System.out.println("Student limit reached!");
                        break;
                    }

                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    System.out.print("Enter Mark 1: ");
                    int m1 = sc.nextInt();

                    System.out.print("Enter Mark 2: ");
                    int m2 = sc.nextInt();

                    System.out.print("Enter Mark 3: ");
                    int m3 = sc.nextInt();

                    students[count] = new Student(
                            id, name, department, m1, m2, m3
                    );

                    count++;

                    System.out.println(
                        "Student added successfully!"
                    );

                    break;

                case 2:

                    if (count == 0) {
                        System.out.println("No student records found.");
                    } else {

                        System.out.println("\n===== ALL STUDENTS =====");

                        for (int i = 0; i < count; i++) {
                            students[i].display();
                        }
                    }

                    break;

                case 3:

                    if (count == 0) {
                        System.out.println("No student records found.");
                        break;
                    }

                    System.out.print("Enter Student ID to search: ");
                    int searchId = sc.nextInt();

                    boolean found = false;

                    for (int i = 0; i < count; i++) {

                        if (students[i].getId() == searchId) {
                            System.out.println(
                                "\nStudent Found!"
                            );

                            students[i].display();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println(
                            "Student ID not found."
                        );
                    }

                    break;

                case 4:

                    System.out.println(
                        "Thank you for using Student Management System!"
                    );

                    break;

                default:

                    System.out.println(
                        "Invalid choice! Please try again."
                    );
            }

        } while (choice != 4);

        sc.close();
    }
}