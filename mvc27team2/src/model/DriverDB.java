/*나성수*/
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverDB {
	/**
	 * 드라이버로딩 및 DB연결
	 * @return connection주소값
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection driverDB() throws ClassNotFoundException, SQLException {
		System.out.println("드라이버 로딩 및 DB연결 driverDB 실행");
		Connection connection;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String jdbcAddr = "jdbc:mysql://localhost:3306/mvc?useUnicode=true&characterEncoding=utf8";
		String dbId = "root";
		String dbPw = "java0000";
		
		connection = DriverManager.getConnection(jdbcAddr, dbId, dbPw);
		
		return connection;
	}
}
