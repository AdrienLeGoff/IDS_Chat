
import java.rmi.*;

public  class HelloImpl implements Hello {

	private String message;
 
	public HelloImpl(String s) {
		message = s ;
	}

	/*
	public String sayHello() throws RemoteException {
		return message ;
	}
	*/
	
	@Override
	public String sayHello(String clientName) {
		System.out.println("Bonjour " + clientName);
		return message;
	}
	
	@Override
	public String sayHello(Info_itf client) {
		try {
			System.out.println("Bonjour " + client.getName());		
		} catch (Exception e) {
			System.err.println("Error on Server : " + e);
		}
		return message;
	}
}

