/*나성수*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentAddrDao {
	/**
	 * 학생 주소 리스트 출력
	 * @return 학생 주소 리스트
	 */
	public ArrayList<StudentAddr> selectStudentAddrList() {
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		StudentAddr studentAddr = null;
		ArrayList<StudentAddr> list = null;
		try {
			connection = DriverDB.driverDB();
			/*
			 * student와 student_addr테이블을 조인하여
			 * 
			 */
			preparedStatement = connection.prepareStatement("SELECT student_addr_no as studentAddrNo,student.student_no as studentNo,student_id as studentId,address FROM student join student_addr ON student.student_no = student_addr.student_no ORDER BY student_addr_no ASC");
			
			resultSet = preparedStatement.executeQuery();
			
			list = new ArrayList<StudentAddr>();
			while(resultSet.next()) {
				studentAddr = new StudentAddr();
				studentAddr.setStudentAddrNo(resultSet.getInt("studentAddrNo"));
				studentAddr.setStudentNo(resultSet.getInt("studentNo"));
				studentAddr.setStudentId(resultSet.getString("studentId"));
				studentAddr.setAddress(resultSet.getString("address"));
				list.add(studentAddr);
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
	 * 학생 주소 등록 메서드
	 * @param studentAddr
	 * @return preparedStatement.executeUpdate
	 */
	public int insertStudentAddr(StudentAddr studentAddr) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
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
