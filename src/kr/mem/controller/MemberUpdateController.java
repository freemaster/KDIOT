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

@WebServlet("/memberUpdate.do")
public class MemberUpdateController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라메터 수집
		request.setCharacterEncoding("utf-8");
		String cpath = request.getContextPath();
		int num = Integer.parseInt(request.getParameter("num"));
		int mage = Integer.parseInt(request.getParameter("mage"));
		String memail = request.getParameter("memail");
		String mtel = request.getParameter("mtel");
		MemberVO vo = new MemberVO();
		vo.setNum(num);
		vo.setMage(mage);
		vo.setMemail(memail);
		vo.setMtel(mtel);
		
		MemberDAO dao = new MemberDAOImpl();
		int cnt = dao.memberUpdate(vo);
		if(cnt > 0) { //성공 -> 목록으로 : 서블릿 요청(memberList.do)
			response.sendRedirect(cpath+"/memberList.do");
			System.out.println("수정 성공");
		} else { //실패
			throw new ServletException("error");
		}
	}

}
