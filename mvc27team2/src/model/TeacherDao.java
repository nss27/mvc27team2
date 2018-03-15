package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherDao {
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	Teacher teacher;
	ArrayList<Teacher> list;
	
	/**
	 * 선생님한명출력
	 * @param teacher
	 * @return 선생님한명데이터
	 */
	
	public Teacher selectTeacherOne(int TeacherNo) {
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
	 * 선생님리스트출력
	 * @param teacher
	 * @return 선생님리스트
	 */
	public ArrayList<Teacher> selectTeacherList() {
		try {
			connection = DriverDB.driverDB();
			
			preparedStatement = connection.prepareStatement("SELECT teacher_no AS teacherNo,teacher_id AS teacherId FROM teacher ORDER BY teacher_no ASC");
			
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
		int result = 0;
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
