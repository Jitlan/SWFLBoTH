
public class Job
{
	private String name;
	private int size;
	private int ID = 0;
	private int runTime;
	private int blockUsed;
	private status stat;

	public status getStat() {
		return stat;
	}

	public void setStat(status stat) {
		this.stat = stat;
	}

	public Job(String name, int size, int ID, int runTime, int blockUsed)
	{
		this.name = name;
		this.size = size;
		this.ID = ID;
		this.runTime = runTime;
		this.blockUsed = blockUsed;
	}

	public Job()
	{
		this.name="";
		this.size = 0;
		this.ID = 0;
		this.runTime = 0;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getBlockUsed()
	{
		return blockUsed;
	}

	public void setBlockUsed(int blockUsed)
	{
		this.blockUsed = blockUsed;
	}

	public int getSize()
	{
		return size;
	}

	public void setSize(int size)
	{
		this.size = size;
	}

	public enum status
	{
		RUNNING,WAITING,READY,COMPLETE
	}

	public int getID()
	{
		return ID;
	}

	public void setID(int iD)
	{
		ID = iD;
	}

	public int getRunTime() {
		return runTime;
	}

	public void setRunTime(int runTime) {
		this.runTime = runTime;
	}



}
