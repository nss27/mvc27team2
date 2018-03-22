package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TeacherAddrDao;
import model.TeacherDao;

@WebServlet("/deleteTeacherAddrController.team2")
public class DeleteTeacherAddrController extends HttpServlet {
	private TeacherAddrDao teacherAddrDao;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] checked = request.getParameterValues("teacherAddrNo");
		
		for(int i = 0; i<checked.length; i++) {
			int teacherAddrNo = Integer.parseInt(checked[i]);
			teacherAddrDao = new TeacherAddrDao();
			teacherAddrDao.deleteTeacherAddr(teacherAddrNo);
		}
		response.sendRedirect(request.getContextPath()+"/getTeacherAddrListController.team2");
	}
}
