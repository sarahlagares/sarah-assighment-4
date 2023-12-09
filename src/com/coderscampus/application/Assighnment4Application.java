package com.coderscampus.application;

import java.io.IOException;
import com.coderscampus.service.ApmthService;
import com.coderscampus.service.CompSciService;
import com.coderscampus.service.StatService;

public class Assighnment4Application {

	public static void main(String[] args) throws IOException {

		CompSciService printCompSciStudents = new CompSciService();
		ApmthService printApmthStudents = new ApmthService();
		StatService printStatStudents = new StatService();

		printCompSciStudents.compSciStudents();
		printApmthStudents.apmthStudents();
		printStatStudents.statStudents();

	}
}
