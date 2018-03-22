/*배건혜*/
package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeDao;

@WebServlet("/deleteEmployeeController.team2")
public class DeleteEmployeeController extends HttpServlet {
	private EmployeeDao employeeDao = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		int result = 0;
		int employeeNo = Integer.parseInt(request.getParameter("employeeNo")); 
		employeeDao = new EmployeeDao();
		result = employeeDao.deleteEmployee(employeeNo);
		if(result != 0) {
			response.sendRedirect(request.getContextPath() + "/getEmployeeListController.team2");
		}else {
			response.setContentType("text/html;charset=utf-8");
	   		PrintWriter out=response.getWriter();
	   		out.println("<script>");
	   		out.println("alert('남아있는 주소가 존재해 삭제하실 수 없습니다.');");
	   		out.println("location.href='./getEmplyeeAddrListController.team2';");
	   		out.println("</script>");
	   		out.close();
		}
		
	}

}
