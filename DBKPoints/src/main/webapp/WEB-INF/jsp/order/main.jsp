<%@page import="pl.spot.dbk.points.Constants"%>
<%@page import="pl.spot.dbk.points.server.hib.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE>
<html>
<head>
<title>Zamówienia</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<%
    User u = (User) session.getAttribute(Constants.USER);
%>
<table>
  <tr>
    <th>Data zamówienia</th>
    <th>Miejsce rejestracji</th>
    <th>Pracownik rej.</th>
    <th>Wartość</th>
    <th>Status</th>
    <%
        if (u.getRole().getId_r() > 10) {
    %>
    <th>Zmień status</th>
    <%
        }
    %>
  </tr>
  <c:forEach items="${orders}" var="o">
    <tr>
      <td><a href="<c:url value="/order/${o.id_o}"/>">${o.date}</a></td>
      <td><a href="<c:url value="/order/${o.id_o}"/>">${o.salePoint.name}</a></td>
      <td><a href="<c:url value="/order/${o.id_o}"/>"> <c:if test="${!o.seller.id_u==o.buyer.id_u}">
      ${o.seller.name}
      </c:if> <c:if test="${o.seller.id_u==o.buyer.id_u}">
      INTERNET
      </c:if>
      </a></td>
      <td><a href="<c:url value="/order/${o.id_o}"/>">${o.sum}</a></td>
      <td><a href="<c:url value="/order/${o.id_o}"/>">${o.status.name}</a></td>
      <%
          if (u.getRole().getId_r() > 10) {
      %>
      <td><c:url value="/order/${o.id_o}" var="ord"></c:url> <form:form path="${ord}" action="${ord}">
          <select name="status">
            <c:forEach items="${statuses}" var="s">
              <option value="${s.id_s}">${s.name}</option>
            </c:forEach>
          </select>
          <input type="submit" value="Zmień" name="change">
        </form:form></td>
      <%
          }
      %>
    </tr>
  </c:forEach>
</table>
</html>