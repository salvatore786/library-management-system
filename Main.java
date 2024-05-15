import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[100]; // Array to store students, you can change the size as needed
        int studentCount = 0;

        while (true) {
            System.out.println("Student Management System Menu:");
            System.out.println("1. Add New Student");
            System.out.println("2. Display Student Details");
            System.out.println("3. Update Grades");
            System.out.println("4. Manage Attendance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.println("Adding a new student...");
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    System.out.print("Enter number of subjects: ");
                    int numSubjects = scanner.nextInt();
                    double[] grades = new double[numSubjects];
                    for (int i = 0; i < numSubjects; i++) {
                        System.out.print("Enter grade for subject " + (i + 1) + ": ");
                        grades[i] = scanner.nextDouble();
                    }
                    System.out.print("Enter attendance percentage: ");
                    int attendance = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    Student newStudent = new Student(name, rollNumber);
                    newStudent.setGrades(grades);
                    newStudent.setAttendance(attendance);

                    students[studentCount] = newStudent;
                    studentCount++;
                    System.out.println("Student added successfully!");
                    break;
                case 2:
                    System.out.println("Displaying student details...");
                    System.out.print("Enter roll number of the student: ");
                    int searchRollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    boolean found = false;
                    for (int i = 0; i < studentCount; i++) {
                        if (students[i].getRollNumber() == searchRollNumber) {
                            found = true;
                            System.out.println("Student Name: " + students[i].getName());
                            System.out.println("Roll Number: " + students[i].getRollNumber());
                            System.out.println("Grades: ");
                            double[] studentGrades = students[i].getGrades();
                            for (int j = 0; j < studentGrades.length; j++) {
                                System.out.println("Subject " + (j + 1) + ": " + studentGrades[j]);
                            }
                            System.out.println("Attendance: " + students[i].getAttendance() + "%");
                            System.out.println("Average Grade: " + students[i].calculateAverageGrade());
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found!");
                    }
                    break;
                case 3:
                    // Update grades
                    // Similar logic as case 1, but update grades instead of adding a new student
                    break;
                case 4:
                    // Manage attendance
                    // Similar logic as case 1, but update attendance instead of adding a new student
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static class Student {
        private String name;
        private int rollNumber;
        private double[] grades;
        private int attendance;

        public Student(String name, int rollNumber) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.grades = new double[5]; // Assuming 5 subjects
            this.attendance = 0;
        }

        public String getName() {
            return name;
        }

        public int getRollNumber() {
            return rollNumber;
        }

        public double[] getGrades() {
            return grades;
        }

        public void setGrades(double[] grades) {
            this.grades = grades;
        }

        public int getAttendance() {
            return attendance;
        }

        public void setAttendance(int attendance) {
            this.attendance = attendance;
        }

        public double calculateAverageGrade() {
            double sum = 0;
            for (double grade : grades) {
                sum += grade;
            }
            return sum / grades.length;
        }
    }
}
