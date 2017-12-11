<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reservation</title>
</head>
<body>

	<p>Nom : <%=request.getParameter("nom")%></p>
	<p>Prénom : <%=request.getParameter("prenom")%></p>
	<p>Mail : <%=request.getParameter("mail")%></p>
	<p>Téléphone : <%=request.getParameter("tel")%></p>

</body>
</html>