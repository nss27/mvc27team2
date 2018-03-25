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
import model.EmployeeAddr;
import model.EmployeeAddrDao;
import model.EmployeeDao;
import model.PageMaker;
import model.Student;
import model.StudentAddr;
import model.StudentAddrDao;

@WebServlet("/getEmployeeListController.team2")
public class GetEmployeeListController extends HttpServlet {
	private EmployeeDao employeeDao = null;
	private EmployeeAddrDao employeeAddrDao = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		employeeDao = new EmployeeDao();
		employeeAddrDao = new EmployeeAddrDao();
		int totalCurrentPage = 1;
		if(request.getParameter("currentPage") != null) {
			totalCurrentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int totalCount  = employeeDao.countEmployeeListAll();
		int cutRow = 5;
		PageMaker pageMaker = new PageMaker(totalCount, cutRow, totalCurrentPage);
		
		ArrayList<Integer> pageNumber = new ArrayList<Integer>();
		for(int number = pageMaker.getStartPage(); number<=pageMaker.getEndPage(); number++) {
			pageNumber.add(number);
		}
		
		ArrayList<Employee> list = employeeDao.selectEmployeeList(pageMaker.getStartRow(), pageMaker.getCutRow());
		int employeeAddrCount = 0;
		for(Employee employee : list) {
			employeeAddrCount = employeeAddrDao.countEmployeeAddrListOne(employee.getEmployeeNo());
			employee.setEmployeeAddrCount(employeeAddrCount);
		}
		int sumCount = employeeAddrDao.countEmployeeAddrListAll();
		request.setAttribute("sumCount", sumCount);
		request.setAttribute("list", list);
		request.setAttribute("pageMaker", pageMaker);
		request.setAttribute("pageNumber", pageNumber);
		request.getRequestDispatcher("/WEB-INF/views/employee/getEmployeeList.jsp").forward(request, response);
	}

}
