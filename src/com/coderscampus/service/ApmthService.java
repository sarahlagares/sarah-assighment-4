package com.coderscampus.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.coderscampus.student.Student;

public class ApmthService {

	public void apmthStudents() throws IOException {
		FileService fileService = new FileService(); // Use the FileService instance to load students

        // Create a CSV file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("course2.csv"))) {
            // Write the header to the file
            writer.write("Student ID, Student Name, Course, Grade\n");

            // Load students from the file using the FileService instance
            Student[] allStudents = fileService.loadStudentsFromFile("master-list-file.txt");

            // Iterate through the students and print only AMPTH students
            for (Student student : allStudents) {
            	// Print a message before the loop
            	System.out.println("Processing students...");
                if (student.getCourse().contains("APMTH ")) {
                    // Write the APMTH student details to the CSV file
                	writer.write(student + "\n");
                	// Print a message after processing a APMTH student
                    System.out.println("APMTH student found: " + student);
                }
            }
        } // Print a message after the loop
        System.out.println("Finished processing students.");
    }
}