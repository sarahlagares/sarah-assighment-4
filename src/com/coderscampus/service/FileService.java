package com.coderscampus.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import com.coderscampus.student.Student;

public class FileService {

	public Student[] loadStudentsFromFile(String fileName) throws IOException {

		Student[] students = new Student[100];
		try (BufferedReader fileReader = new BufferedReader(new FileReader("master-list-file.txt"))) {
			String data;

			fileReader.readLine();
			// Read and parse the master file
			int i = 0;
			while ((data = fileReader.readLine()) != null) {
				String[] parts = data.split(",");
				String studentID = parts[0];
				String studentName = parts[1];
				String course = parts[2];
				String grade = parts[3];
				students[i] = (new Student(studentID, studentName, course, grade));
				i++;
			}
		}
		return students;
	}

	public void writeStudentsToFile(Student[] students, String targetFileName, String fileName) {
		FileService fileService = new FileService(); // Use the FileService instance to load students
		//Create a CSV file
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(targetFileName))) {
			// Write the header to the file
			writer.write("Student ID, Student Name, Course, Grade\n");

			// Load students from the file using the FileService instance
			Student[] allStudents = fileService.loadStudentsFromFile(fileName);

			// Write the  student details to the CSV file
			for (Student student : allStudents) {
				if (student != null) {
					writer.write(student + "\n");
				}
			}	
		}	catch (IOException e) {
			e.printStackTrace();
		}
	}
}