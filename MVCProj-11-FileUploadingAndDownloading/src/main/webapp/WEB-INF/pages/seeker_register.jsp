<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>


<h1 style="text-align: center; color: graytext;">Job Seeker Registration</h1>

<frm:form modelAttribute="info" enctype="multipart/form-data">
	<table align="center" bgcolor="aqua">
		<tr>
			<td>Name</td>
			<td><frm:input path="jsName" /></td>
		</tr>

		<tr>
			<td>Address</td>
			<td><frm:input path="jsAdd" /></td>
		</tr>

		<tr>
			<td>Resume</td>
			<td><input type="file" name="resume"></td>
		</tr>

		<tr>
			<td>Photo</td>
			<td><input type="file" name="photo"></td>
		</tr>

		<tr>
			<td><input type="submit" value="Submit"></td>
			<td><input type="reset" value="Cancel"></td>
		</tr>


	</table>

</frm:form>
<h3><a href="list_files">List All files to download</a></h3>