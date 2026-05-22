package org.example.service;

import org.example.model.StudentGrade;

import java.util.ArrayList;

public class ReportGenerator {

    public static void findTopPerformer(
            ArrayList<StudentGrade> students) {

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

    public static void generateReport(
            ArrayList<StudentGrade> students) {

        if (students.isEmpty()) {

            System.out.println("No students found!");
            return;
        }

        System.out.println("\n=== PERFORMANCE REPORT ===");

        System.out.println("Total Students: "
                + students.size());

        String[] subjects = {
                "Mathematics",
                "Science",
                "English",
                "History",
                "Computer"
        };

        System.out.println("\n📊 SUBJECT AVERAGES:");

        for (int i = 0; i < subjects.length; i++) {

            double total = 0;

            for (StudentGrade s : students) {

                total += s.getMarks()[i];
            }

            double subjectAverage =
                    total / students.size();

            System.out.printf(
                    "• %-12s: %.2f\n",
                    subjects[i],
                    subjectAverage);
        }

        System.out.println("\n🏆 TOP PERFORMERS:");

        ArrayList<StudentGrade> sortedStudents =
                new ArrayList<>(students);

        sortedStudents.sort((s1, s2) -> {

            double avg1 =
                    GradeCalculator.calculateAverage(
                            s1.getMarks());

            double avg2 =
                    GradeCalculator.calculateAverage(
                            s2.getMarks());

            return Double.compare(avg2, avg1);
        });

        for (int i = 0; i < sortedStudents.size(); i++) {

            StudentGrade s = sortedStudents.get(i);

            double average =
                    GradeCalculator.calculateAverage(
                            s.getMarks());

            System.out.printf(
                    "%d. %s - Average: %.2f\n",
                    i + 1,
                    s.getStudentName(),
                    average);
        }

        int a = 0, b = 0, c = 0, d = 0, f = 0;

        for (StudentGrade s : students) {

            double average =
                    GradeCalculator.calculateAverage(
                            s.getMarks());

            String grade =
                    GradeCalculator.getGrade(
                            average);

            switch (grade) {

                case "A+":
                case "A":
                    a++;
                    break;

                case "B":
                    b++;
                    break;

                case "C":
                    c++;
                    break;

                case "D":
                    d++;
                    break;

                default:
                    f++;
            }
        }

        System.out.println("\n📈 GRADE DISTRIBUTION:");

        System.out.println("• A Grade: " + a + " students");
        System.out.println("• B Grade: " + b + " students");
        System.out.println("• C Grade: " + c + " students");
        System.out.println("• D Grade: " + d + " students");
        System.out.println("• F Grade: " + f + " students");
    }
}