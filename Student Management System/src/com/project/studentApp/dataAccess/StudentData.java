package com.project.studentApp.dataAccess;

//5

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.project.studentApp.dataBase.DataBaseConnection;
import com.project.studentApp.model.Student;

public class StudentData implements StudentDataInterface {

	@Override
	public boolean insertStudent(Student studentDetails) {

		boolean flag = false;

		try {
			Connection con = DataBaseConnection.createConnetion();

			String query = "INSERT INTO student_details(rollNum,studentName,collegeName,City,Percentage) VALUES(?,?,?,?,?);";

			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1, studentDetails.getRollNum());
			pst.setString(2, studentDetails.getName());
			pst.setString(3, studentDetails.getCollegeName());
			pst.setString(4, studentDetails.getCityName());
			pst.setDouble(5, studentDetails.getPercentage());

			pst.executeUpdate();

			// if record inserted sucessfully,then the flag will become true,
			// and in (result flag) become true ah irukarathu naala ithu
			/*
			 * User class la if(result) ku poogum boolean
			 * result=accessObj.insertStudent(stu); if(result) {
			 * System.out.println("Record added sucessfully...");
			 * 
			 * //in (result flag) become false ah iruntha else ku poogum
			 * 
			 * }else { System.out.println("Something went Wrong! Please try again"); }
			 */
			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public boolean delete(int roll) {

		boolean flag = false;
		try {
			Connection con = DataBaseConnection.createConnetion();
			String query = "DELETE FROM student_details WHERE rollNum=" + roll;

			PreparedStatement pst = con.prepareStatement(query);
			pst.executeUpdate();

			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public boolean update(int roll, String update, int ch, Student s) {

		int choice = ch;
		boolean flag = false;

		try {

			/*
			 * update name
			 */
			if (choice == 1) {
				Connection con = DataBaseConnection.createConnetion();

				String query = "UPDATE student_details SET studentName=? WHERE rollNum=?";

				PreparedStatement pst = con.prepareStatement(query);

				pst.setString(1, update);
				pst.setInt(2, roll);
				pst.executeUpdate();

				flag = true;
			}

			/*
			 * update colegename
			 */
			if (choice == 2) {
				Connection con = DataBaseConnection.createConnetion();

				String query = "UPDATE student_details SET collegeName=? WHERE rollNum=?";

				PreparedStatement pst = con.prepareStatement(query);

				pst.setString(1, update);
				pst.setInt(2, roll);
				pst.executeUpdate();

				flag = true;
			}

			/*
			 * update cityname
			 */
			if (choice == 3) {
				Connection con = DataBaseConnection.createConnetion();

				String query = "UPDATE student_details SET city=? WHERE rollNum=?";

				PreparedStatement pst = con.prepareStatement(query);

				pst.setString(1, update);
				pst.setInt(2, roll);
				pst.executeUpdate();

				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public boolean update(int roll, Double update, int ch, Student s) {

		/*
		 * update percentage
		 */
		int choice = ch;
		boolean flag = false;
		try {
			if (choice == 4) {
				Connection con = DataBaseConnection.createConnetion();

				String query = "UPDATE student_details SET Percentage=? WHERE rollNum=?";

				PreparedStatement pst = con.prepareStatement(query);

				pst.setDouble(1, update);
				pst.setInt(2, roll);
				pst.executeUpdate();

				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public void showAllStudents() {

		try {

			Connection con = DataBaseConnection.createConnetion();

			String query = "SELECT * FROM student_details";

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				System.out.println("Rollnumber: " + rs.getInt(1) + "\nName: " + rs.getString(2) + "\nCollege Name: "
						+ rs.getString(3) + "\nCity: " + rs.getString(4) + "\nPercentage: " + rs.getDouble(5));
				System.out.println("____________________________________");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean showStudentByID(int roll) {

		try {

			Connection con = DataBaseConnection.createConnetion();

			String query = "SELECT * FROM student_details WHERE rollNum=" + roll;

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				System.out.println("Rollnumber: " + rs.getInt(1) + "\nName: " + rs.getString(2) + "\nCollege Name: "
						+ rs.getString(3) + "\nCity: " + rs.getString(4) + "\nPercentage: " + rs.getDouble(5));
				System.out.println("____________________________________");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}