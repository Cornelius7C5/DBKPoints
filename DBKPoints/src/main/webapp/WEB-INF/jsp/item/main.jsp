<%@page import="pl.spot.dbk.points.server.hib.User"%>
<%@page import="pl.spot.dbk.points.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
<title>Panel Administratora - Użytkownicy</title>
<meta name="section" content="About" />
</head>
<body>
  <p>
    <c:if test="${ok}">
      <c:out value="Dodano przedmiot "></c:out>      
      <c:out value="${newItemName}"></c:out>
      <c:out value="o wartośći: "></c:out>
      <c:out value="${newItemCost}"></c:out>
    </c:if>
  </p>
  <%
      User u = (User) session.getAttribute(Constants.USER);
      if (u.isAdmin()) {
  %>
  <jsp:include page="_addItem.jsp"></jsp:include>
  <%
      }
  %>
</body>
</html>