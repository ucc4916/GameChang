package bean;

public class ActionForward {
	private boolean isRedirect=false;
	private String path=null;
	
	//필드가 boolean타입이라 get대신 is붙음 
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
