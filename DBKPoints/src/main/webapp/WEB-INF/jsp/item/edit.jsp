<%@page import="pl.spot.dbk.points.server.hib.Item"%>
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
    Item i = (Item) request.getAttribute("object");

    if (u.isAdmin()) {}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Użytkownik -</title>
</head>
<body>
  <table>
    <form:form modelAttribute="item">
      <c:if test="${edit}">
      </c:if>
      <tr>
        <td><form:label path="id_i">Id:</form:label></td>
      </tr>
      <tr>
        <td><form:input path="id_i" value="<%=i.getId_i()%>" disabled="true" /></td>
      </tr>
      <tr>
        <td><form:label path="name">Nazwa:</form:label></td>
      </tr>
      <tr>
        <td><form:input path="name" value="<%=i.getName()%>" /></td>
      </tr>
      <tr>
        <td><form:label path="cost">Koszt:</form:label></td>
      </tr>
      <tr>
        <td><form:input path="cost" value="<%=i.getCost()%>" /></td>
      </tr>
      <tr>
        <td><input type="submit" value="Wyślij" /></td>
      </tr>
    </form:form>
  </table>
</body>
</html>