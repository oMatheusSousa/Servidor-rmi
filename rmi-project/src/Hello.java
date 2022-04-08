import java.rmi.*;
 
public interface Hello extends Remote {
   public Double calc(double a, double b, double c) throws RemoteException;
}