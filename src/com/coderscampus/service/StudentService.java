package com.coderscampus.service;

import com.coderscampus.student.Student;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class StudentService {

	private Student[] students;
	
	private final String FILENAME = "master-file-list.txt";
	
	public StudentService() {
		loadStudents();
		sortStudentsByGradeDesc();
	}
	
	public Student[] getStudents() {
		return students;
	}
	
	private void loadStudents() {
		FileService fileService = new FileService();
		try {
		students = fileService.loadStudentsFromFile(FILENAME);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void sortStudentsByGradeDesc() {
		Arrays.sort(students, new Comparator<Student>() {

			@Override
			public int compare(Student student1, Student student2) {
				// Handle null cases
				String grade1 = student1 != null ? student1.getGrade() : null;
				String grade2 = student2 != null ? student2.getGrade() : null;

				// Compare grades, handling nulls
				if (grade1 == null && grade2 == null) {
					return 0; 
				} else if (grade1 == null) {
					return 1; 
				} else if (grade2 == null) {
					return -1;
				} else {
					// Compare non-null grades
					return grade2.compareTo(grade1); // Reverse order for descending
				}
			}
		});
		
}	
}	

