<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
Ȩ ȭ�� ��µ�<br />
<%
	if(session.getAttribute("sessionID") == null) { // �α��� �ȵ� ����
		;
	} else { // �α��� �Ǿ� �ִ� ����
		String id = (String)session.getAttribute("sessionID");
		out.println(id + " �α��� �� <br />");
		out.println("<a href=\"logout.do\"><button>�α׾ƿ�</button></a>");
	}
%>
</body>
</html>