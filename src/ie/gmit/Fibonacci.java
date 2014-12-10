package ie.gmit;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class Fibonacci extends UnicastRemoteObject implements RemoteFibonacci {

	private static final long serialVersionUID = 1L;

	public Fibonacci() throws RemoteException {
	}

	public String getFibonacciSequence(int max) throws RemoteException {
		StringBuffer fibSequence = new StringBuffer();
		for (int i = 0; i < max; i++) {
			fibSequence.append(String.valueOf(fib(i)) + ", ");
		}
		fibSequence.deleteCharAt(fibSequence.length() - 2);
		return fibSequence.toString();
	}

	//if ues Recursion, the length cannot over 44 and Recursion is too slow
	static long fib(long n) {
		long c = -1, a = 0, b = 1;
		for (int i = 0; i <= n; i++) {
			if (i == 0)
				c = a;
			else if (i == 1)
				c = b;
			else {
				c = a + b;
				a = b;
				b = c;
			}
		}
		return c;
	}
}