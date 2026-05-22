package org.example.model;

public class StudentGrade {

    private String studentName;
    private double[] marks;

    public StudentGrade(String studentName,
                        double[] marks) {

        this.studentName = studentName;
        this.marks = marks;
    }

    public String getStudentName() {
        return studentName;
    }

    public double[] getMarks() {
        return marks;
    }
}