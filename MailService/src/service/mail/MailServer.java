package service.mail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;
import javax.swing.JOptionPane;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;
public class MailServer{
	
	Connection con;
	 PreparedStatement pst;
	 ResultSet re;
	 Vector<Message> messages=new Vector<Message>();
	 Message[] msgs=new Message[10];
	 int size=0;
	    
	   public String sendMessage(String fromp, String top, String messagep){
		   Message m=new Message(fromp, top, messagep);
		  
		    Calendar cal = Calendar.getInstance();
	        SimpleDateFormat sdf = new SimpleDateFormat("HH");
	        int h=Integer.parseInt(sdf.format(cal.getTime()));
	        if((h<24)&&(h>20)){
	        	 m.setPriority("Haute");	
	        }
	        else{
	        	 m.setPriority("Normal");
	        }
		   
		   
		   msgs[size]=m;
		   size++;
		   //messages.addElement(m);
		
		   
		   try{
			   Class.forName("com.mysql.jdbc.Driver");
		       Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mail","root","");
		       Statement stmt = (Statement) connect.createStatement();
		       String sql = "insert into mailmessage values(0,'"+fromp+"','"+top+"','"+messagep+"','true','Normal')";
		        stmt.executeUpdate(sql);
		       connect.close();
		       connect=null;
		       stmt=null;
		       
		      } catch (Exception e) {
		       e.printStackTrace();
		      }
		   
		   
		  
	       return ("Message sent successfully");
	    }
	    
	  
	   
	    public Message[] getMessages(String to){
	    	
	    	Message[] mesmessage=new Message[20];
	    	int j=0;
	    	
	    	//sendMessage("ok","ok","ok");
	    	//sendMessage("ammar","ok","ok");
	     
	    	 try{
				   Class.forName("com.mysql.jdbc.Driver");
			       Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mail","root","");
			       Statement stmt = (Statement) connect.createStatement();
			       String sql = "select * from mailmessage where Top='"+to+"'";
			       ResultSet rs = stmt.executeQuery(sql);
			       while (rs.next()) {
			    	   String fromp = rs.getString("fromp");
			    	   String top = rs.getString("Top");
			    	   String messagep = rs.getString("messagep");
			    	   String priority = rs.getString("priority");
			    	   Message m=new Message(fromp, top, messagep);
					   m.setPriority(priority);
			    	     mesmessage[j]=m;
		    			 mesmessage[j].setNew(false);
		    			 j++;
			    	   }
			       connect.close();
			       connect=null;
			       stmt=null;
			       
			      } catch (Exception e) {
			       e.printStackTrace();
			      }
			   
	    	
	    	
	    	/*
	    	
	    	int i=0;
	     
	    	while(i<size){
	    		
	    		if(msgs[i].getTo().equals(to)){
	    			//msgs[i].setNew(false);
	    			 mesmessage[j]=new Message(msgs[i].getFrom(),to,msgs[i].getMessage());
	    			 mesmessage[j].setNew(false);
	    			j++; 
	    		}
	    		
	    		i++;
	    	}
	    	 */
	    	//mesmessage[0]=new Message("ok","ok","ok");
	    	return mesmessage;
	    }
	
	    
	    
	    
	    
	  public String removeMessages (String to){
	    	
		int oldMessageNumber=0;
		
		
		
		 try{
			   Class.forName("com.mysql.jdbc.Driver");
		       Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mail","root","");
		       Statement stmt = (Statement) connect.createStatement();
		       String sql = "select * from mailmessage where Top='"+to+"' and isnew='false'";
		       ResultSet rs = stmt.executeQuery(sql);
		       ResultSetMetaData res = (ResultSetMetaData) rs.getMetaData ();
		       int nbcol = res.getColumnCount ();
		       
		    	   oldMessageNumber=nbcol;
		    	   
		       connect.close();
		       connect=null;
		       stmt=null;
		       
		      } catch (Exception e) {
		       e.printStackTrace();
		      }
		   
		
		
		
		
		
		
		
		
		
		
		
		 
		
		
		if(oldMessageNumber==0)
		   return ("No old messages");
		else{
			try{
				   Class.forName("com.mysql.jdbc.Driver");
			       Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mail","root","");
			       Statement stmt = (Statement) connect.createStatement();
			       String sql = "delete from mailmessage where Top='"+to+"' and isnew='false'";
			        stmt.executeUpdate(sql);
			       connect.close();
			       connect=null;
			       stmt=null;
			       
			      } catch (Exception e) {
			       e.printStackTrace();
			      }
			   
			
		   return ("Old messages removed successfully");
	    }

}
	    
	    
	   
	  
	    public void getmes(){
	    	Iterator it=messages.iterator();
	        Message Resp=null;
			while(it.hasNext()){
			 Message M=(Message)it.next();
			 System.out.println(M.getFrom()+" "+M.getTo()+" "+M.getMessage());
			}
			
	    }

	    
	    public String suppMessage(String id){
	    	try{
				   Class.forName("com.mysql.jdbc.Driver");
			       Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mail","root","");
			       Statement stmt = (Statement) connect.createStatement();
			       String sql = "delete from mailmessage where messageP='"+id+"'";
			        stmt.executeUpdate(sql);
			       connect.close();
			       connect=null;
			       stmt=null;
			       
			      } catch (Exception e) {
			       e.printStackTrace();
			      }
			   
	    	return "Mail Deleted";
	    }
	    
	    
	    public String upMessage(String id, String text){
	    	try{
				   Class.forName("com.mysql.jdbc.Driver");
			       Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mail","root","");
			       Statement stmt = (Statement) connect.createStatement();
			       String sql = "update mailmessage set priority='"+text+"' where messagep='"+id+"'";
			        stmt.executeUpdate(sql);
			       connect.close();
			       connect=null;
			       stmt=null;
			       
			      } catch (Exception e) {
			       e.printStackTrace();
			      }
			   
	    	return "Mail Updated";
	    }
	    
	    
}
