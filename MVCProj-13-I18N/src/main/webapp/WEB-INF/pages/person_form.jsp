<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    
    
    <h1 style="text-align:center;color:red"><spring:message code="person.title"/></h1>
    
    
    <frm:form modelAttribute="perFrm">
    	<table align="center" bgcolor="pink">
    		<tr>
    			<td><spring:message code="person.name"/></td>
    			<td><frm:input path="name"/></td>
    		</tr>
    		
    		<tr>
    			<td><spring:message code="person.addrs"/></td>
    			<td><frm:input path="addrs"/></td>
    		</tr>
    		
    		<tr>
    			<td><spring:message code="person.mobileNo"/></td>
    			<td><frm:input path="mobileNo"/></td>
    		</tr>
    		
    		<tr><td><input type="submit" value="<spring:message code="person.submit.cap"/>"/><td></tr>
    	</table>
    </frm:form>
    <a href="?lang=fr_FR">French</a> &nbsp;&nbsp;<a href="?lang=hi_IN">Hindi</a>
    	 &nbsp;&nbsp;<a href="?lang=zh_CN">Chinese</a> &nbsp;&nbsp;<a href="?lang=de_DE">Spanish</a>
