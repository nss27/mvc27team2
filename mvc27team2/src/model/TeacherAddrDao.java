package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherAddrDao {
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	TeacherAddr teacherAddr;
	ArrayList<TeacherAddr> list;
	
	/**
	 * 선생님 주소 리스트 출력
	 * @param teacherAddrList
	 * @return list
	 */
	
	public ArrayList<TeacherAddr> selectTeacherList() {
		try {
			connection = DriverDB.driverDB();
			
			preparedStatement = connection.prepareStatement("SELECT teacher.teacher_no as teacherNo,teacher_addr_no as teacherAddrNo, teacher_id as teacherId, address FROM teacher RIGHT JOIN teacher_addr ON teacher.teacher_no = teacher_addr.teacher_no ORDER BY teacher_addr_no ASC");
			
			resultSet = preparedStatement.executeQuery();
			
			list = new ArrayList<TeacherAddr>();
			while(resultSet.next()) {
				teacherAddr = new TeacherAddr();
				teacherAddr.setTeacherAddrNo(resultSet.getInt("teacherAddrNo"));
				teacherAddr.setTeacherNo(resultSet.getInt("teacherNo"));
				teacherAddr.setTeacherId(resultSet.getNString("teacherId"));
				teacherAddr.setAddress(resultSet.getString("address"));
				list.add(teacherAddr);
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
