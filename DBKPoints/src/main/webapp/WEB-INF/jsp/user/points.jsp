<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table>
  <tr>
    <td>Punkty -</td>
  </tr>
  <tr>
    <td>- dostępne:</td>
    <td><c:out value="${avPoints}"></c:out></td>
  </tr>
  <tr>
    <td>- zablokowane:</td>
    <td><c:out value="${blPoints}"></c:out></td>
  </tr>
  <tr>
    <td>- ogółem:</td>
    <td><c:out value="${points}"></c:out></td>
  </tr>
</table>
