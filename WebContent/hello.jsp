<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
public int hap(int a, int b) {
	return a+b;
}
%>
<%-- 주석 --%>
<%
int sum=0;
for(int i=1; i<=10; i++) {
	sum+=i;
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=sum %><br>
<%=hap(10,20) %>
</body>
</html>