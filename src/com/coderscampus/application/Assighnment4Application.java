package com.coderscampus.application;

import java.io.IOException;
import java.util.List;

import com.coderscampus.service.FileService;
import com.coderscampus.student.Student;

public class Assighnment4Application {

	public static void main(String[] args) {
		FileService printStudents = new FileService();
		try {
			List<Student> students = printStudents.loadStudentsFromFile("fileName");
			for (Student student : students) {
				System.out.println(student);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
