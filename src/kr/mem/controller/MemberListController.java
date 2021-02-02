package kr.mem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mem.model.MemberDAO;
import kr.mem.model.MemberDAOImpl;
import kr.mem.model.MemberVO;


/**
 * Servlet implementation class MemberListController
 */
@WebServlet("/memberList.do")
public class MemberListController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// model과 연동 : 객체 생성
		// MemberDAO인터페이스를 불러와서 실제 구현된 MemberDAOImpl() 메소드를 사용한다.

		MemberDAO dao = new MemberDAOImpl();
		List<MemberVO> list = dao.memberList();
		String cpath = request.getContextPath();
		
		response.setContentType("text/html;charset=UTF-8"); //한글 깨짐 방지
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<td>번호</td>");
		out.println("<td>아이디</td>");
		out.println("<td>이름</td>");
		out.println("<td>나이</td>");
		out.println("<td>이메일</td>");
		out.println("<td>전화번호</td>");
		out.println("<td>관리</td>");
		out.println("</tr>");
		for (int i = 0; i < list.size(); i++) {
			MemberVO vo = list.get(i);
			out.println("<tr>");
			out.println("<td>" + vo.getNum() + "</td>");
			out.println("<td><a href='"+cpath+"/memberContent.do?num="+vo.getNum()+"'>" + vo.getId() + "</a></td>");
			out.println("<td>" + vo.getMname() + "</td>");
			out.println("<td>" + vo.getMage() + "</td>");
			out.println("<td>" + vo.getMemail() + "</td>");
			out.println("<td>" + vo.getMtel() + "</td>");
			out.println("<td><a href='"+cpath+"/memberDelete.do?num="+vo.getNum()+"'>삭제</a></td>");
			out.println("</tr>");
		}
		out.println("<tr>");
		out.println("<td colspan='7' align='right'><a href='"+cpath+"/member/memberInsert.html' style='background:#e5e5e5;border:1px solid #000'>회원가입</a></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

}
