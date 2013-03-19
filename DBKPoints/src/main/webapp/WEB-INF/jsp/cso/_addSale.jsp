<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<body>
  <form:form method="POST" action="/DBKPoints/sale/add" modelAttribute="invoice">
    <table>
      <tr>
        <td><form:label path="amount">Wartość:</form:label></td>
      </tr>
      <tr>
        <td><form:input path="amount" /></td>
      </tr>
      <tr>
        <td><form:label path="extra">Punkty dodatkowe:</form:label></td>
      </tr>
      <tr>
        <td><form:input path="extra" /></td>
      </tr>
      <tr>
        <td><form:label path="user_id">Nr klienta:</form:label></td>
      </tr>
      <tr>
        <td><form:input path="user_id" /></td>
      </tr>
      <tr>
        <td><form:label path="invoiceSalePoint_id">Punkt Sprzedaży:</form:label></td>
      </tr>
      <tr>
        <td><form:select path="invoiceSalePoint_id" size="1">
            <form:options items="${sps}" itemValue="id_sp" />
          </form:select></td>
      </tr>
      <tr>
        <td><input type="submit" value="Wyślij"></td>
      </tr>
    </table>
  </form:form>
</body>
</html>
