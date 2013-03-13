<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Panel użytkowników</title>
</head>
<body>
  <c:forEach var="role" items="${roles}">
    <p>${role}</p>
  </c:forEach>
  
  <jsp:include page="_addUser.jsp"></jsp:include>
</body>
</html>