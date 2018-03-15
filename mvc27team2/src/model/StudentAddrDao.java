/*나성수*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentAddrDao {
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	StudentAddr studentAddr;
	/**
	 * 학생 주소 등록 메서드
	 * @param studentAddr
	 * @return preparedStatement.executeUpdate
	 */
	public int insertStudentAddr(StudentAddr studentAddr) {
		int result = 0;
		try {
			connection = DriverDB.driverDB();
			
			preparedStatement = connection.prepareStatement("INSERT INTO student_addr (student_no, address) VALUES (?, ?)");
			preparedStatement.setInt(1, studentAddr.getStudentNo());
			preparedStatement.setString(2, studentAddr.getAddress());
			
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
