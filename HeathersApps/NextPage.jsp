<jsp:useBean id="user" class="user.UserData" scope="session"/> 
<HTML>
<BODY>
You entered<BR>
<!--Name: <%= user.getUsername() %><BR>
Email: <%= user.getEmail() %><BR> -->
Inventory ID: <%= user.getInventoryid() %><BR>
Kg Supply: <%= user.getKg() %><BR>
Color Name: <%= user.getColor() %><BR>
Form: <%= user.getPhysicalform() %><BR>
Reducing: <%= user.getReducingprop() %><BR>
Striking: <%= user.getStrikingprop() %><BR>
Transparency: <%= user.getColortransparency() %><BR>
Adventurine: <%= user.getAdventurinetype() %><BR>
Cost per kg: <%= user.getCostperkg() %><BR>
<!--Age: <%= user.getAge() %><BR>-->




<A HREF="GetName.jsp">Return to Home Page</A>
</BODY>
</HTML>