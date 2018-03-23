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
	private EmployeeDao employeeDao = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		
		int pagePerRow = 10;
		int currentPage = 1;//요청 페이지에서 받을 수도 있다.
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		
		int startRow = (currentPage-1)*pagePerRow;
		
		
		employeeDao = new EmployeeDao();
		ArrayList<Employee> list = employeeDao.selectEmployeeList(startRow,pagePerRow);
		
		int totalRowCount = employeeDao.employeeRowCount();
		int lastPage = totalRowCount/pagePerRow;
		if(totalRowCount % pagePerRow !=0) {
			lastPage++;
		}
		request.setAttribute("list", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage", lastPage);
		request.getRequestDispatcher("/WEB-INF/views/employee/getEmployeeList.jsp").forward(request,  response);
	}

}

