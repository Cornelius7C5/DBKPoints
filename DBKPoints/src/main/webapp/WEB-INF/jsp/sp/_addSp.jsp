<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<body>
  <form:form method="POST" action="/DBKPoints/sp/add" modelAttribute="sp">
    <table>
      <tr>
        <td><form:label path="name">Nazwa:</form:label></td>
      </tr>
      <tr>
        <td><form:input path="name" /></td>
      </tr>
      <tr>
        <td><input type="submit" value="Wyślij"></td>
      </tr>
    </table>
  </form:form>
</body>
</html>