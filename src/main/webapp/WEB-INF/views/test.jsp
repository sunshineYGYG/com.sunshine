<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>���</title>
</head>
<body>
<h1>rose</h1>
<%
    System.out.println("sunshine");
    session.setAttribute("id",2);
    response.sendRedirect("../test/testSession");
%>
</body>
</html>
