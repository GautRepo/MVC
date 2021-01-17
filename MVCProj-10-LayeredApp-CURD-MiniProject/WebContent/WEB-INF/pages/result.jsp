<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

1<h1 style="text-align:center;color:purple">Employee Details</h1>
<head>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<div class="container">
<c:choose>
	<c:when test="${empDetails ne null && !empty empDetails}">
		<table class="table">
		<tr>
			<th>Serial Number</th>
			<th>Employee No</th>
			<th>Name</th>
			<th>Job</th>
			<th>Salary</th>
			<th>DeptNo</th>
			<th>Gross Salary</th>
			<th>Net Salary</th>
			<th>Operation</th>
		</tr>
		
			<c:forEach var="dto" items="${empDetails}">
				<tr>
					<td>${dto.serialNo}</td>
					<td>${dto.empNo}</td>
					<td>${dto.ename}</td>
					<td>${dto.job}</td>
					<td>${dto.sal}</td>
					<td>${dto.deptNo}</td>
					<td>${dto.gSal}</td>
					<td>${dto.nSal}</td>
					<td><a href="editEmp.htm?eno=${dto.empNo}"><img src="images/edit.jpg" width="50" height="50"/></a></td>
					<td><a href="deleteEmp.htm?eno=${dto.empNo}" onclick="confirm('Are you sure to delete ${dto.ename}')"><img src="images/delete.png" width="50" height="50"/></a></td>
				</tr>
			</c:forEach>
		
		</table>	
	</c:when>
	<c:otherwise>
		<h1 style="color:threedshadow; text-align:center">No Data Found</h1>
	</c:otherwise>
</c:choose>


<br><br>
<c:if test="${msg ne null && !empty msg}">
<marquee direction="right"><h1 class="text-primary font-weight-bold">${msg}</h1></marquee>
</c:if>

<br><br>
<a href="home.htm"><img src="images/home.png" width="80" height="40"></a>
&nbsp;&nbsp;&nbsp;<a class="text-danger text-center" href="JavaScript:doPrint()"><img src="images/print.png" width="50" height="50"></a>
&nbsp;&nbsp;&nbsp;<a href="empSave.htm"><img src="images/save.png" width="50" height="50"></a>

</div>

<script language="JavaScript">
	function doPrint(){
		frames.focus();
		frames.print();
	}
</script>