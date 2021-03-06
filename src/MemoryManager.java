import java.util.*;

public class MemoryManager
{
	private List<Integer> processSize;
	private int memorySize[] = {100 ,200 ,300, 400};
	private int ms = memorySize.length;
	//private int ps = processSize.size();
	private List<Job> jobQueue;

	public MemoryManager()
	{
		processSize = new ArrayList<Integer> ();
		jobQueue = new ArrayList<Job>();
	}

	public List<Integer> getProcessSize()
	{
		return processSize;
	}

	public void setProcessSize(List<Integer> processSize)
	{
		this.processSize = processSize;
	}

	public void BestFit(Job job)
	{
		List<Integer> memoryID = new ArrayList<Integer>();
		int jobSize = job.getSize();
		int index = -1;
		int msr[] = new int[ms];

		if(jobSize > memorySize[0] && jobSize > memorySize[1] && jobSize > memorySize[2] && jobSize > memorySize[3])
		{
			System.out.println("file too big please create something smaller");
			return;
		}

		if(job.getName().equals("update file") || job.getName().equals("move file"))
		{
			this.addMemoryBack(job);
		}

		//this loop iterate through memorySize Array
		//sets msr to (memorysize - jobsize)
		//this is to find the best fit index in next loop
		//System.out.println(ms);
		for (int i = 0; i < ms; i++)
		{
			if(jobSize <= memorySize[i])
			{
				msr[i] = memorySize[i] - jobSize;
				
			}
		}
		int hold = msr[0];
		int counter = 0;

		//loop through memmorySizeRemaining (msr)
		//hold best fit index spot
		for(int i = 1; i < msr.length; i++)
		{
			if(hold ==0)
			{
				hold = msr[i];
				counter++;
			}
			else if(hold > msr[i])
			{
				hold = msr[i];
				counter++;
			}
		}
		
		//set index to the counter which found the bestfit index
		index = counter;
		
		System.out.println(index);
		//subtract memory from memorySize block
		memorySize[index] = memorySize[index] - jobSize;
		//
		job.setBlockUsed(index);
		//add job to queue for Process manager
		jobQueue.add(job);


	}

	public void addMemoryBack(Job job)
	{
		int jobBlock = job.getBlockUsed();
		int jobSize = job.getSize();

		memorySize[jobBlock] = memorySize[jobBlock] + jobSize;
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
	
	public String toString()
	{
		String str = memorySize[0]+","+memorySize[1]+","+memorySize[2]+","+memorySize[3];
		return str;
		
	}

	/*public int getPs()
	{
		return ps;
	}

	public void setPs(int ps)
	{
		this.ps = ps;
	}*/
}
