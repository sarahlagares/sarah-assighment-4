package com.coderscampus.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StatService {

	
	public void statStudents() throws IOException {
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
	}
}
