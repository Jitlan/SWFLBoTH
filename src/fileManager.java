
public class fileManager
{
	private String name;
	private int size;
	//private int blockLocation;

	public fileManager()
	{
		this.name = "";
		this.size = 0;
		//this.blockLocation = 0;
	}

	public Job createFile(String name, int size, int ID)
	{
		Job create = new Job("create file", size, ID, 10, 0);
		this.name = name;
		this.size = size;
		return create;
	}

	public Job deleteFile(int[] memory)
	{
		Job delete = new Job("delete file", size, ID, 10, 0);
		return delete;
	}

	public Job updateFile(int[] memory, int newSize, int ID, String name)
	{
 		//job needs to update the memeory
		Job update = new Job("update file",(size+NewSize), ID, 10, 0);
		this.size = newSize;
		this.name = name;
		return update;
	}

	public Job moveFile(int[] memory)
	{
		Job move = new Job("move file", size, ID, 10, 0);
		return move;
	}

	//add memory back to memory location
	public int[] addMemory(int[] memory)
	{
		int[] a = memory;
		a[blockLocation] = a[blockLocation] + size;
		return a;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getSize()
	{
		return this.size;
	}

	public void setSize(int size)
	{
		this.size = size;
	}

	public int getBlockLocation()
	{
		return this.blockLocation;
	}

	public void setBlockLocation(int blockLocation)
	{
		this.blockLocation = blockLocation;
	}
}






















//
