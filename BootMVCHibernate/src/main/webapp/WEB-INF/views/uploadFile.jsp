<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="uploadFile" modelAttribute="fileUpload" method="POST" enctype="multipart/form-data">
		Select <input type="file" name="fileAttachment" />
		<form:button >Upload</form:button>
	</form:form>
</body>
</html>