/*배건혜*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeAddrDao {
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	EmployeeAddr employeeAddr = null;
	ArrayList<EmployeeAddr> list;
	/**
	 * 직원 주소리스트 출력
	 * @return 직원 주소리스트
	 */
	public ArrayList<EmployeeAddr> selectEmployeeList() {
		try {	
			//드라이버 연결, 로딩
			connection = DriverDB.driverDB();
			//쿼리 실행
			preparedStatement = connection.prepareStatement("select employee_addr_no as employeeAddrNo, employee.employee_no as employeeNo, employee_id as employeeId, address from employee_addr left join employee on employee_addr.employee_no= employee.employee_no ORDER BY employee_addr.employee_addr_no ASC");
			resultSet = preparedStatement.executeQuery();
			
			list = new ArrayList<EmployeeAddr>();
			while(resultSet.next()) {
				employeeAddr = new EmployeeAddr();
				employeeAddr.setEmployeeAddrNo(resultSet.getInt("employeeAddrNo"));
				employeeAddr.setEmployeeNo(resultSet.getInt("employeeNo"));
				employeeAddr.setEmployeeId(resultSet.getString("employeeId"));
				employeeAddr.setAddress(resultSet.getString("address"));
				list.add(employeeAddr);
				
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
	 * 직원주소등록메서드
	 * @param employeeAddr
	 * @return
	 */
	public int insertEmployeeAddr(EmployeeAddr employeeAddr) {
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
