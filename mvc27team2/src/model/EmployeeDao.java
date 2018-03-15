/*배건혜*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDao {
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	Employee employee;
	ArrayList<Employee> list;
	/**
	 * 직원리스트출력
	 * @param employee
	 * @return 직원리스트
	 */
	public ArrayList<Employee> selectEmployeeList() {
		try {	
			//드라이버 연결, 로딩
			connection = DriverDB.driverDB();
			//쿼리 실행
			preparedStatement = connection.prepareStatement("SELECT employee_no AS employeeNo, employee_id AS employeeId FROM employee");
			resultSet = preparedStatement.executeQuery();
			
			list = new ArrayList<Employee>();
			while(resultSet.next()) {
				employee = new Employee();
				employee.setEmployeeNo(resultSet.getInt("employeeNo"));
				employee.setEmployeeId(resultSet.getString("employeeId"));
				list.add(employee);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			if(resultSet != null)try {resultSet.close();}catch(SQLException e) {};
			if(preparedStatement !=null) try{preparedStatement.close();} catch(SQLException e){}; 
			if(connection != null)try {connection.close();}catch (SQLException e) {};
				
			}
		
		
		
		return list;
		
	}
	/**
	 * 직원 등록
	 * @param employee
	 * @return  preparedStatement.executeUpdate();
	 */
	public int insertEmployee(Employee employee) {			
		int result = 0;
		try {	
			//드라이버 연결, 로딩
			connection = DriverDB.driverDB();
			//쿼리 실행
			preparedStatement = connection.prepareStatement("INSERT INTO employee(employee_id, employee_pw)VALUES (?, ?)");
			preparedStatement.setString(1, employee.getEmployeeId());
			preparedStatement.setString(2, employee.getEmployeePw());
			
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
