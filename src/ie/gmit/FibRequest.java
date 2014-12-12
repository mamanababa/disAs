package ie.gmit;

public class FibRequest {

	private int jobNum;
	private int max;

	public FibRequest() {
	}

	public FibRequest(int jobNum, int max) {
		this.jobNum = jobNum;
		this.max = max;
	}

	public int getJobNum() {
		return jobNum;
	}

	public void setJobNum(int jobNum) {
		this.jobNum = jobNum;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

}
