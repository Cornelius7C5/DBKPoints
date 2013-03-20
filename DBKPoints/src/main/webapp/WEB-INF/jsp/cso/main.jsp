<%@page import="pl.spot.dbk.points.server.hib.User"%>
<%@page import="pl.spot.dbk.points.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
<title></title>
<meta name="section" content="About" />
</head>
<body>
  <p>Witaj ${hello}</p>
  <c:if test="${!add}">
    <table>
      <tr>
        <td><a href="<c:url value="/cso/add"></c:url>">Sprzedaże</a></td>
      </tr>
      <tr>
        <td><a href="users">Nowy użytkownik</a></td>
      </tr>
    </table>
  </c:if>
  <c:if test="${add}">
    <jsp:include page="_addSale.jsp"></jsp:include>
  </c:if>
  <c:url value="/cso/" var="cso"></c:url>
  <form:form path="${cso}" action="${cso}">
    <input type="text" name="id">
    <input type="submit" value="Sprawdź" name="check">
  </form:form>
  <c:if test="${check}">
    <jsp:include page="../user/points.jsp"></jsp:include>
  </c:if>
</body>
</html>