package com.coderscampus.student;

public class Student {
	
	private String studentID;
	private String studentName;
	private  String course;
	private String grade;
    

    public String getStudentID() {
		return studentID;
	}


	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		Student.course = course;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public Student(String studentID, String studentName, String course, String grade) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.course = course;
        this.grade = grade;
    }
	public Student() {
		
	}


	@Override
	public String toString() {
		return studentID  + ", " + studentName + ", " + 
				course +  ", " + grade;
	}
	
	
}
