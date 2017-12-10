import java.util.*;

public class MemoryManager 
{
	public List<Integer> getProcessSize()
	{
		return processSize;
	}

	public void setProcessSize(List<Integer> processSize) 
	{
		this.processSize = processSize;
	}

	private List<Integer> processSize;
	private int memorySize[] = {100 ,200 ,300, 400};
	int ms = memorySize.length;
	int ps = processSize.size();
	private List<Job> jobQueue;
	
	public MemoryManager() 
	{
		processSize = new ArrayList<Integer> ();
		jobQueue = new ArrayList<Job>();
	}
	
	private void BestFit(Job job)
	{
		List<Integer> memoryID = new ArrayList<Integer>();
		int jobSize = job.getSize();
		int index = -1;
		int msr[] = new int[ms];
		
		for (int i = 0; i < ms; i++)
		{
			if(jobSize <= memorySize[i])
			{
				msr[i] = memorySize[i] - jobSize;
			}
		}
		int hold = msr[0];
		int counter = 0;
		for(int a:msr)
		{
			if(hold > a)
			{
				hold = a;
				counter++;
			}
		}
		index = counter;
		memorySize[index] = memorySize[index] - jobSize;
		jobQueue.add(job);
		
	}
	
	public List<Job> getJobQueue() 
	{
		return jobQueue;
	}

	public void setJobQueue(List<Job> jobQueue)
	{
		this.jobQueue = jobQueue;
	}

	public int[] getMemorySize() 
	{
		return memorySize;
	}

	public void setMemorySize(int[] memorySize) 
	{
		this.memorySize = memorySize;
	}

	public int getMs() 
	{
		return ms;
	}

	public void setMs(int ms) 
	{
		this.ms = ms;
	}

	public int getPs() 
	{
		return ps;
	}

	public void setPs(int ps) 
	{
		this.ps = ps;
	}
}
