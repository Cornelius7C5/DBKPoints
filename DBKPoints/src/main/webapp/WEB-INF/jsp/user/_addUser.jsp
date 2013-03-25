<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form method="POST" action="/DBKPoints/user/add" modelAttribute="user">
  <table>
    <tr>
      <td><form:label path="name">Imię/Imiona:</form:label></td>
    </tr>
    <tr>
      <td><form:input path="name" /></td>
    </tr>
    <tr>
      <td><form:label path="surname">Nazwisko:</form:label></td>
    </tr>
    <tr>
      <td><form:input path="surname" /></td>
    </tr>
    <tr>
      <td><form:label path="password">Hasło:</form:label></td>
    </tr>
    <tr>
      <td><form:password path="password" /></td>
    </tr>
    <tr>
      <td><form:label path="role_id">Rola:</form:label></td>
    </tr>
    <tr>
      <td><form:select path="role_id" size="1">
          <form:options items="${roles}" itemValue="id_r" />
        </form:select></td>
    </tr>
    <tr>
      <td><form:label path="registerPoint_id">Punkt Sprzedaży:</form:label></td>
    </tr>
    <tr>
      <td><form:select path="registerPoint_id" size="1">
          <form:options items="${sps}" itemValue="id_sp" />
        </form:select></td>
    </tr>
    <tr>
      <td><input type="submit" value="Wyślij"></td>
    </tr>
  </table>
</form:form>
