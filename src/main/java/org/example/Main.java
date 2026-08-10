package org.example;

import java.util.Scanner;

public class Main {

    public static char getLetterGrade(int grade) {
        if (grade >= 85)
            return 'A';
        else if (grade >= 75)
            return 'B';
        else if (grade >= 65)
            return 'C';
        else if (grade >= 50)
            return 'D';
        else
            return 'F';
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] studentNames = new String[5];
        int[][] grades = new int[5][3];

        for (int i = 0; i < studentNames.length; i++) {
            System.out.print("Enter student " + (i + 1) + " name: ");
            studentNames[i] = scanner.nextLine();
        }

        for (int i = 0; i < grades.length; i++) {

            System.out.println("\nEnter grades for " + studentNames[i]);

            for (int j = 0; j < grades[i].length; j++) {

                while (true) {

                    System.out.print("Subject " + (j + 1) + ": ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid grade.");
                        scanner.next();
                        continue;
                    }

                    int grade = scanner.nextInt();

                    if (grade < 0 || grade > 100) {
                        System.out.println("Invalid grade.");
                    } else {
                        grades[i][j] = grade;
                        break;
                    }
                }
            }
        }

        int option;

        do {

            System.out.println("\n========== MENU ==========");
            System.out.println("1. Show All Student Names");
            System.out.println("2. Show All Student Grades");
            System.out.println("3. Search Student by Name");
            System.out.println("4. Count Passed Students");
            System.out.println("0. Exit");

            System.out.print("Choose an option: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid option.");
                scanner.next();
                System.out.print("Choose an option: ");
            }

            option = scanner.nextInt();

            switch (option) {

                case 1:

                    System.out.println("\nStudents:");

                    for (String student : studentNames) {
                        System.out.println(student);
                    }
                    break;

                case 2:

                    System.out.println();
                    for (int i = 0; i < studentNames.length; i++) {

                        System.out.print(studentNames[i] + ": ");

                        for (int j = 0; j < grades[i].length; j++) {
                            System.out.print(grades[i][j] + " ");
                        }

                        System.out.println();
                    }
                    break;

                case 3:
                    scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    boolean found = false;
                    for (int i = 0; i < studentNames.length; i++) {
                        if (name.equalsIgnoreCase(studentNames[i])) {
                            found = true;
                            System.out.print(studentNames[i] + ": ");
                            for (int j = 0; j < grades[i].length; j++) {
                                System.out.print(grades[i][j] + " ");
                            }
                            System.out.println();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    int passed = 0;
                    for (int i = 0; i < grades.length; i++) {
                        int total = 0;
                        for (int j = 0; j < grades[i].length; j++) {
                            total += grades[i][j];
                        }
                        double average = total / 3.0;
                        if (average >= 50) {
                            passed++;
                        }
                    }
                    System.out.println("Passed Students = " + passed);
                    break;

                case 0:

                    System.out.println("Program terminated.");
                    break;

                default:

                    System.out.println("Invalid menu option.");
            }

        } while (option != 0);

        scanner.close();
    }
}