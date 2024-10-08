package com.project.studentApp.dataAccess;
//4

import com.project.studentApp.model.Student;

public interface StudentDataInterface {

	public boolean insertStudent(Student s);

	public boolean delete(int roll);

	public boolean update(int roll, String update, int ch, Student s);

	// for percentage
	public boolean update(int roll, Double update, int ch, Student s);

	public void showAllStudents();

	public boolean showStudentByID(int roll);
}