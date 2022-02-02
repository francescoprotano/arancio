<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci</title>
</head>
<body>
<c:if test="${err != null}">
${err}
</c:if>
<fieldset>
<legend>
<c:if test="${model.id>0}">
Modifica
</c:if>
<c:if test="${model.id==0}">
Inserisci
</c:if>
</legend>
<form:errors path="*" />


<form:form method="post" modelAttribute="model">
<label>Nome: </label><br/>
<form:input path="nome" /><br/>
<form:errors path="nome"> <c:out value="${message}"/> </form:errors><br/>
<label>Cognome: </label><br/>
<form:input path="cognome" /><br/>
<form:errors path="cognome"> <c:out value="${message}"/> </form:errors><br/>

<label>Data nascita: </label><br/>
<form:input path="data_nascita"  type="date"/><br/>
<form:errors path="data_nascita"> <c:out value="${message}"/> </form:errors><br/>

<label>Codice fiscale: </label><br/>
<form:input path="codice_fiscale" /><br/>
<form:errors path="codice_fiscale"> <c:out value="${message}"/> </form:errors><br/>

<hr/>
<input type="submit" value="Salva">
</form:form>
</fieldset>
<br/>
<a href="${pageContext.request.contextPath}/anagrafica/all">Indietro</a>
</body>
</html>