package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TeacherAddr;
import model.TeacherAddrDao;

@WebServlet("/updateTeacherAddrController.team2")
public class UpdateTeacherAddrController extends HttpServlet {
	private TeacherAddrDao teacherAddrDao = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int teacherAddrNo = Integer.parseInt(request.getParameter("teacherAddrNo"));
		teacherAddrDao = new TeacherAddrDao();
		TeacherAddr teacherAddr = teacherAddrDao.selectTeacherAddrOne(teacherAddrNo);
		request.setAttribute("teacherAddr", teacherAddr);
		request.getRequestDispatcher("/WEB-INF/views/teacher/updateTeacherAddr.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자가 입력한 값을 받는 것이기때문에 인코딩을 적용시켜야 한다.
		request.setCharacterEncoding("utf8");
		//값 받아오기.
		int teacherAddrNo = Integer.parseInt(request.getParameter("teacherAddrNo"));
		String address = request.getParameter("address");
		//값을 쿼리에 보내기위해 TeacherAddr메서드를 호출하여 값을 저장한다.
		TeacherAddr teacherAddr = new TeacherAddr();
		teacherAddr.setTeacherAddrNo(teacherAddrNo);
		teacherAddr.setAddress(address);
		//Dao 
		teacherAddrDao = new TeacherAddrDao();
		teacherAddrDao.updateTeacherAddr(teacherAddr);
		//getTeacherAddrListController.team2경로로 값을 넘겨준다.
		response.sendRedirect(request.getContextPath()+"/getTeacherAddrListController.team2");
	}
}
