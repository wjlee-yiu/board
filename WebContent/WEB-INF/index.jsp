<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
홈 화면 출력됨<br />
<%
	if(session.getAttribute("sessionID") == null) { // 로그인 안된 상태
		;
	} else { // 로그인 되어 있는 상태
		String id = (String)session.getAttribute("sessionID");
		out.println(id + " 로그인 중 <br />");
		out.println("<a href=\"logout.do\"><button>로그아웃</button></a>");
	}
%>
</body>
</html>