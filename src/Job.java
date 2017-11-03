
public class Job
{
	private String name;
	private int size;
	
	public Job(String name, int size)
	{
		this.name = name;
		this.size=size;
	
	}
	
	public Job()
	{
		this.name="";
		this.size = 0;
		
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getSize()
	{
		return size;
	}

	public void setSize(int size)
	{
		this.size = size;
	}
}
