/*나윤주*/
package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class TeacherDao {
	Connection connection;
	PreparedStatement preparedStatement;
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
		} finally {
			if(preparedStatement != null)try {preparedStatement.close();}catch(SQLException e) {};
			if(connection != null) try {connection.close();}catch(SQLException e) {};
		}
		return result;
	}
}