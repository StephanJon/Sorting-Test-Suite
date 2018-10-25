package sort;

public class Job implements Comparable<Job>{
	/**
	 * Data members
	 */
	private String JobID;
	private int RunTime;
	
	/**
	 * No-argument Constructor
	 */
	public Job() {
		
	}
	
	/**
	 * Argument Constructor
	 */
	public Job(String JobID, int RunTime) {
		this.JobID = JobID;
		this.RunTime = RunTime;
	}
	
	/**
	 * Accesses a Job's RunTime
	 */
	public int getRunTime() {
		return RunTime;
	}
		
	/**
	 * Mutates a Job's RunTime
	 */
	public void setRunTime(int newRuntime) {
		this.RunTime = newRuntime;
	}
	
	/**
	 * Accesses a Job's JobID
	 */
	public String getJobID() {
		return JobID;
	}
	
	/**
	 * Compares the RunTime of this.Job to a Job (j).
	 * Returns -1 if this.Job < j; returns 1 if this.Job < j.
	 * Overrides the CompareTo() from interface Comparable to compare type int.
	 * @param j - Job that is being compared to.
	 */
	@Override
	public int compareTo(Job j)
	{
		if (this.getRunTime() < j.getRunTime()) {
			return -1;
		} return 1;
	}	
}