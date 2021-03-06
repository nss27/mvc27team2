/*나성수*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentAddrDao {
	/**
	 * 검색된 학생 주소 리스트 카운트 메서드
	 * @return 검색된 학생 주소 리스트 카운트값
	 */
	public int countSearchStudentAddrList(String studentSelect,String studentSearch) {
		System.out.println("검색된 학생 주소 리스트 카운트 메서드 호출");
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int result = 0;
		try {
			connection = DriverDB.driverDB();
			
			preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS countStudentAddrListAll FROM student_addr");
			
			if(studentSelect.equals("studentId")) {
				preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS countSearchStudentAddrList FROM student join student_addr ON student.student_no = student_addr.student_no WHERE student_id=?");
				preparedStatement.setString(1, studentSearch);
			}else if(studentSelect.equals("address")) {
				preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS countSearchStudentAddrList FROM student join student_addr ON student.student_no = student_addr.student_no WHERE address=?");
				preparedStatement.setString(1, studentSearch);
			}else if(studentSelect.equals("studentNo")) {
				preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS countSearchStudentAddrList FROM student join student_addr ON student.student_no = student_addr.student_no WHERE student.student_no=?");
				preparedStatement.setInt(1, Integer.parseInt(studentSearch));
			}
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				result = resultSet.getInt("countSearchStudentAddrList");
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
	 * 학생 주소 리스트 카운트 메서드
	 * @return 학생 주소 리스트 카운트값
	 */
	public int countStudentAddrListAll() {
		System.out.println("학생 주소 리스트 카운트 메서드 호출");
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int result = 0;
		try {
			connection = DriverDB.driverDB();
			
			preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS countStudentAddrListAll FROM student_addr");
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				result = resultSet.getInt("countStudentAddrListAll");
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
	 * 학생 주소 리스트 검색 메서드
	 * @return 검색 결과(학생 주소 리스트)
	 */
	public ArrayList<StudentAddr> searchStudentAddrList(String studentSelect,String studentSearch,int startRow,int pagePerRow) {
		System.out.println("학생 주소 리스트 검색 메서드 호출");
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
			if(studentSelect.equals("studentId")) {
				preparedStatement = connection.prepareStatement("SELECT student_addr_no as studentAddrNo,student.student_no as studentNo,student_id as studentId,address FROM student join student_addr ON student.student_no = student_addr.student_no WHERE student_id=? ORDER BY student.student_no ASC LIMIT ?,?");
				preparedStatement.setString(1, studentSearch);
				preparedStatement.setInt(2, startRow);
				preparedStatement.setInt(3, pagePerRow);
			}else if(studentSelect.equals("address")) {
				preparedStatement = connection.prepareStatement("SELECT student_addr_no as studentAddrNo,student.student_no as studentNo,student_id as studentId,address FROM student join student_addr ON student.student_no = student_addr.student_no WHERE address=? ORDER BY student.student_no ASC LIMIT ?,?");
				preparedStatement.setString(1, studentSearch);
				preparedStatement.setInt(2, startRow);
				preparedStatement.setInt(3, pagePerRow);
			}else if(studentSelect.equals("studentNo")) {
				preparedStatement = connection.prepareStatement("SELECT student_addr_no as studentAddrNo,student.student_no as studentNo,student_id as studentId,address FROM student join student_addr ON student.student_no = student_addr.student_no WHERE student.student_no=? ORDER BY student.student_no ASC LIMIT ?,?");
				preparedStatement.setInt(1, Integer.parseInt(studentSearch));
				preparedStatement.setInt(2, startRow);
				preparedStatement.setInt(3, pagePerRow);
			}
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
	 * 학생 주소 정보 수정 처리 메서드
	 * @param studentAddr
	 * @return preparedStatement.executeUpdate
	 */
	public int updateStudentAddr(StudentAddr studentAddr) {
		System.out.println("학생 주소 정보 수정 처리 메서드 호출");
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = DriverDB.driverDB();

			preparedStatement = connection.prepareStatement("UPDATE student_addr SET address=? WHERE student_addr_no = ?");
			preparedStatement.setString(1, studentAddr.getAddress());
			preparedStatement.setInt(2, studentAddr.getStudentAddrNo());
			
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
	 * 학생 한명의 주소를 조회하는 메서드
	 * @param studentAddrNo
	 * @return 학생 한명의 주소
	 */
	public StudentAddr selectStudentAddrOne(int studentAddrNo) {
		System.out.println("학생 한명의 주소를 조회하는 메서드 호출");
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		StudentAddr studentAddr = null;
		try {
			connection = DriverDB.driverDB();

			preparedStatement = connection.prepareStatement("SELECT student_addr_no AS studentAddrNo,student_id AS studentId,address FROM student JOIN student_addr ON student.student_no = student_addr.student_no WHERE student_addr.student_addr_no = ?");
			preparedStatement.setInt(1, studentAddrNo);
			
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				studentAddr = new StudentAddr();
				studentAddr.setStudentAddrNo(resultSet.getInt("studentAddrNo"));
				studentAddr.setStudentId(resultSet.getString("studentId"));
				studentAddr.setAddress(resultSet.getString("address"));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(resultSet != null)try {resultSet.close();}catch(SQLException e) {};
			if(preparedStatement != null)try {preparedStatement.close();}catch (SQLException e) {};
			if(connection != null)try {connection.close();}catch (SQLException e) {};
		}
		return studentAddr;
	}
	/**
	 * 학생 주소 삭제하는 메서드
	 * @param studentAddrNo
	 * @return preparedStatement.executeUpdate
	 */
	public int deleteStudentAddr(int studentAddrNo) {
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
	 * 학생 한명의 주소 리스트 카운트 메서드
	 * @param studentNo
	 * @return 학생 한명의 주소 리스트 카운트
	 */
	public int countStudentAddrListOne(int studentNo) {
		System.out.println("학생 주소 리스트 카운트 메서드 호출");
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int result = 0;
		try {
			connection = DriverDB.driverDB();
			
			preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS countStudentAddrListOne FROM student_addr WHERE student_no = ?");
			preparedStatement.setInt(1, studentNo);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				result = resultSet.getInt("countStudentAddrListOne");
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
	 * @param startRow
	 * @param pagePerRow
	 * @return 학생 주소 리스트
	 */
	public ArrayList<StudentAddr> selectStudentAddrList(int startRow,int pagePerRow) {
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
			preparedStatement = connection.prepareStatement("SELECT student_addr_no as studentAddrNo,student.student_no as studentNo,student_id as studentId,address FROM student join student_addr ON student.student_no = student_addr.student_no ORDER BY student.student_no ASC LIMIT ?,?");
			preparedStatement.setInt(1, startRow);
			preparedStatement.setInt(2, pagePerRow);
			
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
