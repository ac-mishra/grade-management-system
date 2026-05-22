package org.example;

import org.example.model.StudentGrade;
import org.example.service.GradeCalculator;
import org.example.service.ReportGenerator;
import org.example.util.ValidationUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class GradeManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<StudentGrade> students =
            new ArrayList<>();

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
                    ReportGenerator.findTopPerformer(
                            students);
                    break;

                case 5:
                    ReportGenerator.generateReport(
                            students);
                    break;



                case 6:
                    System.out.println(
                            "Thank you for using the system!");
                    break;

                default:
                    System.out.println(
                            "❌ Invalid choice!");
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

                    System.out.print(
                            "Enter marks for "
                                    + SUBJECTS[i] + ": ");

                    marks[i] = sc.nextDouble();

                    if (ValidationUtils.isValidMark(
                            marks[i])) {

                        break;

                    } else {

                        System.out.println(
                                "❌ Marks must be between 0 and 100");
                    }

                } catch (Exception e) {

                    System.out.println(
                            "❌ Invalid input!");

                    sc.nextLine();
                }
            }
        }

        sc.nextLine();

        StudentGrade student =
                new StudentGrade(name, marks);

        students.add(student);

        System.out.println(
                "✅ Student added successfully!");
    }

    // View Students
    public static void viewStudents() {

        System.out.println("\n=== ALL STUDENTS ===");

        if (students.isEmpty()) {

            System.out.println("No students found!");
            return;
        }

        System.out.printf(
                "%-20s %-12s %-12s %-12s %-12s %-12s %-12s\n",
                "Student Name",
                "Math",
                "Science",
                "English",
                "History",
                "Computer",
                "Average");

        System.out.println(
                "-".repeat(100));

        for (StudentGrade s : students) {

            double[] marks = s.getMarks();

            double average =
                    GradeCalculator.calculateAverage(marks);

            System.out.printf(
                    "%-20s %-12.2f %-12.2f %-12.2f %-12.2f %-12.2f %-12.2f\n",
                    s.getStudentName(),
                    marks[0],
                    marks[1],
                    marks[2],
                    marks[3],
                    marks[4],
                    average);
        }
    }

    // Calculate Grades
    public static void calculateGrades() {

        System.out.println("\n=== STUDENT AVERAGES ===");

        if (students.isEmpty()) {

            System.out.println("No students found!");
            return;
        }

        for (StudentGrade s : students) {

            double average =
                    GradeCalculator.calculateAverage(
                            s.getMarks());

            String grade =
                    GradeCalculator.getGrade(
                            average);

            System.out.printf(
                    "%-20s : Average = %.2f, Grade = %s\n",
                    s.getStudentName(),
                    average,
                    grade);
        }
    }
}