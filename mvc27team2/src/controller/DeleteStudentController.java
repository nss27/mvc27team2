/*나성수*/
package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentDao;

@WebServlet("/deleteStudentController.team2")
public class DeleteStudentController extends HttpServlet {
	private StudentDao studentDao = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		int result = 0;
		studentDao = new StudentDao();
		result = studentDao.deleteStudent(studentNo);
		if(result != 0) {
			response.sendRedirect(request.getContextPath()+"/getStudentListController.team2");
		}else {
			response.setContentType("text/html;charset=utf-8");
	   		PrintWriter out=response.getWriter();
	   		out.println("<script>");
	   		out.println("alert('남아있는 주소가 존재해 삭제하실 수 없습니다.');");
	   		out.println("location.href='./getStudentAddrListController.team2';");
	   		out.println("</script>");
	   		out.close();
		}
	}

}
