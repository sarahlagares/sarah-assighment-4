package com.coderscampus.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

				// Sort the array in descending order based on Grade
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
		return students;
	}
}
