package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherAddrDao {
	/**
	 * 선생님 주소 정보 수정 처리 메서드
	 * @param teacherAddr
	 * @return preparedStatement.executeUpdate();
	 */
	
	public int updateTeacherAddr(TeacherAddr teacherAddr) {
		System.out.println("updateTeacherAddr 주소정보수정처리 dao실행");
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = DriverDB.driverDB();

			preparedStatement = connection.prepareStatement("UPDATE teacher_addr SET address=? WHERE teacher_addr_no = ?");
			preparedStatement.setString(1, teacherAddr.getAddress());
			preparedStatement.setInt(2, teacherAddr.getTeacherAddrNo());
			
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
	 * 선생님 한명 주소를 조회하는 메서드
	 * @param teacherAddrNo
	 * @return 선생님 한명의 주소
	 */
	
	public TeacherAddr selectTeacherAddrOne(int teacherAddrNo) {
		System.out.println("selectTeacherAddrOne 한명조회 dao실행");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		TeacherAddr teacherAddr = null;

		try{
			connection = DriverDB.driverDB();
			
			preparedStatement = connection.prepareStatement("SELECT teacher_addr_no AS teacherAddrNo,teacher_id AS teacherId,address FROM teacher JOIN teacher_addr ON teacher.teacher_no = teacher_addr.teacher_no WHERE teacher_addr.teacher_addr_no = ?");
			preparedStatement.setInt(1, teacherAddrNo);
			
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				teacherAddr = new TeacherAddr();
				teacherAddr.setTeacherAddrNo(resultSet.getInt("teacherAddrNo"));
				teacherAddr.setTeacherId(resultSet.getString("teacherId"));
				teacherAddr.setAddress(resultSet.getString("address"));
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			} finally {
				if(resultSet != null)try {resultSet.close();}catch(SQLException e) {};
				if(preparedStatement != null)try {preparedStatement.close();}catch (SQLException e) {};
				if(connection != null)try {connection.close();}catch (SQLException e) {};
			}
			return teacherAddr;
	}
	
	/**
	 * 선생님 주소 삭제하는 메서드
	 * @param teacherAddrNo
	 * @return preparedStatement.executeUpdate();
	 */
	public int deleteTeacherAddr(int teacherAddrNo) {
		System.out.println("deleteTeacherAddr 삭제 dao실행");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = DriverDB.driverDB();
			
			preparedStatement = connection.prepareStatement("DELETE FROM teacher_addr where teacher_addr_no=?");
			preparedStatement.setInt(1, teacherAddrNo);
			
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
	 * 선생님 주소 리스트 카운트 메서드
	 * @return resultSet.getInt("countTeacherAddrList")
	 */
	public int countTeacherAddrList(int teacherNo) {
		System.out.println("countTeacherAddrList 주소개수카운트 dao실행");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int result = 0;
		try {
			//db연결 및 실행
			connection = DriverDB.driverDB();
			//쿼리문 작성 및 실행
			preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS countTeacherAddrList FROM teacher_addr where teacher_no=?");
			//resultSet에 결과값을 담는다.
			preparedStatement.setInt(1, teacherNo);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				result = resultSet.getInt("countTeacherAddrList");
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
	 * 선생님 주소 리스트 출력
	 * @param teacherAddrList
	 * @return list
	 */
	
	public ArrayList<TeacherAddr> selectTeacherAddrList() {
		System.out.println("selectTeacherAddrList 리스트출력 dao실행");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		TeacherAddr teacherAddr = null;
		ArrayList<TeacherAddr> list = null;
		try {
			//db연결 및 실행
			connection = DriverDB.driverDB();
			/*
			 * select 구문 teacher 와 teacher_addr 내의 teacher_no, teacher_id, teacher_addr_no, teacher
			 */
			preparedStatement = connection.prepareStatement("SELECT teacher.teacher_no as teacherNo,teacher_addr_no as teacherAddrNo, teacher_id as teacherId, address FROM teacher JOIN teacher_addr ON teacher.teacher_no = teacher_addr.teacher_no ORDER BY teacher_addr_no ASC");
			//결과값을 resultSet에 담는다.
			resultSet = preparedStatement.executeQuery();
			// 리스트를 출력하기 위한 생성자 메서드
			list = new ArrayList<TeacherAddr>();
			while(resultSet.next()) {
				teacherAddr = new TeacherAddr();
				teacherAddr.setTeacherAddrNo(resultSet.getInt("teacherAddrNo"));
				teacherAddr.setTeacherNo(resultSet.getInt("teacherNo"));
				teacherAddr.setTeacherId(resultSet.getString("teacherId"));
				teacherAddr.setAddress(resultSet.getString("address"));
				//셋팅된 값을 list에 추가
				list.add(teacherAddr);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(resultSet != null)try {resultSet.close();}catch(SQLException e) {};
			if(preparedStatement != null)try {preparedStatement.close();}catch (SQLException e) {};
			if(connection != null)try {connection.close();}catch (SQLException e) {};
		}
		// 셋팅된 값이 추가된 list를 리턴
		return list;
	}	
	
	/**
	 * 선생님 주소 등록 메서드
	 * @param teacherAddr
	 * @return preparedStatement.executeUpdate
	 */
	
	public int insertTeacherAddr(TeacherAddr teacherAddr) {
		System.out.println("TeacherAddr 추가 dao실행");
		int result = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			//db연결 및 실행
			connection = DriverDB.driverDB();
			// 쿼리문 작성 및 실행.
			preparedStatement = connection.prepareStatement("INSERT INTO teacher_addr (teacher_no, address) VALUES (?,?)");
			preparedStatement.setInt(1, teacherAddr.getTeacherNo());
			preparedStatement.setString(2, teacherAddr.getAddress());
			// 결과값을 sql에 저장.
			result = preparedStatement.executeUpdate();
			System.out.println(result);
		//오류를 잡기위한 캐치절문
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		//파이널에서 connection과 preparedStatement를 닫아준다.
		} finally {
			if(preparedStatement != null)try {preparedStatement.close();}catch (SQLException e) {};
			if(connection != null)try {connection.close();}catch (SQLException e) {};
		}
		//결과값 리턴
		return result;
	}
}
