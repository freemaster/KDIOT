package kr.mem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mem.model.MemberDAO;
import kr.mem.model.MemberDAOImpl;

@WebServlet("/memberDelete.do")
public class MemberDeleteController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		String cpath = request.getContextPath();
		MemberDAO dao = new MemberDAOImpl();
		int cnt = dao.memberDelete(num);
		if(cnt > 0) {
			response.sendRedirect(cpath+"/memberList.do");
			System.out.println("삭제 성공");
		} else {
			throw new ServletException("error");
		}
	}

}
