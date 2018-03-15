package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;
import model.TeacherDao;

@WebServlet("/updateTeacherController.team2")
public class UpdateTeacherController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int teacherNo = Integer.parseInt(request.getParameter("teacherNo"));
		TeacherDao teacherDao = new TeacherDao();
		Teacher teacher = teacherDao.selectTeacherOne(teacherNo);
		request.setAttribute("teacher", teacher);
		request.getRequestDispatcher("/WEB-INF/views/updateTeacher.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}