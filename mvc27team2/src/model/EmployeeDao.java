/*배건혜*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDao {
	Connection connection;
	PreparedStatement prparedStatement;
	/**
	 * 직원 등록
	 * @param employee
	 * @return  prparedStatement.executeUpdate();
	 */
	public int insertEmployee(Employee employee) {			
		int result = 0;
		try {	
			//드라이버 연결, 로딩
			connection = DriverDB.driverDB();
			//쿼리 실행
			prparedStatement = connection.prepareStatement("INSERT INTO employee(employee_id, employee_pw)VALUES (?, ?)");
			prparedStatement.setString(1, employee.getEmployeeId());
			prparedStatement.setString(2, employee.getEmployeePw());
			
		result = prparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			if(prparedStatement !=null) try{prparedStatement.close();} catch(Exception e){}; 
				
			}
		return result;
	}
	
}
