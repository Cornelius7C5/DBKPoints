<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec"%><!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>DBK Points - <dec:title /></title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="<c:url value="/css/main.css"/>" rel="stylesheet" type="text/css" />
</head>
<body>
  <div id="wrapper">
    <div id="header">
      <img alt="Logo" src="http://lorempixel.com/120/120/technics/4/DBKPoints/">
    </div>
    <div id="content">
      <dec:body />
    </div>
    <div id="Footer">
      <p>CopyrightbyKO</p>
    </div>
  </div>
</body>
</html>