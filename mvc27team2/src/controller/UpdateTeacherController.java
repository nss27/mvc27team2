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
		request.getRequestDispatcher("/WEB-INF/views/teacher/updateTeacher.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		int teacherNo = Integer.parseInt(request.getParameter("teacherNo"));
		String teacherId = request.getParameter("teacherId");
		String teacherPw = request.getParameter("teacherPw");
		//쿼리 mysql에 보내기위해 값을 다시 셋팅
		Teacher teacher = new Teacher();
		teacher.setTeacherNo(teacherNo);
		teacher.setTeacherId(teacherId);
		teacher.setTeacherPw(teacherPw);
		//dao 호출
		TeacherDao teacherDao = new TeacherDao();
		teacherDao.updateTeacher(teacher);
		//넘겨줄 페이지 
		response.sendRedirect(request.getContextPath()+"/getTeacherListController.team2");
	}
}