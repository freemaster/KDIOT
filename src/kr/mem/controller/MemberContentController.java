package kr.mem.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mem.model.MemberDAO;
import kr.mem.model.MemberDAOImpl;
import kr.mem.model.MemberVO;

@WebServlet("/memberContent.do")
public class MemberContentController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//상세보기
		int num = Integer.parseInt(request.getParameter("num"));
		String cpath = request.getContextPath();
		MemberDAO dao = new MemberDAOImpl();
		MemberVO vo = dao.memberContent(num);
		response.setContentType("text/html;charset=UTF-8"); //한글 깨짐 방지
		PrintWriter out = response.getWriter();
		out.println("<style>table{width:50%}tr{height:40px;}input{height:30px;}</style>");
		out.println("<html>");
		out.println("<body>");
		if(vo != null) {
			out.println("<form action='"+cpath+"/memberUpdate.do' method='post'>");
			out.println("<table border='1'>");
			out.println("<input type='hidden' name='num' value='"+vo.getNum()+"'>");
			out.println("<tr>");
			out.println("<td>번호</td>");
			out.println("<td>"+vo.getNum()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>아이디</td>");
			out.println("<td>"+vo.getId()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>비밀번호</td>");
			out.println("<td>"+vo.getPass()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>이름</td>");
			out.println("<td>"+vo.getMname()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>나이</td>");
			out.println("<td><input type='text' name='mage' value='"+vo.getMage()+"'></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>이메일</td>");
			out.println("<td><input type='text' name='memail' value='"+vo.getMemail()+"'></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>전화번호</td>");
			out.println("<td><input type='text' name='mtel' value='"+vo.getMtel()+"'></td>");
			out.println("</tr>");
			out.println("<td colspan='2' style='text-align:center;'>");
			out.println("<input type='submit' value='수정'>&nbsp;&nbsp;");
			out.println("<input type='reset' value='취소'>&nbsp;&nbsp;");
			out.println("<a href='"+cpath+"/memberList.do'>목록</a>");
			out.println("</td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("</form>");
		} else {
			out.println("<table border='1'>");
			out.println("<tr>");
			out.println("<td colspan='2'>정보가 없습니다.</td>");
			out.println("</tr>");
			out.println("</table>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

}
