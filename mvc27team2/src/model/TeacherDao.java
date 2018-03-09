/*나윤주*/
package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TeacherDao {
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultset;
	Teacher teacher;
	ArrayList<Teacher> list;
	
	/**
	 * teacher리스트 출력
	 * @param teacher
	 * @return 선생님 리스트
	 */
	public ArrayList<Teacher> selectTeacher() {
		try {
		//드라이버 로딩 DB연결
		connection = DriverDB.driverDB();
		//쿼리작성
		preparedStatement = connection.prepareStatement("SELECT teacher_no AS teacherNo teacher_id AS teacherId teacher_pw AS teacherPw FROM teacher");
		//쿼리실행
		resultset = preparedStatement.executeQuery();
		list = new ArrayList<Teacher>();
		//결과값을 리스트화
		while(resultset.next()){
			teacher = new Teacher();
			teacher.setTeacherNo(resultset.getInt("teacherNo"));
			teacher.setTeacherId(resultset.getNString("teacherId"));
			teacher.setTeacherPw(resultset.getString("teacherPw"));
			list.add(teacher);
			}
		//예외잡기
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		//실행종료
		} finally {
			if(resultset != null) try {resultset.close();}catch(SQLException e) {};
			if(preparedStatement != null)try {preparedStatement.close();}catch(SQLException e) {};
			if(connection != null) try {connection.close();}catch(SQLException e) {};
		}
		return list;
	}
	
	/**
	 * teacher 등록
	 * @param teacher
	 * @return 선생님 넘버(teacher_no)
	 */
	public int insertTeacher(Teacher teacher) {
		int result = 0;
		try {
			//드라이버 로딩 DB연결
			connection = DriverDB.driverDB();
			//쿼리작성
			preparedStatement = connection.prepareStatement("INSERT INTO teacher (teacher_id, teacher_pw) VALUES (?, ?)");
			preparedStatement.setString(1, teacher.getTeacherId());
			preparedStatement.setString(2, teacher.getTeacherPw());
			//쿼리실행
			result = preparedStatement.executeUpdate();
		//예외 잡기
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		//실행종료
		} finally {
			if(preparedStatement != null)try {preparedStatement.close();}catch(SQLException e) {};
			if(connection != null) try {connection.close();}catch(SQLException e) {};
		}
		return result;
	}
}