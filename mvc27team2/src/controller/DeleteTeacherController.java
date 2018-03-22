package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;
import model.TeacherDao;

@WebServlet("/deleteTeacherController.team2")
public class DeleteTeacherController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//화면에서 삭제를 누르면 teacherNo를 컨트롤러에 보내게되고 컨트롤러에서 teacherNo를 받아
		int teacherNo = Integer.parseInt(request.getParameter("teacherNo"));
		//Dao 삭제 처리 메서드를 실행.
		TeacherDao teacherDao = new TeacherDao();
		teacherDao.deleteTeacher(teacherNo);
		//
		response.sendRedirect(request.getContextPath()+"/getTeacherListController.team2");
	}
}
