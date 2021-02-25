<jsp:useBean id="user" class="user.UserData" scope="session"/> 
<HTML>
<BODY>
You entered<BR>
Name: <%= user.getUsername() %><BR>
Color: <%= user.getColor() %><BR>
Age: <%= user.getAge() %><BR>

<A HREF="GetName.jsp">Return to Home Page</A>
</BODY>
</HTML>