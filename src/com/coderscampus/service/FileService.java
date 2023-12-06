package com.coderscampus.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.coderscampus.student.Student;

public class FileService {

	public Student []loadStudentsFromFile(String fileName) throws IOException {


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
	
}
