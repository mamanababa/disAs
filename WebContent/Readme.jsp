<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>README</title>
</head>
<body>
	<%
		BufferedReader bufReader = null;
		List<String> list = new ArrayList<String>();
		try {
			String path = this.getClass().getResource("/").getPath();
			path = path.substring(0, path.length() - 8);
			//System.out.println(path);
			bufReader = new BufferedReader(new FileReader(path
					+ "README.txt"));

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

		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
	%>
	<center><%=list.get(i)%></center>
	<br>
	<%
			}
		}
	%>

	<center>
		<input type="submit" value="return to start"
			onclick="window.location.href='Request.jsp'">
	</center>
</body>
</html>