<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>First Page</title>

</head>

<script language="JavaScript">
	function check(thisform) {
		var max = thisform.max.value;
		for (var i = 0; i < max.length; i++) {
			var oneChar = max.charAt(i);
			if (!(oneChar >= '0' && oneChar <= '9') || (max.charAt(0) =='0')) {
				alert("please enter correct number ( must between 1-93 )");
				thisform.max.focus();
				return (false);
			}
		}
		if (max.length == 2) {
			var char1 = max.charAt(0);
			var char2 = max.charAt(1);
			if (char1 == '9' && char2 >= '4') {
				alert("please enter correct number ( must between 1-93 )");
				thisform.max.focus();
				return (false);
			}
		}
		if(max.length > 2) {
			alert("please enter correct number ( must between 1-93 )");
			thisform.max.focus();
			return (false);
		}
	}
</script>

<body>
	<!-- 表单数据提交给FibServlet.java的post方法处理
		 data of form(max and request-type) pass to the post method of FibServlet.java -->
	                     
	<form action="FibS" method="post" name="re">
		<table align="center">
			<tr align="center"
				onmouseover="this.style.backgroundColor='#E6E6FA';"
				onmouseout="this.style.backgroundColor='#FFFFFF';">
				<td>Fibonacci sequence length</td>
			</tr>

			<tr align="center"
				onmouseover="this.style.backgroundColor='#E6E6FA';"
				onmouseout="this.style.backgroundColor='#FFFFFF';">
				<td><input type="hidden" name="request-type" value="Add">
					<input type="text" name="max"></td>
			</tr>

			<tr align="center"
				onmouseover="this.style.backgroundColor='#E6E6FA';"
				onmouseout="this.style.backgroundColor='#FFFFFF';">
				<td>value[1-93]</td>
			</tr>

			<tr align="center"
				onmouseover="this.style.backgroundColor='#E6E6FA';"
				onmouseout="this.style.backgroundColor='#FFFFFF';">
				<td colspan=2><input type="submit" value="submit"
					onClick="return check(this.form)"> <input type="button"
					value="check history" onClick="window.location.href='History.jsp'">
					<input type="button"
					value="README" onClick="window.location.href='Readme.jsp'"></td>
			</tr>

		</table>
	</form>
</body>
</html>