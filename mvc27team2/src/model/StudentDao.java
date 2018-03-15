/*나성수*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDao {
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	Student student;
	ArrayList<Student> list;
	public int deleteStudent(int studentNo) {
		int result = 0;
		try {
			connection = DriverDB.driverDB();
			
			preparedStatement = connection.prepareStatement("DELETE FROM student WHERE student_no=?");
			preparedStatement.setInt(1, studentNo);
			
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
	 * 학생 정보 수정 처리 메서드
	 * @param student
	 * @return preparedStatement.executeUpdate()
	 */
	public int updateStudent(Student student) {
		int result = 0;
		try {
			connection = DriverDB.driverDB();
			
			preparedStatement = connection.prepareStatement("UPDATE student	SET student_pw=? WHERE student_no = ?");
			preparedStatement.setString(1, student.getStudentPw());
			preparedStatement.setInt(2, student.getStudentNo());
			
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
	 * 학생한명의 데이터 출력
	 * @return 학생 한명의 데이터
	 */
	public Student selectStudentOne(int studentNo) {
		try {
			connection = DriverDB.driverDB();
			
			preparedStatement = connection.prepareStatement("SELECT student_no AS studentNo,student_id AS studentId,student_pw AS studentPw FROM student WHERE student_no = ?");
			preparedStatement.setInt(1, studentNo);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				student = new Student();
				student.setStudentNo(resultSet.getInt("studentNo"));
				student.setStudentId(resultSet.getString("studentId"));
				student.setStudentPw(resultSet.getString("studentPw"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(resultSet != null)try {resultSet.close();}catch(SQLException e) {};
			if(preparedStatement != null)try {preparedStatement.close();}catch (SQLException e) {};
			if(connection != null)try {connection.close();}catch (SQLException e) {};
		}
		return student;
	}
	/**
	 * 학생리스트출력
	 * @param student
	 * @return 학생리스트
	 */
	public ArrayList<Student> selectStudentList() {
		try {
			connection = DriverDB.driverDB();
			
			preparedStatement = connection.prepareStatement("SELECT student_no AS studentNo,student_id AS studentId FROM student ORDER BY student_no ASC");
			
			resultSet = preparedStatement.executeQuery();
			
			list = new ArrayList<Student>();
			while(resultSet.next()) {
				student = new Student();
				student.setStudentNo(resultSet.getInt("studentNo"));
				student.setStudentId(resultSet.getString("studentId"));
				list.add(student);
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
	 * 학생 등록
	 * @param student
	 * @return preparedStatement.executeUpdate()
	 */
	public int insertStudent(Student student) {
		int result = 0;
		try {
			connection = DriverDB.driverDB();
			
			preparedStatement = connection.prepareStatement("INSERT INTO student (student_id, student_pw) VALUES (?, ?)");
			preparedStatement.setString(1, student.getStudentId());
			preparedStatement.setString(2, student.getStudentPw());
			
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
