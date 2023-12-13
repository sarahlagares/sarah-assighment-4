package com.coderscampus.service;

import com.coderscampus.student.Student;

public class StudentReportService {

	private StudentService studentService;
	private FileService fileService;

	public StudentReportService(StudentService studentService, FileService fileService) {
		this.studentService = studentService;
		this.fileService = fileService;
	}

	public void generateStudentByCourseCSVReport(String courseKey, String targetFilename) {
		Student[] students = studentService.getStudents();

		Student[] courseStudents = filterStudentByCourse(students, courseKey);

		fileService.writeStudentsToFile();
	}
	
	private Student[] filterStudentByCourse(Student[] students, String courseKey) {
		Student[] courseStudents = new Student[students.length];
		int studeCtr = 0;
		
		for (Student student : students) {
			if (student.getCourse().contains(courseKey)) {
				courseStudents[studeCtr++] = student;
			}
		}
		return courseStudents;
	}
	
	
}
