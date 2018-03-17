/*나성수*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentAddrDao {
	/**
	 * 학생 주소 하나 삭제하는 메서드
	 * @param studentAddrNo
	 * @return preparedStatement.executeUpdate
	 */
	public int deleteStudentAddrOne(int studentAddrNo) {
		System.out.println("학생 주소 하나 삭제하는 메서드 호출");
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = DriverDB.driverDB();

			preparedStatement = connection.prepareStatement("DELETE FROM student_addr where student_addr_no=?");
			preparedStatement.setInt(1, studentAddrNo);
			
			result = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(preparedStatement != null)try {preparedStatement.close();}catch (SQLException e) {};
			if(connection != null)try {connection.close();}catch (SQLException e) {};
		}
		
		return result;
	}
	/**
	 * 학생 주소 전체 삭제하는 메서드
	 * @param tableName
	 * @return preparedStatement.executeUpdate
	 */
	public int deleteStudentAddrAll(String tableName) {
		System.out.println("학생 주소 전체 삭제하는 메서드 호출");
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = DriverDB.driverDB();
			
			preparedStatement = connection.prepareStatement("DELETE FROM "+tableName);
			
			result = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(preparedStatement != null)try {preparedStatement.close();}catch (SQLException e) {};
			if(connection != null)try {connection.close();}catch (SQLException e) {};
		}
		
		return result;
	}
	/**
	 * 학생 주소 리스트 카운트 메서드
	 * @return 카운트 값
	 */
	public int countStudentAddrList() {
		System.out.println("학생 주소 리스트 카운트 메서드 호출");
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int result = 0;
		try {
			connection = DriverDB.driverDB();
			
			preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS countStudentAddrList FROM student_addr");
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				result = resultSet.getInt("countStudentAddrList");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(resultSet != null)try {resultSet.close();}catch(SQLException e) {};
			if(preparedStatement != null)try {preparedStatement.close();}catch (SQLException e) {};
			if(connection != null)try {connection.close();}catch (SQLException e) {};
		}
		
		return result;
	}
	/**
	 * 학생 주소 리스트 출력 메서드
	 * @return 학생 주소 리스트
	 */
	public ArrayList<StudentAddr> selectStudentAddrList() {
		System.out.println("학생 주소 리스트 출력 메서드 호출");
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		StudentAddr studentAddr = null;
		ArrayList<StudentAddr> list = null;
		try {
			connection = DriverDB.driverDB();
			/*
			 * student와 student_addr테이블을 조인한 이유는
			 * 학생 주소 등록 번호,학생 등록 번호,학생 아이디,학생 주소 값을 출력해서
			 * 리스트로 보여주기 위함이다
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
		System.out.println("학생 주소 등록 메서드 호출");
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
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(preparedStatement != null)try {preparedStatement.close();}catch (SQLException e) {};
			if(connection != null)try {connection.close();}catch (SQLException e) {};
		}
		return result;
	}
}
