<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head></head>
<body>
  <table>
    <tr>
      <td>Id:</td>
      <td>${order.id_o}</td>
    </tr>
    <tr>
      <td>Data przyjęcia:</td>
      <td>${order.date}</td>
    </tr>
    <tr>
      <td>Kupujący:</td>
      <td>${order.buyer.name} ${order.buyer.surname}</td>
    </tr>
    <tr>
      <td>Sprzedawca:</td>
      <td>${order.seller.name} ${order.seller.surname}</td>
    </tr>
    <tr>
      <td>Przedmioty:</td>
    </tr>
    <tr>
      <th>Nazwa</th>
      <th>Koszt</th>
      <th>Ilość</th>
    </tr>
    <c:forEach items="${order.basketItems}" var="b">
      <tr>
        <td>${b.id_item.name}</td>
        <td>${b.id_item.cost}</td>
        <td>${b.amount}</td>
      </tr>
    </c:forEach>
    <tr>
      <td><c:url value="/order/${order.id_o}" var="ord"></c:url> <form:form path="${ord}" action="${ord}">
          <select name="status">
            <c:forEach items="${statuses}" var="s">
              <option value="${s.id_s}"
                <c:if test="${s.id_s==order.status.id_s }">
    <c:out value="selected=\"selected\""></c:out>
              </c:if>>${s.name}</option>
            </c:forEach>
          </select>
          <input type="submit" value="Zmień" name="change">
        </form:form></td>
    </tr>
  </table>
</body>
</html>