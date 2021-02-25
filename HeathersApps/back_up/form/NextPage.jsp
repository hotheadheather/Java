<jsp:useBean id="user" class="user.UserData" scope="session"/> 
<HTML>
<BODY>
You entered<BR>
Name: <%= user.getUsername() %><BR>
Email: <%= user.getEmail() %><BR>
Age: <%= user.getAge() %><BR>

<A HREF="GetName.jsp">Return to Home Page</A>
</BODY>
</HTML>