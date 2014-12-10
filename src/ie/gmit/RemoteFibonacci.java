package ie.gmit;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteFibonacci extends Remote{
	// accept length of the Fibonacci sequence from JSP page
	public String getFibonacciSequence(int max) throws RemoteException;

}
