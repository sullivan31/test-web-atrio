<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<c:url value="/subscribe"/>" method="POST">
                    <p>Les champs marqués d'un <span class="redtext">*</span> sont obligatoires.</p>
                    <div>
                        <label for="pseudo">Pseudo <span class="redtext">*</span></label>
                        <input id="pseudo" name="pseudo" type="text"
                               value="<c:out value="${param.pseudo}"/>"
                               size="20" maxlength="200">
                        <c:if test="${!empty requestScope.errors.pseudoErrorMsg}">
                            <span class="redtext">${requestScope.errors.pseudoErrorMsg}</span>
                        </c:if>
                    </div>
                    <div>
                        <label for="contact">Contact <span class="redtext">*</span></label>
                        <input id="contact" name="contact" type="text"
                               value="<c:out value="${param.contact}"/>"
                               size="25" maxlength="100">
                        <c:if test="${!empty requestScope.errors.contactErrorMsg}">
                            <span class="redtext">${requestScope.errors.contactErrorMsg}</span>
                        </c:if>
                    </div>
                    <div>
                        <label for="pwd">Mot de passe <span class="redtext">*</span></label>
                        <input id="pwd" name="pwd" type="password"
                            value=""
                            size="20" maxlength="50">
                        <c:if test="${!empty requestScope.errors.pwdErrorMsg}">
                            <span class="redtext">${requestScope.errors.pwdErrorMsg}</span>
                        </c:if>
                    </div>
                    <div>
                        <label for="confirm">Retapez votre mot de passe <span class="redtext">*</span></label>
                        <input id="confirm" name="confirm" type="password"
                            value=""
                            size="20" maxlength="50">
                        <c:if test="${!empty requestScope.errors.confirmErrorMsg}">
                            <span class="redtext">${requestScope.errors.confirmErrorMsg}</span>
                        </c:if>
                    </div>
                    <div class="button-container">
                        <button class="blockbutton" type="submit">S'inscrire</button>
                    </div>
                    </form>
</body>
</html>