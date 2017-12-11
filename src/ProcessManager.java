import java.util.*;

public class ProcessManager
{
	private Job job;
	private int quantum;
	private List<Job> readyQueue;
	private List<Job> finishQueue;


	public ProcessManager()
	{
		job = new Job();
		quantum = 10;
		readyQueue = new ArrayList<Job>();
		finishQueue = new ArrayList<Job>();

	}

	public void loadJob(List<Job> jobs)
	{
		readyQueue = jobs;
	}

	//round robin
	public void runJob()
	{
		for(Job a : readyQueue)
		{
			if(quantum > a.getRunTime())
			{
				finishQueue.add(a);
				readyQueue.remove(a);
			}
			else if((a.getRunTime() - quantum) <= -1)
			{
				a.setRunTime(0);
			}
			else
			{
				a.setRunTime(a.getRunTime() - quantum);
			}
		}
	}

	//add memory back to memory manager memorySize array
	//change enum
	public Job finishJob(Job job)
	{
		job.status = COMPLETE;
		return job;
	}



}
