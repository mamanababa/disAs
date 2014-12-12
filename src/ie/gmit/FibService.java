package ie.gmit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FibService {

	// In-Queue
	private LinkedList<FibRequest> inQ = new LinkedList<FibRequest>();

	// Out-Queues
	private Map<Integer, String> outQ = new HashMap<Integer, String>();

	// generate jobnumber, and add it to inQ
	public int add(int max) {
		int random = (int) (Math.random() * 100);
		inQ.addLast(new FibRequest(random, max));
		return random;
	}

	// put fibsequence into outQ
	public void put(int jobnumber, String fibSequence) {
		outQ.put(jobnumber, fibSequence);
	}

	// get fibonacci result by jobnumber
	public String getResult(int jobNum) {
		if (outQ.containsKey(jobNum)) {
			String result = outQ.get(jobNum);
			outQ.remove(jobNum);
			return result;
		} else {
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