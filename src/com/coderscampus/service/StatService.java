package com.coderscampus.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.coderscampus.student.Student;

public class StatService {

	public void statStudents() throws IOException {
        FileService fileService = new FileService(); // Use the FileService instance to load students

        // Create a CSV file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("course3.csv"))) {
            // Write the header to the file
            writer.write("Student ID, Student Name, Course, Grade\n");

            // Load students from the file using the FileService instance
            Student[] allStudents = fileService.loadStudentsFromFile("master-list-file.txt");

            // Iterate through the students and print only STAT students
            for (Student student : allStudents) {
            	// Print a message before the loop
            	System.out.println("Processing students...");
                if (student.getCourse().contains("STAT")) {
                    // Write the STAT student details to the CSV file
                	writer.write(student + "\n");
                	// Print a message after processing a STAT student
                    System.out.println("STAT student found: " + student);
                }
            }
        } // Print a message after the loop
        System.out.println("Finished processing students.");
    }
}