<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contratti</title>
</head>
<body>

<table cellspacing="2" cellpadding="2">
<thead>
<th>Contratti</th>
<th></th>
</thead>
<tbody>
<c:forEach var="item" items="${items}">
<tr>
<td>${ item.id_contratto }</td>
<td>${ item.data_assunzione }</td>
<td>${ item.data_scadenza }</td>
<td>${ item.tipologia }</td>
<td>
<a href="${pageContext.request.contextPath}/contratto/delete/${item.id}">Rimuovi</a>
<a href="${pageContext.request.contextPath}/contratto/update/${item.id}">Modifica</a>

</td>

</tr>
</c:forEach>

</tbody>
</table>
<a href="${pageContext.request.contextPath}/contratto/create">Aggiungi</a>
</body>
</html>