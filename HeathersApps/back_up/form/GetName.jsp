<jsp:useBean id="user" class="user.UserData" scope="session"/> 

<HTML>
<HEAD> JSP Forms for Glassblowing Colors</HEAD>
<BODY>
<FORM METHOD=POST ACTION="GetNameCheck.jsp">
What's your name? <INPUT TYPE=TEXT NAME=username VALUE=<%= user.getUsername() %> SIZE=20> <BR>
What's your e-mail address? <INPUT TYPE=TEXT NAME=email VALUE=<%= user.getEmail() %> SIZE=20> <BR>
What's your age? <INPUT TYPE=TEXT NAME=age VALUE=<%= user.getAge() %> SIZE=4>
<P><INPUT TYPE=SUBMIT>
</FORM>
</BODY>
</HTML> 