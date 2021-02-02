<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="kr.mem.model.*"%>
<%@page import="java.util.*"%>

<%
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
	if (cnt > 0) { //성공 -> 목록으로 : 서블릿 요청(memberList.do)
		response.sendRedirect("memberList.jsp");
		System.out.println("저장 성공");
	} else { //실패
		throw new ServletException("error");
	}
%>