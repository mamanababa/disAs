<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Second Page</title>
</head>
<script language="JavaScript">
	setTimeout("getResult.submit();",10000);
</script>
<body>
	<table align="center">
		<tr>
			<td>Fibonacci Request</td>
		</tr>
		<tr>
			<td><form name="getResult" action="FibS" method="post">
					<input type="hidden" name="request-type" value="Poll">
					<input type="hidden" name="jobNo" value="<%=request.getParameter("jobnumber")%>">
						Job Number:
					<%=request.getParameter("jobnumber")%>
			</form></td>
		</tr>
		<tr>
			<td>Page will refresh in 10 seconds then get result</td>
		</tr>
	</table>
</body>
</html>