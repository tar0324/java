<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
	int dan=Integer.parseInt(request.getParameter("dan"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border='1' width='800'>
		<%
		for(int i = 2; i <= dan; i++){
		%>
		<tr align='center' bgcolor='#FFFF66'>
		<td colspan='2'><%= i %>단출력 </td>
		</tr>
		<%
			for(int j=1;j<10;j++){
				if(j%2 == 1){
		%>
		<tr align='center' bgcolor="#FFA07A">
			<td width='400'>
				<%=i %> * <%=j %>
			</td>
			<td width='400'>
				<%= i*j %>
			</td>
		</tr>
		<%
				}else{
		%>
		<tr align='center' bgcolor="#FFD700">
			<td width='400'>
				<%=i %> * <%=j %>
			</td>
			<td width='400'>
				<%= i*j %>
			</td>
		</tr>
		<%
				
				}
			}
		%>
		<tr></tr>
		<%
		}
		%>
	</table>

</body>
</html>