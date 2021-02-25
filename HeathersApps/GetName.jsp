<jsp:useBean id="user" class="user.UserData" scope="session"/> 

<HTML>
<HEAD> JSP Forms for Glassblowing Colors</HEAD>
<BR><BR>
<BODY>
<FORM METHOD=POST ACTION="GetNameCheck.jsp">
<!--What's your name? <INPUT TYPE=TEXT NAME=username VALUE=<%= user.getUsername() %> SIZE=20> <BR>
What's your e-mail address? <INPUT TYPE=TEXT NAME=email VALUE=<%= user.getEmail() %> SIZE=20> <BR> -->
What is the inventory ID? ex: R00545R <INPUT TYPE=TEXT NAME=inventoryid VALUE=<%= user.getInventoryid() %> SIZE=20> <BR>
How many kilograms are in supply? <INPUT TYPE=TEXT NAME=kg VALUE=<%= user.getKg() %> <BR>
What is the color name? <INPUT TYPE=TEXT NAME=color VALUE=<%= user.getColor() %> SIZE=20> <BR>
What form would you like? 1-Frit 2-Bar 3-Powder 4-Shard <INPUT TYPE=TEXT NAME=physicalform VALUE=<%= user.getPhysicalform() %> SIZE=4><BR>
Does this color reduce? T or F<INPUT TYPE=TEXT NAME=reducingprop VALUE=<%= user.getReducingprop() %> SIZE=4><BR>
Does this color strike? T or F<INPUT TYPE=TEXT NAME=strikingprop VALUE=<%= user.getStrikingprop() %> SIZE=4><BR>
Is this color transparent? T or F<INPUT TYPE=TEXT NAME=colortransparency VALUE=<%= user.getColortransparency() %> SIZE=4><BR>
Is this color an adventurine type? T or F<INPUT TYPE=TEXT NAME=adventurinetype VALUE=<%= user.getAdventurinetype() %> SIZE=4><BR>
What's the cost per kilogram? <INPUT TYPE=TEXT NAME=costperkg VALUE=<%= user.getCostperkg() %> SIZE=4><BR>
<!--What's your age? <INPUT TYPE=TEXT NAME=age VALUE=<%= user.getAge() %> SIZE=4>-->
<P><INPUT TYPE=SUBMIT>
</FORM>
</BODY>
</HTML> 