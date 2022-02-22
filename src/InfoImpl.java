import java.rmi.*;
import java.rmi.registry.*;
import java.io.*;

public class InfoImpl implements Info_itf, Serializable{
    static String name;

    public InfoImpl(String nameC){
        name = nameC;
        return;
    }

	public String getName() throws RemoteException{
        System.out.println("Scrogneugneu");
		return name;
	}
}
