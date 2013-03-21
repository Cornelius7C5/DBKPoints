<%@page import="pl.spot.dbk.points.MetaObject"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista</title>
<%
    ArrayList<MetaObject> list = (ArrayList<MetaObject>) request.getAttribute("list");
%>
</head>
<body>
 
  <table>
    <tr>
      <%
          if (list.get(0).show_id) {
      %>
      <th>Id</th>
      <%
          }

          if (list.get(0).show_name) {
      %><th>Nazwa</th>
      <%
          }

          for (String h : list.get(0).getKeyList()) {
      %><th><%=h%></th>
      <%
          }
      %>
    </tr>
    <%
        for (MetaObject mo : list) {
    %>
    <tr>
      <%
          if (mo.show_id) {
      %><td><a href="<%="uno" + request.getAttribute("type") + mo.getId()%>/"> <%=mo.getId()%>
      </a></td>
      <%
          }
              if (mo.show_name) {
      %><td><a href="<%="uno" + request.getAttribute("type") + mo.getId()%>/"> <%=mo.getName()%></a></td>
      <%
          }
              for (String s : mo.getKeyList()) {
      %><td><a href="<%="uno" + request.getAttribute("type") + mo.getId()%>/"> <%=mo.getExtraItem(s)%>
      </a></td>
      <%
          }

          }
      %>
    </tr>
  </table>
</body>
</html>