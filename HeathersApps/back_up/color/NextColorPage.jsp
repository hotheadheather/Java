<jsp:useBean id="user" class="user.GlassData" scope="session"/> 
<HTML>
<BODY>
You entered<BR>
Color: <%= user.getUsercolor() %><BR>
ColorID: <%= user.getColorid() %><BR>
Kilo: <%= user.getKg() %><BR>

<A HREF="GetColorName.jsp">Return to Home Page</A>
</BODY>
</HTML>