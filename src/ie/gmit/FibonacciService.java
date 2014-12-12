package ie.gmit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.*;

public class FibonacciService {

	public static void main(String[] args) {
	}

	// In-Queue
	private LinkedList<FibRequest> inQ = new LinkedList<FibRequest>();

	// Out-Queues
	private Map<Integer, String> outQ = new HashMap<Integer, String>();

	// generate jobnumber, and add it to inQ
	public int add(int max) {
		int random = (int) (Math.random() * 100);
		FibRequest request = new FibRequest(random, max);
		request.setJobNum(random);
		request.setMax(max);
		inQ.addLast(request);
		System.out.println("add in inQ, jobnumber=" + random + ", max=" + max);
		return random;
	}

	// put jobnumber and fibsequence into outQ
	public void put(int jobnumber, String fibSequence) {
		outQ.put(jobnumber, fibSequence);

		System.out.println("the result already put in outQ: "
				+ outQ.get(jobnumber) + ",  jobnumder: " + jobnumber);
	}

	public void rmiRegis() {
		RemoteFibonacci fib;
		try {
			fib = new Fibonacci();
			LocateRegistry.createRegistry(1099);
			Naming.rebind("fib", fib);
		} catch (RemoteException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// read request from inQ,
	// then invoke remote method to calculate Fibonacci Sequence
	// then put into outQ with jobnumber
	public void finish() {

		// read requests from inQ
		FibRequest request = inQ.getLast();
		int jobnumber = request.getJobNum();
		int max = request.getMax();

		System.out.println("read request from inQ, jobnumber:" + jobnumber
				+ ", max: " + max);

		RemoteFibonacci fibonacci;
		try {

			fibonacci = (RemoteFibonacci) Naming
					.lookup("rmi://localhost:1099/fib");
			String fibString = fibonacci.getFibonacciSequence(max);

			System.out.println("make RMI call, fibo: " + fibString);

			// fibonacci数列和jobnumber一起放入outQ
			put(jobnumber, fibString);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// get fibonacci result from outQ by jobnumber
	public String getResult(int jobNum) {
		if (outQ.containsKey(jobNum)) {
			String result = outQ.get(jobNum);
			outQ.remove(jobNum);

			System.out.println("get result from outQ by jobnumber:" + jobNum
					+ ":  " + result);
			return result;
		} else {
			System.out.println("cannot get result");
			return null;
		}
	}

	// save request max length, jobnumber and result into file
	public void save(String max, String result) {
		BufferedWriter bufWriter = null;
		File file = null;
		// full path of WEB-INF in tomcat directory
		String path = this.getClass().getResource("/").getPath();
		path = path.substring(0, path.length() - 8);
		// System.out.println(path);

		// full path of WebContent in Eclipse project
		// System.out.println(System.getProperty("user.dir"));
		try {
			file = new File(path + "fib.txt");
			if (!file.exists())
				file.createNewFile();

			bufWriter = new BufferedWriter(new FileWriter(file, true));
			// bufWriter.write("length: " + max);
			bufWriter.write(max);
			bufWriter.newLine();
			// bufWriter.write("result: " + result);
			bufWriter.write(result);
			bufWriter.newLine();

			System.out.println("result store in fib.txt as history");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bufWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}