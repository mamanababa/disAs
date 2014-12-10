<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fibonacci history</title>
</head>
<body>
	<table align="center" border="1" cellspacing="0">
		<caption>Fibonacci History</caption>

		<tr align="center">
			<td>length</td>
			<td>result</td>
		</tr>
		<!-- 读取文件显示结果 -->
		<%
			BufferedReader bufReader = null;
			List<String> list = new ArrayList<String>();
			try {
				String path = this.getClass().getResource("/").getPath();
				path = path.substring(0, path.length() - 8);
				//System.out.println(path);
				bufReader = new BufferedReader(new FileReader(path + "fib.txt"));

				//	System.out.println(bufReader.readLine());

				String line = null;
				while (bufReader.ready()) {
					list.add(bufReader.readLine());
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (bufReader != null)
						bufReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			//System.out.println(list.size());
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i += 2) {
					//System.out.println(list.get(i));
		%>
		<tr align="center">
			<td><%=list.get(i)%></td>
			<td><%=list.get(i + 1)%></td>
		</tr>
		<%
				}
			}
		%>
	</table>
	<center>
		<input type="submit" value="return to start"
			onclick="window.location.href='Request.jsp'">
	</center>
</body>
</html>