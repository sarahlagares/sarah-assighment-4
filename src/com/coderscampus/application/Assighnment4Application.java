package com.coderscampus.application;

import java.io.IOException;
import com.coderscampus.service.ApmthService;
import com.coderscampus.service.CompSciService;
import com.coderscampus.service.FileService;
import com.coderscampus.service.StatService;
import com.coderscampus.service.StudentReportService;
import com.coderscampus.service.StudentService;

public class Assighnment4Application {

	public static void main(String[] args) throws IOException {

		StudentReportService reportService = new StudentReportService(new StudentService(), new FileService());
		reportService.generateStudentByCourseCSVReport("COMPSCI, "course1.csv");

	}
}
