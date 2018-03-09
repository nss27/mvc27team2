/*나성수*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDao {
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	Student student;
	ArrayList<Student> list;
	/**
	 * 학생리스트출력
	 * @param student
	 * @return 학생리스트
	 */
	public ArrayList<Student> selectStudent() {
		try {
			connection = DriverDB.driverDB();
			
			preparedStatement = connection.prepareStatement("SELECT student_no AS studentNo,student_id AS studentId,student_pw AS studentPw FROM student");
			
			resultSet = preparedStatement.executeQuery();
			
			list = new ArrayList<Student>();
			while(resultSet.next()) {
				student = new Student();
				student.setStudentNo(resultSet.getInt("studentNo"));
				student.setStudentId(resultSet.getString("studentId"));
				student.setStudentPw(resultSet.getString("studentPw"));
				list.add(student);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(resultSet != null)try {resultSet.close();}catch(SQLException e) {};
			if(preparedStatement != null)try {preparedStatement.close();}catch (SQLException e) {};
			if(connection != null)try {connection.close();}catch (SQLException e) {};
		}
		
		return list;
	}
	/**
	 * 학생 등록
	 * @param student
	 * @return preparedStatement.executeUpdate()
	 */
	public int insertStudent(Student student) {
		int result = 0;
		try {
			connection = DriverDB.driverDB();
			
			preparedStatement = connection.prepareStatement("INSERT INTO student (student_id, student_pw) VALUES (?, ?)");
			preparedStatement.setString(1, student.getStudentId());
			preparedStatement.setString(2, student.getStudentPw());
			
			result = preparedStatement.executeUpdate();
			System.out.println(result);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(preparedStatement != null)try {preparedStatement.close();}catch (SQLException e) {};
			if(connection != null)try {connection.close();}catch (SQLException e) {};
		}
		
		return result;
	}
}
