<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<%-- <frm:form action="register" method="POST" modelAttribute="strf"> --%>
<frm:form action="register" method="POST" modelAttribute="student">
	<table bgcolor="aqua">
		<tr><td>Serial No::</td><td><frm:input path="serialNo"/></td></tr>	
		<tr><td>Student Name::</td><td><frm:input path="sname"/></td></tr>
		<tr><td>Address::</td><td><frm:input path="sadd"/></td></tr>
		<tr><td>Hobby::</td><td><frm:input path="hobby"/></td></tr>
		<tr><td colspan="2"><input type="submit" value="Submit"/></td></tr>
	</table>
</frm:form>
