<%@page import="pl.spot.dbk.points.Constants"%>
<%@page import="pl.spot.dbk.points.server.hib.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
    User u = (User) session.getAttribute(Constants.USER);
    User details = (User) request.getAttribute("object");

    if (u.isAdmin()) {}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Użytkownik - Szczegóły</title>
</head>
<body>
  <table>
    <form:form modelAttribute="user">
      <c:if test="${edit}">
      </c:if>
      <tr>
        <td>Nr karty:</td>
      </tr>
      <tr>
        <td><%=details.getId_u()%></td>
      </tr>
      <tr>
        <td><form:label path="name">Imię/Imiona:</form:label></td>
      </tr>
      <tr>
        <td><form:label path="name" /><%=details.getName()%></td>
      </tr>
      <tr>
        <td><form:label path="surname">Nazwisko:</form:label></td>
      </tr>
      <tr>
        <td><form:label path="surname" /><%=details.getSurname()%></td>
      </tr>
      <tr>
        <td><form:label path="last_login">Ostatnie logowanie:</form:label></td>
      </tr>
      <tr>
        <td><form:label path="last_login" /><%=details.getLast_login().toString()%></td>
      </tr>
      <tr>
        <td><form:label path="last_order_realization">Ostatnia realizacja zamówienia:</form:label></td>
      </tr>
      <tr>
        <td><form:label path="last_order_realization" /><%=details.getLast_order_realization()%></td>
      </tr>
      <tr>
        <td><form:label path="last_points">Ostatnio dodane punkty:</form:label></td>
      </tr>
      <tr>
        <td><form:label path="last_points" /><%=details.getLast_points()%></td>
      </tr>
      <tr>
        <td><form:label path="blocked_points">Zablokowane punkty:</form:label></td>
      </tr>
      <tr>
        <td><form:label path="blocked_points" /><%=details.getBlocked_points()%></td>
      </tr>
      <tr>
        <td>Punkty:</td>
      </tr>
      <tr>
        <td>${points}</td>
      </tr>
      <c:if test="${edit}">
        <tr>
          <td><input type="submit" value="Wyślij" /></td>
        </tr>
      </c:if>
    </form:form>
  </table>
</body>
</html>