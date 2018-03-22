/*배건혜*/
package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeAddrDao;
import model.EmployeeDao;

@WebServlet("/deleteEmployeeController.team2")
public class DeleteEmployeeController extends HttpServlet {
	private EmployeeDao employeeDao = null;
	private EmployeeAddrDao employeeAddrDao = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {	
		int employeeNo = Integer.parseInt(request.getParameter("employeeNo")); 
		int result = 0;
		
		employeeAddrDao = new EmployeeAddrDao();
		result = employeeAddrDao.countEmployeeAddrList(employeeNo);
		if(result == 0) {		
		employeeDao = new EmployeeDao();
		employeeDao.deleteEmployee(employeeNo);
		response.sendRedirect(request.getContextPath() + "/getEmployeeListController.team2");
		}else {
		response.sendRedirect(request.getContextPath() + "/getEmployeeListController.team2");	
		}
	}

}
