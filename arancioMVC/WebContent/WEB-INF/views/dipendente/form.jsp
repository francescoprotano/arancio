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
<c:if test="${model.id_dipendente!=null}">
Modifica
</c:if>
<c:if test="${model.id_dipendente==null}">
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
<label>Data di Nascita: </label><br/>
<form:input path="data_nascita" /><br/>
<form:errors path="data_nascita"> <c:out value="${message}"/> </form:errors><br/>
<label>Email: </label><br/>
<form:input path="email" /><br/>
<form:errors path="email"> <c:out value="${message}"/> </form:errors><br/>
<label>Password: </label><br/>
<form:input path="password" /><br/>
<form:errors path="password"> <c:out value="${message}"/> </form:errors><br/>
<label>Ruolo: </label><br/>
<form:input path="ruolo_fk" /><br/>
<form:errors path="ruolo_fk"> <c:out value="${message}"/> </form:errors><br/>
<label>Contratto Corrente: </label><br/>
<form:input path="contratto_corrente_fk" /><br/>
<form:errors path="contratto_corrente_fk"> <c:out value="${message}"/> </form:errors><br/>
<hr/>
<input type="submit" value="Salva">
</form:form>
</fieldset>
<br/>
<a href="${pageContext.request.contextPath}/dipendente/all">Indietro</a>
</body>
</html>