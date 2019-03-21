<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
	<title>IBM Web Crawler - Results</title>
    <link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css//style.css" rel="stylesheet">
</head>

<body>
	<br>
		<center>
			<h1>IBM Web Crawler - Results</h1>
		</center>
	<br>
		
	<c:forEach items="${URLForm.URLS}" var="URL">
	ID = ${URL.id} | Depth = ${URL.depth} | URL =  ${URL.URL}  </br>
	</c:forEach>
	
    <script src="<%=request.getContextPath()%>/resources/js/jquery-2.1.1.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/animated-headline.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/isotope.pkgd.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/custom.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/modernizr.js"></script>
		
</body>
</html>
