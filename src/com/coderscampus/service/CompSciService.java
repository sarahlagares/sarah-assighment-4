package com.coderscampus.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.coderscampus.student.Student;
import com.coderscampus.service.FileService;

public class CompSciService {

	public void printCompSciStudents() throws IOException {
		FileService printStudents = new FileService();

		BufferedWriter writer = null;
		// Specify the file name
		try {
			writer = new BufferedWriter(new FileWriter("course1.cvs"));
			// Write the header to the file
			writer.write("Student ID, Student Name, Course, Grade\n");
		} finally {
			if (writer != null)
				writer.close();
		}

		try (BufferedReader fileReader = new BufferedReader(new FileReader("master-list-file.txt"))) {
			// Iterate over the students and write COMPSCI students to the file
			Student[] students = printStudents.loadStudentsFromFile("fileName");

			for (Student student : students) {
				if (Student.getCourse().equals("COMPSCI")) {
					// Write the student information to the file
					System.out.println(student);
				}
			}
		}
	}
}
