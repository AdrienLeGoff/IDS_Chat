import java.rmi.*; 
import java.rmi.server.*; 
import java.rmi.registry.*;

public class HelloClient{

	public static void main(String [] args) {
		
		try {
			if (args.length < 1) {
				System.out.println("Usage: java HelloClient <rmiregistry host>");
				return;
			}
	
			String host = args[0];

			// Get remote object reference
			Registry registry = LocateRegistry.getRegistry(host); 
			Hello h = (Hello) registry.lookup("HelloService");

			// Remote method invocation
			// Methode 1
			//String res = h.sayHello("JE S'APPELLE GROOT");
			// Methode 2
			InfoImpl client = new InfoImpl("JE S'APPELLE GROOT");
			Info_itf i_stub = (Info_itf) UnicastRemoteObject.exportObject(client, 0);

			for (int i = 0; i < 20; i++ ){
				String res = h.sayHello(client);
				System.out.println(res);
			}
	
		} catch (Exception e)  {
			System.err.println("Error on client: " + e);
		}
	}
}
