<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<head>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<div class="container">
<h1 style="color:navy">Registration Form</h1>
<frm:form modelAttribute="empFrm">
	<table class="table table-responsive">
	<tr>
		<td>Employee Name::</td>
		<td><frm:input path="ename"/><frm:errors cssClass="text-danger" path="ename"/></td>
	</tr>
	
	<tr>
		<td>Job::</td>
		<td><frm:input path="job"/><frm:errors cssClass="text-danger" path="job"/></td>
	</tr>
	
	<tr>
		<td>Salary::</td>
		<td><frm:input path="sal"/><frm:errors cssClass="text-danger" path="sal"/></td>
	</tr>
	
	<tr>
		<td>Department No::</td>
		<td><frm:select path="deptNo">
			<frm:options items="${deptsinfo}"/>
		</frm:select></td>
	</tr>
	
	<tr><td><input type="submit" value="Register"/></td></tr>
	
	</table>
	<frm:hidden path="vflag"/>

</frm:form>
</div>