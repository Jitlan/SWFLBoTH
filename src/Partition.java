
public class Partition 
{
	private Job job;
	private int size;
	
	
	public Partition(Job job, int size) 
	{
		this.job = job;
		this.size = size;
	}
	
	public Partition()
	{
		this.job = new Job();
		this.size = 0;
	}
}
