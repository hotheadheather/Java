<jsp:useBean id="glass" class="glass.GlassData" scope="session"/> 

<HTML>
<HEAD> JSP Forms for Glassblowing Colors</HEAD>
<BODY>
<FORM METHOD=POST ACTION="GetColorCheck.jsp">
What's your Color? <INPUT TYPE=TEXT NAME=color VALUE=<%= user.getColorname() %> SIZE=20> <BR>
What's is the Color ID? <INPUT TYPE=TEXT NAME=colorid VALUE=<%= user.getColorid() %> SIZE=20> <BR>
How many kilos? <INPUT TYPE=TEXT NAME=kg VALUE=<%= user.getKg() %> SIZE=4>
<P><INPUT TYPE=SUBMIT>
</FORM>
</BODY>
</HTML> 