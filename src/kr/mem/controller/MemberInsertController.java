package kr.mem.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mem.model.MemberDAO;
import kr.mem.model.MemberDAOImpl;
import kr.mem.model.MemberVO;

@WebServlet("/memberInsert.do")
public class MemberInsertController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트에서 넘어온 폼파라메트 가져오기
		String cpath = request.getContextPath();
		request.setCharacterEncoding("UTF-8"); //한글 깨짐 방지
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String mname = request.getParameter("mname");
		int mage = Integer.parseInt(request.getParameter("mage"));
		String memail = request.getParameter("memail");
		String mtel = request.getParameter("mtel");
		MemberVO vo = new MemberVO(id, pass, mname, mage, memail, mtel);
		MemberDAO dao = new MemberDAOImpl();
		int cnt = dao.memberInsert(vo);
		if(cnt > 0) { //성공 -> 목록으로 : 서블릿 요청(memberList.do)
			response.sendRedirect(cpath+"/memberList.do");
			System.out.println("저장 성공");
		} else { //실패
			throw new ServletException("error");
		}
	}
}
