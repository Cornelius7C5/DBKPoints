<%@page import="pl.spot.dbk.points.server.hib.Basket"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pl.spot.dbk.points.server.hib.User"%>
<%@page import="pl.spot.dbk.points.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
<title>Koszyk</title>
<meta name="section" content="About" />
</head>
<body>
<p>Zalogowany jako ${hello}</p>
  <table>
    <tr>
      <th>Nazwa</th>
      <th>Koszt</th>
      <th>Ilość</th>
      <th>Suma</th>
    </tr>
    <%
        ArrayList<Basket> items = (ArrayList<Basket>) request.getAttribute("items");
        int sum = 0;
        for (Basket b : items) {
            sum += b.getAmount() * b.getId_item().getCost();
    %>
    <tr>
      <td><%=b.getId_item().getName()%></td>
      <td><%=b.getId_item().getCost()%></td>
      <td>x <%=b.getAmount()%></td>
      <td>= <%=b.getAmount() * b.getId_item().getCost()%></td>
    </tr>
    <%
        }
    %>
    <tr>
      <td></td>
      <td></td>
      <td>Całość:</td>
      <td><%=sum%></td>
    </tr>
  </table>
  <c:url value="/user/basket/order" var="basket"></c:url>
  <form:form path="${basket}" action="${basket}">
    <select name="target">
      <c:forEach items="${sps}" var="sp">
        <option value="${sp.id_sp}">${sp.name }</option>
      </c:forEach>
    </select>
    <input type="submit" name="basket" value="Kup" />
    <input type="submit" name="basket" value="Powrót" />
  </form:form>
</body>
</html>