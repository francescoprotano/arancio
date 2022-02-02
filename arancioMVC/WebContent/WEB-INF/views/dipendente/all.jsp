<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dipendenti</title>
</head>
<body>





<form:form method="post"  modelAttribute="filters" >
<label>ID Dipendente: </label><br/>
<form:input path="query" /><br/>
<input type="submit" value="Cerca">
</form:form>

<a href="${pageContext.request.contextPath}/dipendente/all">Tutti</a>

<table cellspacing="2" cellpadding="2">
<thead>
<th>ID Dipendente</th>
<th>Nome</th>
<th>Cognome</th>
<th>Data di Nascita</th>
<th>Email</th>
<th>Password</th>
<th>Ruolo</th>
<th>Contratto</th>
</thead>
<tbody>
<c:forEach var="item" items="${items}">
<tr>
<td>${ item.id_dipendente }</td>
<td>${ item.nome }     </td>
<td>${ item.cognome }</td>
<td>${ item.data_nascita }</td>
<td>${ item.email }</td>
<td>${ item.password }</td>
<td>${ item.ruolo_fk }</td>
<td>${ item.contratto_corrente_fk.tipologia }</td>

<td>
<a href="${pageContext.request.contextPath}/dipendente/delete/${item.id_dipendente}">Rimuovi</a>
<a href="${pageContext.request.contextPath}/dipendente/update/${item.id_dipendente}">Modifica</a>

</td>

</tr>
</c:forEach>

</tbody>
</table>
<a href="${pageContext.request.contextPath}/dipendente/create">Aggiungi</a>
</body>
</html>