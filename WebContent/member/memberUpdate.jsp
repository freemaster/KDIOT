<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="kr.mem.model.*"%>
<%@page import="java.util.*"%>

<%
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
	if (cnt > 0) { //성공 -> 목록으로 : 서블릿 요청(memberList.do)
		response.sendRedirect("memberList.jsp");
		System.out.println("수정 성공");
	} else { //실패
		throw new ServletException("error");
	}
%>