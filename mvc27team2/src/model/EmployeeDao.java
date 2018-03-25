/*배건혜*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDao {
	/**
	 * 직원 리스트 카운트 메서드
	 * @return 직원 리스트 카운트값
	 */
	public int countEmployeeListAll() {
		System.out.println("직원 리스트 카운트 메서드 호출");
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int result = 0;
		try {
			connection = DriverDB.driverDB();
			
			preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS countEmployeeListAll FROM employee");
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				result = resultSet.getInt("countEmployeeListAll");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(resultSet != null)try {resultSet.close();}catch(SQLException e) {};
			if(preparedStatement != null)try {preparedStatement.close();}catch (SQLException e) {};
			if(connection != null)try {connection.close();}catch (SQLException e) {};
		}
		
		return result;
	}
	/**
	 * 직원 삭제 처리 메서드
	 * @param employeeNo
	 * @return preparedStatement.executeUpdate
	 */
	
	public int deleteEmployee(int employeeNo) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {	
			//드라이버 연결, 로딩
			connection = DriverDB.driverDB();
			//쿼리 실행
			preparedStatement = connection.prepareStatement("DELETE FROM employee WHERE employee_no=?");
			preparedStatement.setInt(1, employeeNo);
			
			result = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			if(preparedStatement !=null) try{preparedStatement.close();} catch(SQLException e){}; 
			if(connection != null)try {connection.close();}catch (SQLException e) {};	
			}
		return result;	
	}
	
	/**
	 * 직원 정보 수정 처리 메서드 
	 * @param employee
	 * @return preparedStatement.executeUpdate();
	 */
	public int updateEmployee(Employee employee) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {	
			//드라이버 연결, 로딩
			connection = DriverDB.driverDB();
			//쿼리 실행
			preparedStatement = connection.prepareStatement("UPDATE employee SET employee_pw=? WHERE employee_no=?");
			preparedStatement.setString(1, employee.getEmployeePw());
			preparedStatement.setInt(2, employee.getEmployeeNo());
			
			result = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			if(preparedStatement !=null) try{preparedStatement.close();} catch(SQLException e){}; 
			if(connection != null)try {connection.close();}catch (SQLException e) {};	
			}	
		return result;		
	}
	
	/**
	 * 직원한명 데이터 출력 메서드
	 * @return 직원한명의 데이터
	 */
	public Employee selectEmployeeOne(int employeeNo ) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Employee employee = null;
		try {	
			//드라이버 연결, 로딩
			connection = DriverDB.driverDB();
			//쿼리 실행
			preparedStatement = connection.prepareStatement("SELECT employee_no AS employeeNo, employee_id AS employeeId, employee_pw AS employeePw FROM employee Where employee_no = ?");
			preparedStatement.setInt(1, employeeNo);
			resultSet = preparedStatement.executeQuery();
	
			while(resultSet.next()) {
				employee = new Employee();
				employee.setEmployeeNo(resultSet.getInt("employeeNo"));
				employee.setEmployeeId(resultSet.getString("employeeId"));
				employee.setEmployeePw(resultSet.getString("employeePw"));
				
			}
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			if(resultSet != null)try {resultSet.close();}catch(SQLException e) {};
			if(preparedStatement !=null) try{preparedStatement.close();} catch(SQLException e){}; 
			if(connection != null)try {connection.close();}catch (SQLException e) {};
				
		}		
		return employee;
	}
	
	/**
	 * 직원리스트출력 메서드
	 * @param employee
	 * @return 직원리스트
	 */
public int employeeRowCount() {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	ArrayList<Employee> list = null;
	
	int count = 0;
	/*
	 * SELECT count(*) FROM employee
	 */
	
	try {	
		//드라이버 연결, 로딩
		connection = DriverDB.driverDB();
		//쿼리 실행
		preparedStatement = connection.prepareStatement("SELECT count(*) FROM ORDER BY employee_no ASC ");
		resultSet = preparedStatement.executeQuery();
		list = new ArrayList<Employee>();
		while(resultSet.next()) {
			count = resultSet.getInt("employeeRowCount"); 
			
		}
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}finally {
		if(resultSet != null)try {resultSet.close();}catch(SQLException e) {};
		if(preparedStatement !=null) try{preparedStatement.close();} catch(SQLException e){}; 
		if(connection != null)try {connection.close();}catch (SQLException e) {};
			
		}	
	return count;
}
	
/*
 * 매개변수 int startRow - > select 결과물의 시작행
 * 매개변수 int pagePerRow-> select 결과물의 갯수
 * return : EmployeeList
 */
	public ArrayList<Employee> selectEmployeeList(int startRow, int pagePerRow) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Employee> list = null;
		try {	
			//드라이버 연결, 로딩
			connection = DriverDB.driverDB();
			//쿼리 실행
			preparedStatement = connection.prepareStatement("SELECT employee_no AS employeeNo, employee_id AS employeeId FROM employee LIMIT ?,? ORDER BY employee_no ASC ");
			resultSet = preparedStatement.executeQuery();
			preparedStatement.setInt(1, startRow);
			preparedStatement.setInt(2, pagePerRow);
			list = new ArrayList<Employee>();
			while(resultSet.next()) {
				Employee employee = new Employee();
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
	 * 직원 등록 메서드
	 * @param employee
	 * @return  preparedStatement.executeUpdate();
	 */
	public int insertEmployee(Employee employee) {	
		Connection connection = null;
		PreparedStatement preparedStatement = null;
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
