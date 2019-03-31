import java.util.*;
public class RR {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of process");
		int n = sc.nextInt();
		int process[] = new int[n];
		System.out.println("Enter the time required to complete each task orderly");
		
		for(int i=0;i<n;i++) {
			process[i] = sc.nextInt();
		}
		
		System.out.println("Enter the quantum");
		int q= sc.nextInt();
		int completed[] = new int[n];
		for(int i=0;i<n;i++)
			completed[i] = process[i];
		int time[] = new int[n];
		int waiting[] = new int[n];
		int tat[] = new int[n];
		int tt[] = new int[n];
		int s = 0;
		
		while(check(completed)) {
			for(int i=0;i<n;i++) {
				if(completed[i] == 0)
					continue;
				
				else
					if(completed[i]>q) {
						completed[i]-=q;
						time[i] = s+q;
						s = time[i];
					}
				
					else {
						time[i] = s + completed[i];
						s = time[i];
						completed[i] = 0;
					}
			}
		}
		System.out.println("TAT is");
		for(int i:time)
			System.out.print(i + " ");
		System.out.println();
		
		float sum = 0;
		for(int i:time)
			sum = sum + i;
		
		System.out.println("Average round time is " + (sum/n));
		sum = 0;
		
		for(int i=0;i<n;i++) {
			waiting[i] = time[i] - process[i];
		}
		System.out.println("WT is");
		for(int i:waiting) {
			System.out.print(i + " ");
			sum+=i;
		}
		System.out.println();
		System.out.println("Average waiting time is " + (sum/n));
		
	}
 public static boolean check(int a[]) {
	 for(int i=0;i<a.length;i++) {
		 if(a[i]!=0)
			 return true;
	 }
	 
	 return false;
 }
}
