package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeDao;

@WebServlet("/deleteEmployeeController.team2")
public class DeleteEmployeeController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		int employeeNo = Integer.parseInt(request.getParameter("employeeNo")); 
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.deleteEmployee(employeeNo);
		response.sendRedirect(request.getContextPath() + "/getEmployeeListController.team2");
	}

}
