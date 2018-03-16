/*배건혜*/
package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.EmployeeDao;

@WebServlet("/getEmployeeListController.team2")
public class GetEmployeeListController extends HttpServlet {	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDao  employeeDao = new EmployeeDao();
		ArrayList<Employee> list = employeeDao.selectEmployeeList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/employee/getEmployeeList.jsp").forward(request,  response);
	}

}

