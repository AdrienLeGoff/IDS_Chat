import java.rmi.*;
import java.rmi.registry.*;
import java.io.*;

public class AccountingImpl implements Serializable, Accounting_itf {
    
    public void numberOfCalls(int number) throws RemoteException{
        System.out.println("Nous avons atteint le fabuleux palier de " + number + " appels !");
    }
}
