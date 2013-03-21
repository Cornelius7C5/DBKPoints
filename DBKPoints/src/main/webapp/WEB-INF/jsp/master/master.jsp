<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec"%><!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>DBK Points - <dec:title /></title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<jsp:include page=""></jsp:include>
<style type="text/css">
@import url("../../css/main.css");
</style>
<link href="<c:url value="/css/main.css"/>" rel="stylesheet" type="text/css" />
</head>
<body>
  <div id="wrapper">
    <div id="header">
      <a href="<c:url value="/"/>"><img title="Strona Główna" alt="Logo"
        src="http://lorempixel.com/120/120/technics/4/DBKPoints/"></a> <a href="<c:url value="/logout" />">
        Wyloguj</a>
      <p>Zalogowany jako ${hello}</p>
      <hr>
    </div>
    <div id="content">
      <dec:body />
    </div>
    <div id="footer">
      <p>Copyright by KO</p>
    </div>
  </div>
</body>
</html>