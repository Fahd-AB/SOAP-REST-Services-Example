package service.mail;

public class testmail {

	public static void main(String[] args) {
		//getvector
		 
	 
		 
		 MailServer Ms=new MailServer();
		 Ms.sendMessage("ammar", "mohamed", "hello");
		 Ms.sendMessage("mohamed", "ali", "hi yourself");
		 Ms.sendMessage("alex", "ali", "hi yourself");
		 Ms.sendMessage("ali", "test", "hi yourself");
		 Ms.sendMessage("ali", "ali", "hi yourself");
		
		
		 Ms.getmes();
		 Ms.getMessages("mohamed");
		 String rep=Ms.removeMessages("mohamed");
		 System.out.println(rep);
		 Ms.getmes();

	}

}
