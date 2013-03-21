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
<title>Użytkownik -</title>
</head>
<body>
 
  <table>
    <form:form modelAttribute="user">
      <c:if test="${edit}">
      </c:if>
      <tr>
        <td><form:label path="id_u">Nr karty:</form:label></td>
      </tr>
      <tr>
        <td><form:input path="id_u" value="<%=details.getId_u()%>" disabled="true" /></td>
      </tr>
      <tr>
        <td><form:label path="name">Imię/Imiona:</form:label></td>
      </tr>
      <tr>
        <td><form:input path="name" value="<%=details.getName()%>" /></td>
      </tr>
      <tr>
        <td><form:label path="surname">Nazwisko:</form:label></td>
      </tr>
      <tr>
        <td><form:input path="surname" value="<%=details.getSurname()%>" /></td>
      </tr>
      <tr>
        <td><form:label path="password">Hasło:</form:label></td>
      </tr>
      <tr>
        <td><form:password path="password" value="<%=details.getPassword()%>" /></td>
      </tr>
      <tr>
        <td><form:label path="registerPoint_id">Punkt Rejestracji:</form:label></td>
      </tr>
      <tr>
        <td><form:select path="registerPoint_id">
            <form:options items="${sps}" itemValue="id_sp" itemLabel="name" selected="<%=details.getRegisterPoint()%>" />
          </form:select></td>
      </tr>
      <tr>
        <td><form:label path="role_id">Rola:</form:label></td>
      </tr>
      <tr>
        <td><form:select path="role_id" selected="<%=details.getRole()%>">
            <form:options items="${roles}" itemValue="id_r" itemLabel="name" selected="<%=details.getRole().getId_r()%>" />
          </form:select></td>
      </tr>
      <tr>
        <td><form:label path="last_login">Ostatnie logowanie:</form:label></td>
      </tr>
      <tr>
        <td><form:input path="last_login" value="<%=details.getLast_loginAsString()%>" /></td>
      </tr>
      <tr>
        <td><form:label path="last_order_realization">Ostatnia realizacja zamówienia:</form:label></td>
      </tr>
      <tr>
        <td><form:input path="last_order_realization" value="<%=details.getLast_order_realizationAsString()%>" /></td>
      </tr>
      <tr>
        <td><form:label path="last_points">Ostatnio dodane punkty:</form:label></td>
      </tr>
      <tr>
        <td><form:input path="last_points" value="<%=details.getLast_pointsAsString()%>" /></td>
      </tr>
      <tr>
        <td><form:label path="blocked_points">Zablokowane punkty:</form:label></td>
      </tr>
      <tr>
        <td><form:input path="blocked_points" value="<%=details.getBlocked_points()%>" /></td>
      </tr>
      <tr>
        <td>Punkty:</td>
      </tr>
      <tr>
        <td>${points}</td>
      </tr>
      <tr>
        <td><input type="submit" value="Wyślij" /></td>
      </tr>
    </form:form>
  </table>
</body>
</html>