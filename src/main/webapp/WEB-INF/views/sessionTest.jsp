<%@ page import="com.sunshine.shine.dao.model.User" %>
<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>你好</title>
</head>
<body>
<h1>rose</h1>rin
<%
    User user = (User)session.getAttribute("user");
    Integer id = (Integer)session.getAttribute("id_new");
    out.print("<br>user_name="+user.getName());
    out.print("<br>id="+id);
%>
</body>
</html>
