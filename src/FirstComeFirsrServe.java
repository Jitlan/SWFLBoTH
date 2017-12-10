import java.util.Scanner;

public class FirstComeFirsrServe 
{

	public static void main(String[] args)
	{
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("enter no of process: ");
			int n = sc.nextInt();
			int processid[] = new int[n];   // process ids
			int arrivalTime[] = new int[n];     // arrival times
			int executeTime[] = new int[n];     // burst or execution times
			//int ct[] = new int[n];     // completion times
			//int ta[] = new int[n];     // turn around times
			//int wt[] = new int[n];     // waiting times 
			int temp;
			float avgwt=0;
			float avgta=0;
	 
			for(int i = 0; i < n; i++)
			{
				//System.out.println("enter process " + (i+1) + " arrival time: ");
				arrivalTime[i] = sc.nextInt();
				//System.out.println("enter process " + (i+1) + " brust time: ");
				executeTime[i] = sc.nextInt();
				processid[i] = i+1;
			}
	 
			//sorting according to arrival times
			for(int i = 0 ; i <n; i++)
			{
				for(int  j=0;  j < n-(i+1) ; j++)
				{
					if( arrivalTime[j] > arrivalTime[j+1] )
					{
						temp = arrivalTime[j];
						arrivalTime[j] = arrivalTime[j+1];
						arrivalTime[j+1] = temp;
						temp = executeTime[j];
						executeTime[j] = executeTime[j+1];
						executeTime[j+1] = temp;
						temp = processid[j];
						processid[j] = processid[j+1];
						processid[j+1] = temp;
					}
				}
			}
			
			// finding completion times
			//for(int  i = 0 ; i < n; i++)
			//{
			//	if( i == 0)
			//	{	
			//		ct[i] = arrivalTime[i] + burstTime[i];
			//	}
			//	else
			//	{
			//		if( arrivalTime[i] > ct[i-1])
			//		{
			//			ct[i] = arrivalTime[i] + burstTime[i];
			//		}
			//		else
			//			ct[i] = ct[i-1] + burstTime[i];
			//	}
			//	ta[i] = ct[i] - arrivalTime[i] ;          // turnaround time= completion time- arrival time
			//	wt[i] = ta[i] - burstTime[i] ;          // waiting time= turnaround time- burst time
			//	avgwt += wt[i] ;               // total waiting time
			//	avgta += ta[i] ;               // total turnaround time
			//}
			
			System.out.println("\npid  arrival  brust  complete turn waiting");
			for(int  i = 0 ; i< n;  i++)
			{
				System.out.println(processid[i] + "  \t " + arrivalTime[i] + "\t" + executeTime[i] 
						// + "\t" + ct[i] + "\t" + ta[i] + "\t"  + wt[i]
						) ;
			}
			sc.close();
			System.out.println("\naverage waiting time: "+ (avgwt/n));     // printing average waiting time.
			System.out.println("average turnaround time:"+(avgta/n));    // printing average turnaround time.
		}

	}

}
