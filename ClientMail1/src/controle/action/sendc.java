package controle.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.mail.MailServerStub;
import service.mail.MailServerStub.GetMessages;
import service.mail.MailServerStub.Message;
import service.mail.MailServerStub.SendMessage;
import service.mail.MailServerStub.SendMessageResponse;

/**
 * Servlet implementation class sendc
 */
public class sendc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String top=request.getParameter("cpt1");
		String messagep=request.getParameter("cpt2");
		String fromp="client1";
		String action=request.getParameter("hdnbt");
		
		RequestDispatcher dispatcher;
		
		if(top.equals("")||messagep.equals("")||fromp.equals(""))
		{
		
			System.out.println("Erreur");
	
		}
		else
		{
			MailServerStub stub=new MailServerStub();
			SendMessage send=new SendMessage();
			send.setTop(top);
			send.setFromp(fromp);
			send.setMessagep(messagep);
			SendMessageResponse adress=stub.sendMessage(send);
			String result=adress.get_return();	
			response.sendRedirect("MessageOk.html");
			//dispatcher = request.getRequestDispatcher("MessageRecu.jsp");
			
			System.out.println(result);
			
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
					System.out.println(" "+msgs[i].getFrom()+" "+msgs[i].getTo()+" "+msgs[i].getMessage()+" "+msgs[i].getPriority()+" ");
						}catch(Exception e){
							i++;
						}
					
					i++;
					}
		}
	
	}

}
