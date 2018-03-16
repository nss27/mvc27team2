package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;
import model.TeacherAddr;
import model.TeacherAddrDao;
import model.TeacherDao;


@WebServlet("/addTeacherAddrController.team2")
public class AddTeacherAddrController extends HttpServlet {
	 private TeacherDao teacherDao;
	 private TeacherAddrDao teacherAddrDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//주소추가할 선생님 한명의 데이터를 받아오기 위해
		//여기서만 사용하도록 private 선언.
		Teacher teacher = null;
		int teacherNo=Integer.parseInt(request.getParameter("teacherNo"));
		teacher = new Teacher();
		this.teacherDao = new TeacherDao();
		teacher = this.teacherDao.selectTeacherOne(teacherNo); 
		request.setAttribute("teacherNo", teacher.getTeacherNo());
		request.setAttribute("teacherId", teacher.getTeacherId());
		request.getRequestDispatcher("/WEB-INF/views/teacher/addTeacherAddr.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		//addTeacherAddr 폼에서 보낸것을 받아온다. 그래서 getParameter를 사용.
		TeacherAddr teacherAddr = null;
		int teacherNo = Integer.parseInt(request.getParameter("teacherNo"));
		String address = request.getParameter("address");
		//참조변수 선언을 해서 주소를 불러온다. 담을공간을 준비
		teacherAddr = new TeacherAddr();
		//값 셋팅
		teacherAddr.setTeacherNo(teacherNo);
		teacherAddr.setAddress(address);
		//메소드를 사용하기 위해 Dao 호출
		this.teacherAddrDao = new TeacherAddrDao();
		this.teacherAddrDao.insertTeacherAddr(teacherAddr);
		//리다이렉트를 해서 화면을 보여주기위해 경로 요청
		response.sendRedirect(request.getContextPath()+"/getTeacherAddrListController.team2");
	}
}
