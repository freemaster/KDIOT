<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="kr.mem.model.*"%>
<%@page import="java.util.*"%>

<%
	String cpath = request.getContextPath();
	MemberDAO dao = new MemberDAOImpl();
	List<MemberVO> list = dao.memberList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
<style>
/* DivTable.com */
.divTable {
	display: table;
	width: 100%;
	font-size:12px;
}

.divTableRow {
	display: table-row;
}

.divTableHeading {
	background-color: #EEE;
	display: table-header-group;
}

.divTableCell, .divTableHead {
	border: 1px solid #999999;
	display: table-cell;
	padding: 3px 10px;
}

.divTableHeading {
	background-color: #EEE;
	display: table-header-group;
}

.divTableFoot {
	background-color: #EEE;
	display: table-footer-group;
	font-weight: bold;
}

.divTableBody {
	display: table-row-group;
}

.divTable2{
	width:90%;
	font-weight:bold;
}

.divTableRow2{
	padding:10px;
	text-align:right;
}
.green{
	background:#a5dca5;
	font-weight: bold;
}
.divTableCell:nth-child(1) {
	width:6%;
}
.divTableCell:nth-child(4){
	width:10%
}

.divTableCell:nth-child(2),.divTableCell:nth-child(3),.divTableCell:nth-child(5),.divTableCell:nth-child(6) {
	width:15%
}
.divTableCell:nth-child(7) {
	width:14%
}
</style>
<script type="text/javascript">
function insertForm() {
	location.href="memberInsertForm.jsp";
}
function deleteFn(num) {
	location.href="memberDelete.jsp?num="+num;
}
function updateFn(num) {
	location.href="memberContent.jsp?num="+num;
}
</script>
</head>
<body>
 - 서버 : <%=application.getServerInfo() %>
 - 서블릿 : <%= application.getMajorVersion() %>.<%= application.getMinorVersion() %>
 - JSP : <%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %>
	<h4>회원목록</h4>
	<div class="divTable" style="width: 90%; border: 1px solid #000;">
		<div class="divTableBody">
			<div class="divTableRow">
				<div class="divTableCell green">번호</div>
				<div class="divTableCell green">아이디</div>
				<div class="divTableCell green">이름</div>
				<div class="divTableCell green">나이</div>
				<div class="divTableCell green">이메일</div>
				<div class="divTableCell green">전화번호</div>
				<div class="divTableCell green">관리</div>
			</div>
			<%
				for (int i = 0; i < list.size(); i++) {
					MemberVO vo = list.get(i);
			%>
			<div class="divTableRow">
				<div class="divTableCell"><%=vo.getNum()%></div>
				<div class="divTableCell"><%=vo.getId()%></div>
				<div class="divTableCell"><%=vo.getMname()%></div>
				<div class="divTableCell"><%=vo.getMage()%></div>
				<div class="divTableCell"><%=vo.getMemail()%></div>
				<div class="divTableCell"><%=vo.getMtel()%></div>
				<div class="divTableCell">
					<button onclick="updateFn(<%=vo.getNum()%>)">수정</button>
					&nbsp;&nbsp; 
					<button onclick="deleteFn(<%=vo.getNum()%>)">삭제</button>
				</div>
			</div>
			<%
				}
			%>
		</div>
	</div>
	<div class="divTable2">
		<div class="divTableRow2">
			<button onclick="insertForm()" value="회원가입">회원가입</button>
		</div>
	</div>

</body>
</html>