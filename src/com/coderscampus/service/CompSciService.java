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

	public void compSciStudents() throws IOException {
		FileService printStudents = new FileService();

		//create a csv file
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
		
		//would I need a buffered reader?
		//Need to utilize method from File Service and filter the course part to print only compsci students
		if (printStudents.loadStudentsFromFile("master-list-file.txt").equals("COMPSCI")){
		      System.out.println();
			
			

			
				}
			
	
		}
	}

