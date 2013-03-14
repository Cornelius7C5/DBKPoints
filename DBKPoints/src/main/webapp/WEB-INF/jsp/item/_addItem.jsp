<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<body>
  <form:form method="POST" action="/DBKPoints/item/add" modelAttribute="item">
    <table>
      <tr>
        <td><form:label path="name">Nazwa:</form:label></td>
      </tr>
      <tr>
        <td><form:input path="name" /></td>
      </tr>
      <tr>
        <td><form:label path="cost">Koszt punktowy:</form:label></td>
      </tr>
      <tr>
        <td><form:input path="cost" /></td>
      </tr>
      <tr>
        <td><input type="submit" value="Dodaj"></td>
      </tr>
    </table>
  </form:form>
</body>
</html>