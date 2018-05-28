<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="service.mail.MailServerStub" %>
 <%@ page import="service.mail.MailServerStub.GetMessages" %>
 <%@ page import="service.mail.MailServerStub.Message" %>
 <%@ page import="service.mail.MailServerStub.SendMessage" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
<center>
<div style="font-size:27px;">Welcome To Your Email Account</div>
<br>
</center>

<div>
<form action="upc" method="POST">

</form>
<input type="button" value="Add" name="add" onclick="location.href='sendmsg.jsp';" style="width:100px;"><br>
<form action="firstc" method="GET">
<input type="submit" value="Delete All" name="deleteall" style="width:100px;">
</form>
<form action="firstc" method="POST">
<input type="submit" value="Delete" name="a" style="width:100px;"><br>
<input type="submit" value="Update" name="a" style="width:100px;">
</div>
<div>
<center>


<table>
<tr style="color:#FFF;font-size:20px;background:#697BC2;text-align:center;"><td style="width:80px;">From</td><td style="width:80px;">To</td><td style="width:120px;">Message</td><td style="width:80px;">Priority</td><td style="width:80px;">Select</td></tr>
<%
MailServerStub smb=new MailServerStub();
//SendMessage sm= new SendMessage();
//sm.setFromp("amar1");
//sm.setTop("ok");
//sm.setMessagep("hello");
//String res=smb.sendMessage(sm).get_return();
//System.out.println(res);
		GetMessages gm= new GetMessages();
		gm.setTo("client1");
		Message[] msgs = smb.getMessages(gm).get_return();
		int size=msgs.length;
		int i=0;
		while(i<size){
			try{
			String prop=msgs[i].getPriority();
			String val="";
            if(prop.equals("Normal")){
				 val="<input type='checkbox' name='boxes' value='N' checked/>Normal<input type='checkbox' name='boxes' value='S'/>Haute";
			}
            else{
            val="<input type='checkbox' name='boxes' value='N' />Normal<input type='checkbox' name='boxes' value='S' checked/>Haute";
        			
            }
		out.println("<tr style='text-align:center;'><td><a href='sendmsg.jsp'>"+msgs[i].getFrom()+"</a></td><td>"+msgs[i].getTo()+"</td><td>"+msgs[i].getMessage()+"</td><td>"+val+"</td><td><input name='b' type='radio' value='"+msgs[i].getMessage()+"'/></td></tr>");
			//System.out.println(prop);
			}catch(Exception e){
				i++;
			}
		
		i++;
		}
		//System.out.println(msgs[0].getFrom());

%>
</table>
</center>
</div>
</form>

</body>
</html>