<%@page import="pl.spot.dbk.points.server.hib.User"%>
<%@page import="pl.spot.dbk.points.Constants"%>
<%@ page
  language="java"
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib
  prefix="c"
  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib
  uri="http://www.springframework.org/tags/form"
  prefix="form"%>
<%@ taglib
  uri="http://java.sun.com/jsf/html"
  prefix="h"%>
<%@ taglib
  uri="http://java.sun.com/jsf/core"
  prefix="f"%>
<%@ taglib
  uri="http://java.sun.com/jsf/facelets"
  prefix="ui"%>
<%-- <%@ taglib --%>
<%--   uri="" --%>
<%--   prefix=""%> --%>
<%@ taglib
  uri="http://primefaces.org/ui"
  prefix="p"%>
<html
  xmlns="http://www.w3.org/1999/xhtml"
  xmlns:h="http://java.sun.com/jsf/html"
  xmlns:f="http://java.sun.com/jsf/core"
  xmlns:ui="http://java.sun.com/jsf/facelets"
  xmlns:p="http://primefaces.org/ui">
<head>
<title>Użytkownik</title>
<meta
  name="section"
  content="About" />
<meta
  http-equiv="Content-Type"
  content="text/html; charset=UTF-8">
</head>
<body>
  <h:form>
    <p:editor value="" />
  </h:form>
  <%
      User u = (User) session.getAttribute(Constants.USER);
      if (u.getRole().getId_r() > 10) {
  %>
  <c:if test="${ok}">
    <c:out value="${u.role.name} "></c:out>
    <c:out value="${u.name} ${u.surname}"></c:out>
    <c:out value=" o numerze karty : "></c:out>
    <c:out value="${u.id_u}"></c:out>
    <c:out value=" dodany!"></c:out>
  </c:if>
  <c:if test="${add}">
    <jsp:include page="_addUser.jsp"></jsp:include>
  </c:if>
  <%
      }
  %>
  <c:if test="${err}">
    <p>${errMess}</p>
  </c:if>
  <c:if test="${!err}">
    <c:if test="${!add}">
      <jsp:include page="_points.jsp"></jsp:include>
      <c:url
        value="/user/basket/show"
        var="basket"></c:url>
      <form:form
        path="${basket}"
        action="${basket}">
        <input
          type="submit"
          name="basket"
          value="Koszyk" />
      </form:form>
      <br />
      <br />
      <br />
      <table>
        <c:url
          value="/user/basket"
          var="url"></c:url>
        <c:forEach
          items="${list}"
          var="it">
          <tr>
            <form:form
              path="${url}"
              action="${url}">
              <td>
                <span class="item">${it.name} (${it.cost} pkt)</span> <br />
                <input
                  type="number"
                  name="amount"
                  value="0"
                  min="0">
                <input
                  type="hidden"
                  name="id"
                  value="${it.id_i}" />
                <input
                  type="submit"
                  name="add"
                  value="Dodaj" />
              </td>
            </form:form>
          </tr>
        </c:forEach>
      </table>
      <br />
      <br />
      <br />
      <br />
      <table>
        <tr>
          <th>Data zamówienia</th>
          <th>Miejsce rejestracji</th>
          <th>Status</th>
          <th>Anuluj</th>
        </tr>
        <c:url
          value="/user/order"
          var="delOrderUrl"></c:url>
        <c:forEach
          items="${orders}"
          var="o">
          <tr>
            <td>
              <a href="<c:url value="/order/${o.id_o}"/>">${o.date}</a>
            </td>
            <td>
              <a href="<c:url value="/order/${o.id_o}"/>">${o.salePoint.name}</a>
            </td>
            <td>
              <a href="<c:url value="/order/${o.id_o}"/>">${o.status.name}</a>
            </td>
            <td>
              <c:if test="${o.status.id_s==2}">
                <form:form
                  path="${delOrderUrl}"
                  action="${delOrderUrl }">
                  <input
                    type="hidden"
                    name="id_o"
                    value="${o.id_o}" />
                  <input
                    type="submit"
                    name="delete"
                    value="Anuluj" />
                </form:form>
              </c:if>
            </td>
          </tr>
        </c:forEach>
      </table>
    </c:if>
  </c:if>
</body>
</html>