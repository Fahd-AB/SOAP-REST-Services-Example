package service.auth;
 
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
 
 
public class authservice extends ServerResource{
 
	 public String log="client1";
	 public String mdp="0000";
	 
	 
	@Get
	public String auth(String login,String mdp){
		String l= getQueryValue("log").toString();
		String m= getQueryValue("m").toString();
		
		String verif="";
		if((l.equals(this.log))&&(m.equals(this.mdp))){
			verif="ok";
			
		}
		else{
			verif="non";
			 
		}
		
		
		return verif;
	}
 
}