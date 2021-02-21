<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
    
    <h1 style="text-align:center; color:red ">Person Registration Page</h1>
    
    <frm:form modelAttribute="perfrm">
    	<table align="center" bgcolor="cyan">
    		<tr>
    			<td>Name::</td>
    			<td><frm:input path="name"/></td>
    		</tr>
    		<tr>
    			<td>Address::</td>
    			<td><frm:input path="addr"/></td>
    		</tr>
    		<tr>
    			<td>Mobile::</td>
    			<td><frm:input path="mobNo"/></td>
    		</tr>
    		
    		<tr>
    			<td>Gender::</td>
    			<td><frm:radiobuttons path="gender" items="${genderList}"/></td>
    		</tr>
    		
    		<tr>
    			<td>Hobbies::</td>
    			<td><frm:checkboxes path="hobbies" items="${hobbyList}"/></td>
    		</tr>
    		
    		<tr>
    			<td>Color::</td>
    			<td>
    				<frm:select path="color" multiple="multiple">
    				<frm:options items="${clrList}"/>
    				</frm:select>
    			</td>
    		</tr>
    		
    		<tr>
    			<td>Qualification::</td>
    			<td><frm:select path="qly">
    				<frm:options items="${qlyList}"/>
    			</frm:select></td>
    		</tr>
    		
    		<tr>
    			<td>DOB(dd-MM-yyyy)</td>
    			<td><frm:input path="dob"/></td>
    		</tr>
    		
    		<tr>
    			<td>DOJ(dd-MM-yyyy)</td>
    			<td><frm:input type="date" path="doj"/></td>
    		</tr>
    		
    		<tr>
    			<td colspan="2"><input type="submit" value="register"/></td>
    		</tr>
    		
    	</table>
    
    </frm:form>
