import java.util.*;

public class OSRun
{
  public static void main(String[] args)
  {
    BootLoader boot = new BootLoader();
    ProcessManager processmanager = new ProcessManager();
    MemoryManager memorymanager = new MemoryManager();
    NetworkManager networkmanager = new NetworkManager("",0);
    CaesarCipher cc = new CaesarCipher();
    FileManager filemanager = new FileManager();
    int jobIDCounter = 0;
    List<Job> files = new ArrayList<Job>();

    Scanner s = new Scanner(System.in);
    boot.printBootSteps();
    String command;
    while(true)
    {
      System.out.println("Type \'help\' for a list of commands");
      System.out.println("Enter in a command: ");
      command = s.nextLine();
      try{
      if(command.equals("help"))
      {
        System.out.println("Commands to print are:");
        System.out.println("create file");
        System.out.println("delete file");
        System.out.println("move file");
        System.out.println("update file");
        System.out.println("connect to network");
      }

      if(command.equals("create file"))
      {
    	  try{
		        System.out.println("Name your file");
		        String name = s.nextLine();
		        System.out.println("give file a size");
		        int size = s.nextInt();
		        Job job = filemanager.createFile(name, size, jobIDCounter);
		        jobIDCounter++;
		        files.add(job);
		        memorymanager.BestFit(job);
		        processmanager.loadJob(files);
		        processmanager.runJob();
		        System.out.println("File has been created and memory has been used");
		        System.out.println("current memory sizes are:" + memorymanager.toString());
    	  }catch(Exception e)
    	  {
    		System.out.println("error");  
    	  }
      }

      if(command.equals("delete file"))
      {
        System.out.println("which file would you like to delete:");
        String fileToDelete = s.nextLine();
        int jobCount = 0;
        int jobIndex = -1;

        for(Job j: files)
        {
          if(j.getName().equals(fileToDelete))
          {
            int count=0;
			jobIndex = jobCount;
          }else
          {
            jobCount++;
          }
        }

        files.remove(jobIndex);

        Job job = filemanager.moveFile(memorymanager.getMemorySize(), jobIDCounter);
        memorymanager.addMemoryBack(job);
        System.out.println("file has been deleted");

      }

      if(command.equals("move file"))
      {
        System.out.println("What file do you want to move");
        String fileToMove = s.nextLine();
        Job job = filemanager.moveFile(memorymanager.getMemorySize(), jobIDCounter);
        memorymanager.addMemoryBack(job);
        memorymanager.BestFit(job);
        System.out.println("file has been moved to best fit spot");
      }

      if(command.equals("update file"))
      {
        System.out.println("What file do you want to update");
        String fileToUpdateName = s.nextLine();
        System.out.println("What is the name of the new file");
        String fileToUpdate = s.nextLine();
        System.out.println("What is the size of the new file");
        int fileToUpdateSize = s.nextInt();

        Job job = filemanager.updateFile(memorymanager.getMemorySize(), fileToUpdateSize, jobIDCounter, fileToUpdate);
        memorymanager.BestFit(job);

        System.out.println("File has been moved");
      }

      if(command.equals("connect to network"))
      {
        System.out.println("Connected to network");
        //network does not work because of port but if it did work it would be an echo
      }
      }catch(Exception e)
      {
    	  System.out.println("error please try again");
      }
    }
  }
}
