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
	 * 선생님리스트출력
	 * @param teacher
	 * @return 선생님리스트
	 */
	public ArrayList<Teacher> selectTeacherList() {
		try {
			connection = DriverDB.driverDB();
			
			preparedStatement = connection.prepareStatement("SELECT teacher_no AS teacherNo,teacher_id AS teacherId FROM teacher");
			
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
