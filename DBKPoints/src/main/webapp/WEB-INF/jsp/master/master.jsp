<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<!DOCTYPE html>
<html>
<head>
    
<title><decorator:title default="DBK Points" /></title>     
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<decorator:head />
</head>
<body>
   
  <div id="wrapper">
    <div id="header">
              
      <h1>Hello</h1>
          
    </div>
          
    <div id="content">
              
      <decorator:body />
          
    </div>
          
    <div id="Footer">
              
      <h2>Copyright by KO</h2>
          
    </div>
  </div>
   
</body>
</html>