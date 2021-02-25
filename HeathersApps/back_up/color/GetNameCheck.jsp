<%@ page import="java.sql.*" %>
<jsp:useBean id="user" class="user.UserData" scope="session"/> 

<%

String iName = request.getParameter("username");
String iColor = request.getParameter("color");
String iAge = request.getParameter("age");
int age = 0;

if (iName == null || iName.length() == 0) {
response.sendRedirect("GetNameError.jsp");
return;
}

try{
age = Integer.parseInt(iAge);
}

catch(Exception e) {
response.sendRedirect("GetNameError.jsp");
return;
}

user.setUsername(iName);
user.setColor(iColor);
user.setAge(age);
response.sendRedirect("SaveName.jsp");

%>

