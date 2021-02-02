<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@page import="kr.mem.model.*"%>
<%@page import="java.util.*"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	String cpath = request.getContextPath();
	MemberDAO dao = new MemberDAOImpl();
	int cnt = dao.memberDelete(num);
	if (cnt > 0) {
		response.sendRedirect("memberList.jsp");
		System.out.println("삭제 성공");
	} else {
		throw new ServletException("error");
	}
%>