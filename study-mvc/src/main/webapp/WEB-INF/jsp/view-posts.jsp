<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<p>Listagem de posts ${instituicao}</p>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Título</th>
				<th>Autor</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="post" items="${posts}">
				<tr>
					<td>${post.id}</td>
					<td>${post.title}</td>
					<td>${post.author}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>