/*배건혜*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeAddrDao {
	public ArrayList<EmployeeAddr> searchEmployeeAddrList(String employeeSelect,String employeeSearch){
		System.out.println("직원 주소 리스트 검색 메서드 호출");
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		EmployeeAddr employeeAddr = null;
		ArrayList<EmployeeAddr> list = null;
		try {	
			//드라이버 연결, 로딩
			connection = DriverDB.driverDB();
			if(employeeSelect.equals("employeeId")) {
				preparedStatement = connection.prepareStatement("select employee_addr_no as employeeAddrNo, employee.employee_no as employeeNo, employee_id as employeeId, address from employee join employee_addr on  employee.employee_no= employee_addr.employee_no where employee_id=? ORDER BY employee.employee_no ASC");
				preparedStatement.setString(1, employeeSearch);
			}else if(employeeSelect.equals("address")) {
				preparedStatement = connection.prepareStatement("select employee_addr_no as employeeAddrNo, employee.employee_no as employeeNo, employee_id as employeeId, address from employee join employee_addr on  employee.employee_no= employee_addr.employee_no where address=? ORDER BY employee.employee_no ASC");
				preparedStatement.setString(1, employeeSearch);
			}else if(employeeSelect.equals("employeeNo")) {
				preparedStatement = connection.prepareStatement("select employee_addr_no as employeeAddrNo, employee.employee_no as employeeNo, employee_id as employeeId, address from employee join employee_addr on  employee.employee_no= employee_addr.employee_no where employee.employee_no=? ORDER BY employee.employee_no ASC");
				preparedStatement.setInt(1, Integer.parseInt(employeeSearch));
			}
			
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
	 * 직원 주소 정보 수정 처리 메서드
	 * @param employeeAddr
	 * @return
	 */
	public int updateEmployeeAddr(EmployeeAddr employeeAddr) {
		System.out.println("직원 주소 정보수정 처리 메서드 호출");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = DriverDB.driverDB();

			preparedStatement = connection.prepareStatement("UPDATE employee_addr SET address=? WHERE employee_addr_no=?");
			preparedStatement.setString(1, employeeAddr.getAddress());
			preparedStatement.setInt(2, employeeAddr.getEmployeeAddrNo());
			
			result = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(preparedStatement != null)try {preparedStatement.close();}catch (SQLException e) {};
			if(connection != null)try {connection.close();}catch (SQLException e) {};
		}	
		return result;
	
	}
	/**
	 * 직원 한명의 주소를 조회하는 메서드
	 * @param employeeAddrNo
	 * @return 직원 한명의 주소
	 */
	public EmployeeAddr selectEmployeeAddrOne(int employeeAddrNo) {
		System.out.println("직원 한명의 주소를 조회하는 메서드 호출");
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		EmployeeAddr employeeAddr = null;
		try {
			connection = DriverDB.driverDB();

			preparedStatement = connection.prepareStatement("SELECT employee_addr_no AS employeeAddrNo,employee_id AS employeeId,address FROM employee JOIN employee_addr ON employee.employee_no = employee_addr.employee_no WHERE employee_addr.employee_addr_no = ?");
			preparedStatement.setInt(1, employeeAddrNo);
			
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				employeeAddr = new EmployeeAddr();
				employeeAddr.setEmployeeAddrNo(resultSet.getInt("employeeAddrNo"));
				employeeAddr.setEmployeeId(resultSet.getString("employeeId"));
				employeeAddr.setAddress(resultSet.getString("address"));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(resultSet != null)try {resultSet.close();}catch(SQLException e) {};
			if(preparedStatement != null)try {preparedStatement.close();}catch (SQLException e) {};
			if(connection != null)try {connection.close();}catch (SQLException e) {};
		}
		return employeeAddr;
	}
	/**
	 * 직원 주소 삭제하는 메서드
	 * @param employeeAddrNo
	 * @return preparedStatement.executeUpdate
	 */
	public int deleteEmployeeAddr(int employeeAddrNo) {
		System.out.println("직원 주소 하나 삭제하는 메서드 호출");
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = DriverDB.driverDB();

			preparedStatement = connection.prepareStatement("DELETE FROM employee_addr where employee_addr_no=?");
			preparedStatement.setInt(1, employeeAddrNo);
			
			result = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(preparedStatement != null)try {preparedStatement.close();}catch (SQLException e) {};
			if(connection != null)try {connection.close();}catch (SQLException e) {};
		}	
		return result;
	}
	
	/**
	 * 직원 주소 리스트 카운트 메서드
	 * @return 카운트 값
	 */
	public int countEmployeeAddrList(int employeeNo) {
		System.out.println("직원 주소 리스트 카운트 메서드 호출");
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int result = 0;
		try {
			connection = DriverDB.driverDB();
			
			preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS countEmployeeAddrList FROM employee_addr WHERE employee_no=?");
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				result = resultSet.getInt("countEmployeeAddrList");
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
	 * 직원 주소리스트 출력 메서드
	 * @return 직원 주소리스트
	 */
	public ArrayList<EmployeeAddr> selectEmployeeAddrList() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		EmployeeAddr employeeAddr = null;
		ArrayList<EmployeeAddr> list = null;
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
	 * @return preparedStatement.executeUpdate
	 */
	public int insertEmployeeAddr(EmployeeAddr employeeAddr) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;		
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
