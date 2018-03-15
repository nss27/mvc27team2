/*배건혜*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeAddrDao {
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	EmployeeAddr employeeAddr = null;
	//직원 주소 등록
	public int insertEmployeeAddr(int employeeNo) {
		int result =0;
		try {	
			//드라이버 연결, 로딩
			connection = DriverDB.driverDB();
			//쿼리 실행
			preparedStatement = connection.prepareStatement("INSERT INTO employee_addr(employee_no, address) VALUES (?, ?)");
			preparedStatement.setInt(1,employeeAddr.getEmployeeNo());
			preparedStatement.setString(2,employeeAddr.getAddress());
			
		result = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			if(preparedStatement !=null) try{preparedStatement.close();} catch(SQLException e){}; 
			if(connection != null)try {connection.close();}catch (SQLException e) {};	
			}
		return result;
	}
}
