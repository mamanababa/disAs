<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Third Page</title>
</head>
<body>
	<table align="center">
		<tr align="center" onmouseover="this.style.backgroundColor='#E6E6FA';" onmouseout="this.style.backgroundColor='#FFFFFF';">
			<td>Fibonacci Result</td>
		</tr>
		<tr align="center" onmouseover="this.style.backgroundColor='#E6E6FA';" onmouseout="this.style.backgroundColor='#FFFFFF';">
			<td><%=request.getAttribute("result")%></td>
		</tr>
		<tr align="center" onmouseover="this.style.backgroundColor='#E6E6FA';" onmouseout="this.style.backgroundColor='#FFFFFF';">
			<td>length that you requested: <%=session.getAttribute("max")%></td>
		</tr>
		<tr align="center" onmouseover="this.style.backgroundColor='#E6E6FA';" onmouseout="this.style.backgroundColor='#FFFFFF';">
			<td><input type="submit" value="return to start"
				onclick="window.location.href='Request.jsp'"></td>
		</tr>
	</table>
</body>
</html>