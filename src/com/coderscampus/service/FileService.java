package com.coderscampus.service;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.coderscampus.student.Student;

public class FileService {

	
	public List<Student> loadStudentsFromFile(String fileName) throws IOException {
	

		List<Student> students = new ArrayList<>();

		try (BufferedReader fileReader = new BufferedReader(new FileReader("master-list-file.txt"))) {
			String data;

			// Read and parse the master file

			while ((data = fileReader.readLine()) != null) {
				String[] parts = data.split(",");
				String studentID = parts[0];
				String studentName = parts[1];
				String course = parts[2];
				String grade = parts[3];
				students.add(new Student(studentID, studentName, course, grade));
			}
		}
		return students;

	}		
	public static void main(String[] args) {
		FileService printStudents = new FileService(); 
		try {
			System.out.println(printStudents.loadStudentsFromFile("fileName"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
}
