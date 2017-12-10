import java.util.*;

public class ProcessManager 
{
	private Job job;
	private int quantum;
	private MemoryManager m;
	private List<Job> readyQueue;
	private List<Job> finishQueue;
	
	
	public ProcessManager() 
	{
		job = new Job();
		quantum = 10;
		m = new MemoryManager();
		readyQueue = new ArrayList<Job>();
		finishQueue = new ArrayList<Job>();
		
	}
	
	public void loadJob()
	{
		readyQueue = m.getJobQueue();
	}
	
	public void runJob()
	{
		for(Job a : readyQueue)
		{
			if(quantum > a.getRunTime())
			{
				finishQueue.add(a);
				readyQueue.remove(a);
			}
			a.setRunTime(a.getRunTime() - quantum);
		}
	}
	
	public Job finishJob()
	{
		return job;
	}
	
	
	
}
