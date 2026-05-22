package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class GradeManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<StudentGrade> students = new ArrayList<>();

    static final String[] SUBJECTS = {
            "Mathematics",
            "Science",
            "English",
            "History",
            "Computer"
    };

    public static void main(String[] args) {

        int choice = 0;

        do {

            System.out.println("\n========== GRADE MANAGEMENT SYSTEM ==========");

            System.out.println("1. Add Student Marks");
            System.out.println("2. View All Students");
            System.out.println("3. Calculate Grades");
            System.out.println("4. Find Top Performer");
            System.out.println("5. Generate Report");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            try {

                choice = sc.nextInt();
                sc.nextLine();

            } catch (Exception e) {

                System.out.println("❌ Invalid input!");
                sc.nextLine();
                continue;
            }

            switch (choice) {

                case 1:
                    addStudentMarks();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    calculateGrades();
                    break;

                case 4:
                    findTopPerformer();
                    break;

                case 5:
                    generateReport();
                    break;

                case 6:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("❌ Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }

    // Add Student
    public static void addStudentMarks() {

        System.out.print("Enter Student Name: ");

        String name = sc.nextLine();

        double[] marks = new double[SUBJECTS.length];

        for (int i = 0; i < SUBJECTS.length; i++) {

            while (true) {

                try {

                    System.out.print("Enter marks for "
                            + SUBJECTS[i] + ": ");

                    marks[i] = sc.nextDouble();

                    if (marks[i] >= 0 && marks[i] <= 100) {

                        break;

                    } else {

                        System.out.println("❌ Marks must be between 0 and 100");
                    }

                } catch (Exception e) {

                    System.out.println("❌ Invalid input!");

                    sc.nextLine();
                }
            }
        }

        sc.nextLine();

        StudentGrade student =
                new StudentGrade(name, marks);

        students.add(student);

        System.out.println("✅ Student added successfully!");
    }

    // View Students
    public static void viewStudents() {

        if (students.isEmpty()) {

            System.out.println("No students found.");
            return;
        }

        System.out.println("\n================ STUDENT RECORDS ================");

        for (StudentGrade s : students) {

            System.out.println("\nStudent Name: "
                    + s.getStudentName());

            double[] marks = s.getMarks();

            for (int i = 0; i < SUBJECTS.length; i++) {

                System.out.println(SUBJECTS[i]
                        + ": " + marks[i]);
            }
        }
    }

    // Calculate Grades
    public static void calculateGrades() {

        if (students.isEmpty()) {

            System.out.println("No students found.");
            return;
        }

        System.out.println("\n================ GRADE REPORT ================");

        for (StudentGrade s : students) {

            double average =
                    GradeCalculator.calculateAverage(
                            s.getMarks());

            String grade =
                    GradeCalculator.getGrade(average);

            System.out.printf(
                    "%-20s Average: %-10.2f Grade: %s\n",
                    s.getStudentName(),
                    average,
                    grade
            );
        }
    }

    // Find Top Performer
    public static void findTopPerformer() {

        if (students.isEmpty()) {

            System.out.println("No students found.");
            return;
        }

        StudentGrade topStudent = students.get(0);

        double highestAverage =
                GradeCalculator.calculateAverage(
                        topStudent.getMarks());

        for (StudentGrade s : students) {

            double average =
                    GradeCalculator.calculateAverage(
                            s.getMarks());

            if (average > highestAverage) {

                highestAverage = average;
                topStudent = s;
            }
        }

        System.out.println("\n🏆 TOP PERFORMER");

        System.out.println("Name: "
                + topStudent.getStudentName());

        System.out.printf("Average: %.2f\n",
                highestAverage);
    }

    // Generate Report
    public static void generateReport() {

        if (students.isEmpty()) {

            System.out.println("No students found.");
            return;
        }

        System.out.println("\n============= PERFORMANCE REPORT =============");

        System.out.println("Total Students: "
                + students.size());

        double totalAverage = 0;

        for (StudentGrade s : students) {

            totalAverage +=
                    GradeCalculator.calculateAverage(
                            s.getMarks());
        }

        System.out.printf("Class Average: %.2f\n",
                totalAverage / students.size());

        findTopPerformer();
    }
}