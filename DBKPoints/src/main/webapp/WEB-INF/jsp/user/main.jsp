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
<!--   <p> -->
<%--     <c:if test="${ok}"> --%>
<%--       <c:out value="Dodano użytkownika. Nr karty: "></c:out> --%>
<%--       <c:out value="${newUserId}"></c:out> --%>
<%--     </c:if> --%>
<!--   </p> -->
  <%
      User u = (User) session.getAttribute(Constants.USER);
      if (u.getRole().getId_r()>1) {
  %>
  <jsp:include page="_addUser.jsp"></jsp:include>
  <%
      }
  %>
</body>
</html>