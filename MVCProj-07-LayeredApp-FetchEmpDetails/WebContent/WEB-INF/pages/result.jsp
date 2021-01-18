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
				</tr>
			</c:forEach>
		
		</table>	
	</c:when>
	<c:otherwise>
		<h1 style="color:threedshadow; text-align:center">No Data Found</h1>
	</c:otherwise>
</c:choose>
<br>
<a href="home">Home</a>

<a class="text-danger text-center" href="JavaScript:doPrint()">Print</a>
</div>

<script language="JavaScript">
	function doPrint(){
		frames.focus();
		frames.print();
	}
</script>