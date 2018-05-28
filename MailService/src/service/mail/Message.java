package service.mail;

import java.io.Serializable;

public class Message implements Serializable{
 
	 private String message="";
	    private String from;
	    private String to;
	    private boolean isNew;
	    private String Priority;
	    

		public Message(String fromp, String top, String messagep){
		this.from=fromp;
		this.to=top;
		this.message=messagep;
		this.isNew=true;
		this.Priority="";
	    }


		public String getMessage() {
			return message;
		}


		public void setMessage(String message) {
			this.message = message;
		}


		public String getFrom() {
			return from;
		}


		public void setFrom(String from) {
			this.from = from;
		}


		public String getTo() {
			return to;
		}


		public void setTo(String to) {
			this.to = to;
		}


		public boolean isNew() {
			return isNew;
		}


		public void setNew(boolean isNew) {
			this.isNew = isNew;
		}


		public String getPriority() {
			return Priority;
		}


		public void setPriority(String priority) {
			Priority = priority;
		}
	    
	   
	    
}
