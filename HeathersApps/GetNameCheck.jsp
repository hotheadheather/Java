<%@ page import="java.sql.*" %>
<jsp:useBean id="user" class="user.UserData" scope="session"/> 

<%

String iName = request.getParameter("username");
String iEmail = request.getParameter("email");
String iInventoryid = request.getParameter("inventoryid");
String iKg = request.getParameter("kg");
int kg = 0;
String iColor = request.getParameter("color");
String iPhysicalform = request.getParameter("physicalform"); 
int physicalform = 0;
String iReducingprop = request.getParameter("reducingprop"); 
String iStrikingprop = request.getParameter("strikingprop"); 
String iColortransparency = request.getParameter("colortransparency"); 
String iAdventurinetype = request.getParameter("adventurinetype");
String iCostperkg = request.getParameter("costperkg"); 
int costperkg= 0; 
String iAge = request.getParameter("age");
int age = 0;

//if (iName == null || iName.length() == 0) {
//response.sendRedirect("GetNameError.jsp");
//return;
//}

//if ((iPhysicalform => 5) || (iPhysicalform <= 0)) {
//response.sendRedirect("GetNameError.jsp");
//return;
//}

//try{
//age = Integer.parseInt(iAge);
//}

//catch(Exception e) {
//response.sendRedirect("GetNameError.jsp");
//return;
//}

user.setUsername(iName);
user.setEmail(iEmail);
user.setInventoryid(iInventoryid);
user.setKg(kg);
user.setColor(iColor);
user.setPhysicalform(physicalform);
user.setReducingprop(iReducingprop);
user.setStrikingprop(iStrikingprop);
user.setColortransparency(iColortransparency);
user.setAdventurinetype(iAdventurinetype);
user.setCostperkg(costperkg);


response.sendRedirect("SaveName.jsp");
%>

<%!
private static void loadDriver() {
 try {
 Class.forName("com.mysql.jdbc.Driver");
 System.out.println("Driver loaded");
 } catch (Exception ex) {
 System.out.println("Driver error");
 }
}
%>
<%

try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/GLASS_DATABASE", "root", "");
Statement st=conn.createStatement();

int i=st.executeUpdate("insert into profile(inventoryid, supplykg, colorname,physicalform, reducingprop, strikingprop, colortransparency, adventurinetype, costperkg )values('"+iInventoryid+"','"+kg+"','"+iColor+"','"+physicalform+"','"+iReducingprop+"','"+iStrikingprop+"','"+iColortransparency+"','"+iAdventurinetype+"','"+costperkg+"')");
out.println("Data is successfully inserted!");
}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
%>

