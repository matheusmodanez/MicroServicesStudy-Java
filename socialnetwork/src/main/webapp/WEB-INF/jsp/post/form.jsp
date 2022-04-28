<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Adicionar Post ${post.author}</title>
</head>
<body>

	<c:if test="${addPostSucess}">
		<h3>Post cadastrado com sucesso. Id: ${savedPost.id} </h3>
	</c:if>	
	
	<c:url var="save_post_url" value="/posts/save"/>
	<form:form action="${save_post_url}" method="post" modelAttribute="post">
	
	  <form:label path="id">Id: ${id}</form:label><br>
	  <form:input type="text" path="id" readonly="true"/><br>
	  
	  <form:label path="author">Autor:</form:label><br>
	  <form:input type="text" path="author"/><br>
	  
	  <form:label path="title">Título:</form:label><br>
	  <form:input type="text" path="title"/><br>
	  
	  <input type="submit" name="salvar" value="Salvar"/>
	</form:form>
</body>
</html>