package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;
import model.TeacherDao;

@WebServlet("/addTeacherController.team2")
public class AddTeacherController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/teacher/addTeacher.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자가 화면에 입력한 값을 가져올 때 이클립스에서 설정한 값과 통일시키기 위한 것.
		request.setCharacterEncoding("utf8");
		//사용자가 입력한 값을 가져오기.
		String teacherId = request.getParameter("teacherId");
		String teacherPw = request.getParameter("teacherPw");
		//sql에 보내줄 값 셋팅
		Teacher teacher = new Teacher();
		teacher.setTeacherId(teacherId);
		teacher.setTeacherPw(teacherPw);
		//결과값 dao 호출
		TeacherDao teacherDao = new TeacherDao();
		int result = teacherDao.insertTeacher(teacher);
		// 재요청
		response.sendRedirect(request.getContextPath()+"/getTeacherListController.team2");
	}
}