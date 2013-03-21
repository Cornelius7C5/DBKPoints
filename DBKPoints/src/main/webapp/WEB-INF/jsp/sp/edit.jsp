<%@page import="pl.spot.dbk.points.server.hib.SalePoint"%>
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
    SalePoint i = (SalePoint) request.getAttribute("object");

    if (u.isAdmin()) {}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Punkt Sprzedaży -</title>
</head>
<body>
 
  <table>
    <form:form modelAttribute="sp">
      <c:if test="${edit}">
      </c:if>
      <tr>
        <td><form:label path="id_sp">Id:</form:label></td>
      </tr>
      <tr>
        <td><form:input path="id_sp" value="<%=i.getId_sp()%>" disabled="true" /></td>
      </tr>
      <tr>
        <td><form:label path="name">Nazwa:</form:label></td>
      </tr>
      <tr>
        <td><form:input path="name" value="<%=i.getName()%>" /></td>
      </tr>
      <tr>
        <td><input type="submit" value="Wyślij" /></td>
      </tr>
    </form:form>
  </table>
</body>
</html>