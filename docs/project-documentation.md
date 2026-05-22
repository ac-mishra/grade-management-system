    # Grade Management System Documentation

# 1. Introduction

The Grade Management System is a console-based Java application designed to manage student marks and generate performance reports.

The application allows users to:
- Store student marks
- Calculate averages
- Generate grades
- Find top performers
- Create performance summaries

The project demonstrates Core Java concepts including Arrays, Loops, Methods, Validation, Exception Handling, and Object-Oriented Programming.

---

# 2. Objectives

- Understand arrays and loops
- Implement grade calculation logic
- Practice Java methods
- Use validation and exception handling
- Build a menu-driven system
- Generate reports and statistics

---

# 3. Technologies Used

| Technology | Purpose |
|---|---|
| Java | Core programming |
| IntelliJ IDEA | IDE |
| Maven | Project management |
| Arrays | Marks storage |
| ArrayList | Student storage |

---

# 4. Features

- Add student marks
- View student records
- Calculate averages
- Generate grades
- Find top performers
- Generate reports
- Input validation
- Exception handling

---

# 5. Project Structure

```text
GradeManagementSystem
│
├── src
│   └── main
│       └── java
│           └── org.example
│               ├── StudentGrade.java
│               ├── GradeCalculator.java
│               ├── ReportGenerator.java
│               └── GradeManagementSystem.java
│
├── docs
├── screenshots
├── examples
└── README.md
```

---

# 6. Class Explanation

## StudentGrade.java

Stores student name and subject marks.

### Attributes
- studentName
- marks array

---

## GradeCalculator.java

Contains methods for:
- Average calculation
- Grade calculation

---

## ReportGenerator.java

Handles report generation logic.

---

## GradeManagementSystem.java

Main application class that:
- Displays menu
- Handles user input
- Performs operations

---

# 7. Concepts Used

| Concept | Usage |
|---|---|
| Arrays | Subject marks |
| Loops | Iteration |
| switch-case | Menu system |
| Methods | Calculations |
| Exception Handling | Input validation |
| OOP | Class structure |

---

# 8. Algorithms

## Average Calculation
1. Add all marks
2. Divide by subject count

---

## Grade Logic

| Average | Grade |
|---|---|
| 90+ | A+ |
| 80+ | A |
| 70+ | B |
| 60+ | C |
| 50+ | D |
| Below 50 | F |

---

# 9. Validation

The system validates:
- Marks between 0 and 100
- Numeric input only
- Valid menu selection

---

# 10. Sample Data

| Name | Average |
|---|---|
| Amrit Chandan | 90 |
| Rahul Sharma | 73 |
| Priya Das | 88 |

---

# 11. Testing

| Feature | Status |
|---|---|
| Add Student | Passed |
| View Students | Passed |
| Calculate Grades | Passed |
| Generate Reports | Passed |
| Top Performer | Passed |
| Validation | Passed |

---

# 12. Challenges Faced

- Managing arrays
- Implementing grade logic
- Handling invalid input
- Calculating statistics

---

# 13. Future Improvements

- Database integration
- File handling
- GUI version
- Export reports

---

# 14. Conclusion

The Grade Management System successfully demonstrates Java programming concepts including arrays, loops, methods, validation, and report generation.

The project improved understanding of:
- Arrays
- Loops
- Exception handling
- Grade calculations
- Data processing
- Java project structure

---

# 15. Developed By

Amrit Chandan Mishra