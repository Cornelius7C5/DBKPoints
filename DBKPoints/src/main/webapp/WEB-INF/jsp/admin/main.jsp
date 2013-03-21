<%@ page import="pl.spot.dbk.points.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
<title>Panel Administratora</title>
<meta name="section" content="About" />
</head>
<body>
  <table>
    <tr>
      <td>
        <a href="sales">Sprzedaże</a>
      </td>
      <td>
        <a href="<c:url value="list"><c:param name="type" value="<%=Constants.SALE%>"></c:param></c:url>">Lista</a>
      </td>
    </tr>
    <tr>
      <td>
        <a href="users">Nowy użytkownik</a>
      </td>
      <td>
        <a href="<c:url value="list"><c:param name="type" value="<%=Constants.USER%>"></c:param></c:url>">Lista</a>
      </td>
    </tr>
    <tr>
      <td>
        <a href="item">Nowy przedmiot</a>
      </td>
      <td>
        <a href="<c:url value="list"><c:param name="type" value="<%=Constants.ITEM%>"></c:param></c:url>">Lista</a>
      </td>
    </tr>
    <tr>
      <td>
        <a href="sp">Nowy oddział</a>
      </td>
      <td>
        <a href="<c:url value="list"><c:param name="type" value="<%=Constants.SP%>"></c:param></c:url>">Lista</a>
      </td>
    </tr>
    <tr></tr>
    <tr>
      <td>
      <td>
        <c:url value="/cso/" var="url"></c:url>
        <form:form path="${url}" action="${url}">
          <input type="text" name="id">
          <input type="submit" value="Sprawdź" name="check">
        </form:form>
      </td>
      <td>
        <a href="<c:url value="list"><c:param name="type" value="<%=Constants.ORDER%>"></c:param></c:url>">Lista</a>
      </td>
    </tr>
  </table>
</body>
</html>