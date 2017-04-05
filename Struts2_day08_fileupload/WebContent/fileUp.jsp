<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<s:debug></s:debug>
	<s:form action="testUp" method="post" enctype="multipart/form-data">
		<s:file name="myfile" label="File"></s:file>
		<s:textfield name="desc" label="Desc"></s:textfield>
		
		 <s:file name="myfile" label="File"></s:file>
		<s:textfield name="desc[2]" label="Desc"></s:textfield>
		
		<s:file name="myfile" label="File"></s:file>
		<s:textfield name="desc[3]" label="Desc"></s:textfield> 
		
		<s:submit></s:submit>
	
	
	</s:form>
	<s:form action="testUpOne" method="post" enctype="multipart/form-data">
		<s:file name="oneFile" label="OneFile"></s:file>
		<s:textfield name="fileDesc" label="FileDesc"></s:textfield>
		<s:submit></s:submit>
	</s:form>
	
</body>
</html>