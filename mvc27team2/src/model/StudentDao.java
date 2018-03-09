/*나성수*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDao {
	Connection connection;
	PreparedStatement preparedStatement;
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
