<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 style="text-align:center; color:purple;"> List Of Files</h1>

<c:choose>
	<c:when test="${fileList ne null && !empty fileList}">
		<table align="center" bgcolor="fuchsia">
			<c:forEach var="fList" items="${fileList}">
				<tr>
					 <td>${fList}</td>
                 	<td><a href="download?fname=${fList}">download</a> </td>
				</tr>
				
			</c:forEach>
		</table>
	</c:when>

	<c:otherwise>
		<h1 style="text-align:center; color:red">No files available</h1>
	</c:otherwise>

</c:choose>