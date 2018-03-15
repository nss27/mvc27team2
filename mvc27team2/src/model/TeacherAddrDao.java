package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherAddrDao {
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	TeacherAddr teacherAddr;
	
	/**
	 * 선생님 주소 등록 메서드
	 * @param teacherAddr
	 * @return preparedStatement.executeUpdate
	 */
	
	public int insertTeacherAddr(TeacherAddr teacherAddr) {
		
		int result = 0;
		try {
			
			connection = DriverDB.driverDB();
			
			preparedStatement = connection.prepareStatement("INSERT INTO teacher_addr (teacher_no, address) VALUES (?,?)");
			preparedStatement.setInt(1, teacherAddr.getTeacherNo());
			preparedStatement.setString(2, teacherAddr.getAddress());
			
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
