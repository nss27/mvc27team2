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
	 * @return 학생 넘버(student_no)
	 */
	public int insertStudent(Student student) {
		try {
			connection = DriverDB.driverDB();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
}
