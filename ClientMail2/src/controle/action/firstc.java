package controle.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.mail.MailServerStub;
import service.mail.MailServerStub.RemoveMessages;
import service.mail.MailServerStub.RemoveMessagesResponse;
import service.mail.MailServerStub.SuppMessage;
import service.mail.MailServerStub.SuppMessageResponse;
import service.mail.MailServerStub.UpMessage;
import service.mail.MailServerStub.UpMessageResponse;

/**
 * Servlet implementation class firstc
 */
public class firstc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firstc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MailServerStub stub=new MailServerStub();
		RemoveMessages send=new RemoveMessages();
		send.setTo("client2");
		 
		 RemoveMessagesResponse adress=stub.removeMessages(send);
		String result=adress.get_return();	
		System.out.println(result);
		response.sendRedirect("SucessRemove.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String valueofbtn1=request.getParameter("add");
				String valueofbtn2=request.getParameter("a");
				//System.out.println(valueofbtn2);
				//String valueofbtn3=request.getParameter("update");
				//if(valueofbtn1.equals("Add")){
					//response.sendRedirect("sendmsg.jsp");
				//}
				
				if("Delete".equals(valueofbtn2)){
					String valueofradio=request.getParameter("b");
					MailServerStub stub=new MailServerStub();
					SuppMessage supp=new SuppMessage();
					supp.setId(valueofradio);
					SuppMessageResponse adress=stub.suppMessage(supp);
					String result=adress.get_return();
					response.sendRedirect("SucessRemove.html");
					System.out.println(result);
					
				}
				 if("Update".equals(valueofbtn2) ){
					
					String valueofbox=request.getParameter("boxes");
					String valueofradio=request.getParameter("b");
					//System.out.println("up "+valueofradio);
					String nvstat="";
					if("N".equals(valueofbox)){
						nvstat="Normal";
					}
					else{
						nvstat="Haute";
					}
					
					MailServerStub stub=new MailServerStub();
					UpMessage upp=new UpMessage();
					upp.setId(valueofradio);
					upp.setText(nvstat);
					
					UpMessageResponse adress=stub.upMessage(upp);
					String result=adress.get_return();
					System.out.println(result);
					response.sendRedirect("SuccesUpdate.html");
					
					
				
				
			
		}
	}

}
