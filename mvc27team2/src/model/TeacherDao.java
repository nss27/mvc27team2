package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class TeacherDao {
	/**
	 * 선생님 리스트 카운트 메서드
	 * @return 선생님 리스트 카운트값
	 */
	public int countTeacherListAll() {
		System.out.println("선생님 리스트 카운트 메서드 호출");
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int result = 0;
		try {
			connection = DriverDB.driverDB();
			
			preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS countTeacherListAll FROM teacher");
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				result = resultSet.getInt("countTeacherListAll");
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
	 * 선생님 삭제 메서드
	 * @param teacherNo
	 * @return preparedStatement.executeUpdate
	 */
	public int deleteTeacher(int teacherNo) { //Teacher teacher로 매개변수 변경 가능.
		System.out.println("deleteTeacher dao실행");
		int teacherdelete=0;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = DriverDB.driverDB();
			
			preparedStatement = connection.prepareStatement("DELETE FROM teacher WHERE teacher_no=?");
			preparedStatement.setInt(1, teacherNo);
			
			teacherdelete = preparedStatement.executeUpdate();
			System.out.println(teacherdelete);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(preparedStatement != null)try {preparedStatement.close();}catch (SQLException e) {};
			if(connection != null)try {connection.close();}catch (SQLException e) {};
		}
		return teacherdelete;
	}
	
	/**
	 * 선생님 정보 수정 처리 메서드
	 * @param teacher
	 * @return preparedStatement.executeUpdate
	 */
	public int updateTeacher(Teacher teacher) {
		System.out.println("updateTeacher dao실행");
		int result = 0;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverDB.driverDB();
			
			preparedStatement = connection.prepareStatement("UPDATE teacher SET teacher_pw=? WHERE teacher_no=?");
			preparedStatement.setString(1, teacher.getTeacherPw());
			preparedStatement.setInt(2, teacher.getTeacherNo());
			
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
	
	/**
	 * 선생님한명 검색 메서드
	 * @param teacher
	 * @return preparedStatement.executeQuery
	 */
	
	public Teacher selectTeacherOne(int TeacherNo) {
		System.out.println("selectTeacherOne dao실행");	
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Teacher teacher = null;
		try {

			connection = DriverDB.driverDB();
			
			preparedStatement = connection.prepareStatement("SELECT teacher_no AS teacherNo,teacher_id AS teacherId, teacher_pw AS teacherPw FROM teacher WHERE teacher_no=?");
			preparedStatement.setInt(1, TeacherNo);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				teacher = new Teacher();
				teacher.setTeacherNo(resultSet.getInt("teacherNo"));
				teacher.setTeacherId(resultSet.getString("teacherId"));
				teacher.setTeacherPw(resultSet.getString("teacherPw"));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
		} finally {
			if(resultSet != null)try {resultSet.close();}catch(SQLException e) {};
			if(preparedStatement != null)try {preparedStatement.close();}catch (SQLException e) {};
			if(connection != null)try {connection.close();}catch (SQLException e) {};
		}
		return teacher;
	}
	/**
	 * 선생님 리스트 목록 카운트
	 * @return SELECT count(*) FROM teacher preparedStatement.executeUpdate();
	 */
	public int teacherRowCount() {
		System.out.println("teacherRowCount 실행");
		int count = 0;

		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = DriverDB.driverDB();
			
			preparedStatement = connection.prepareStatement("SELECT count(*) AS teacherRowCount FROM teacher");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("teacherRowCount쿼리결과확인 Gdao.java");
				count = resultSet.getInt("teacherRowCount");
			
			System.out.println("count:"+count);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			if(preparedStatement != null)try {preparedStatement.close();}catch (SQLException e) {};
			if(connection != null)try {connection.close();}catch (SQLException e) {};
		}
		
		return count;
	}
	
	/**
	 * 선생님리스트 메서드
	 * @param teacher
	 * @return preparedStatement.executeQuery
	 */
	public ArrayList<Teacher> selectTeacherList(int startRow,int pagePerRow) {
		System.out.println("selectTeacherList dao실행");	
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Teacher teacher;
		ArrayList<Teacher> list = null;
		try {
			connection = DriverDB.driverDB();
			
			preparedStatement = connection.prepareStatement("SELECT teacher_no AS teacherNo,teacher_id AS teacherId FROM teacher Limit ?,?");
			preparedStatement.setInt(1, startRow);
			preparedStatement.setInt(2, pagePerRow);
			resultSet = preparedStatement.executeQuery();
			
			list = new ArrayList<Teacher>();
			while(resultSet.next()) {
				teacher = new Teacher();
				teacher.setTeacherNo(resultSet.getInt("teacherNo"));
				teacher.setTeacherId(resultSet.getString("teacherId"));
				list.add(teacher);
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
	 * 선생님 등록
	 * @param teacher
	 * @return preparedStatement.executeUpdate()
	 */
	public int insertTeacher(Teacher teacher) {
		System.out.println("insertTeacher dao실행");	
		int result = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverDB.driverDB();
			
			preparedStatement = connection.prepareStatement("INSERT INTO teacher (teacher_id, teacher_pw) VALUES (?, ?)");
			preparedStatement.setString(1, teacher.getTeacherId());
			preparedStatement.setString(2, teacher.getTeacherPw());
			
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
