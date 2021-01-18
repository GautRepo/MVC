<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h1 style="color:red; text-align: center">Login Page</h1>

<frm:form modelAttribute="user">
	<table border="1" align="center" bgcolor=aqua>
	<tr><td>User Name</td>
		<td><frm:input path="uname"/></td>
	</tr>
	
	<tr><td>Password</td>
		<td><frm:password path="pwd"/></td>
	</tr>
	
	<tr><td></td><td colspan="2"><input type="submit" value="login"/></td></tr>
	</table>
</frm:form>
<br><br>

<c:if test="${output ne null && !empty output}">
<h1 style="color:red; text-align: center">${output}</h1>
</c:if>