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
  <%
      User u = (User) session.getAttribute(Constants.USER);
      if (u.isAdmin()) {
  %>
  <c:if test="${ok}">
    <c:out value="${u.role.name} "></c:out>
    <c:out value="${u.name} ${u.surname}"></c:out>
    <c:out value=" o numerze karty : "></c:out>
    <c:out value="${u.id_u}"></c:out>
    <c:out value=" dodany!"></c:out>
  </c:if>
  <jsp:include page="_addUser.jsp"></jsp:include>
  <%
      }
      if (u.getRole().getId_r() == 1) {
  %>
  <jsp:include page="_points.jsp"></jsp:include>
  <c:if test="${err}">
    <p>${errMessage}</p>
  </c:if>
  <%
      }
  %>
  <c:url value="/user/basket/show" var="basket"></c:url>
  <form:form path="${basket}" action="${basket}">
    <input type="submit" name="basket" value="Koszyk" />
  </form:form>
  <br />
  <br />
  <br />
  <table>
    <c:url value="/user/basket" var="url"></c:url>
    <c:forEach items="${list}" var="it">
      <tr>
        <form:form path="${url}" action="${url}">
          <td><span class="item">${it.name} (${it.cost} pkt)</span> <br /> <input type="number" name="amount"
            value="0" min="0"> <input type="hidden" name="id" value="${it.id_i}" /> <input type="submit"
            name="add" value="Dodaj" /></td>
        </form:form>
      </tr>
    </c:forEach>
  </table>
</body>
</html>