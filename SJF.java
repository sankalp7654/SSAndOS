
Conversation opened. 2 messages. All messages read.

Skip to content
Using Gmail with screen readers
shashanksoni092@gmail.com 

10 of about 113
Fwd:
Inbox
x

Shashank Soni
Attachments
Fri, Mar 8, 1:45 PM
to me



---------- Forwarded message ---------
From: Shashank Soni <shashanksoni092@gmail.com>
Date: Fri, Mar 8, 2019 at 1:35 PM
Subject: 
To: <shashanksoni092@gmail.com>



2 Attachments

Sankalp Saxena <sankalp.saxena.sta@gmail.com>
Attachments
Fri, Mar 8, 7:23 PM
to Sahil


2 Attachments

import java.util.*;
public class SJF {
	public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the number of process");
	int n = sc.nextInt();
	int process[] = new int[n];
	System.out.println("Enter the time required to complete each task orderly");
	
	for(int i=0;i<n;i++) {
		process[i] = sc.nextInt();
	}
	
	int pointers[] = new int[n];
	int pointerend[] = new int[n];
	int order[] = new int[n];
	
	int point = 0;
	int min=process[0],max=process[0];
	for(int i=0;i<n;i++) {
		if(min>process[i]) {
			min = process[i];
		}
		
		if(max<process[i])
			max = process[i];
	}
	int track = 0;
	for(int i=min;i<=max;i++) {
		for(int j=0;j<n;j++) {
			if(i==process[j]) {
				order[track++] = j+1;
			}
		}
	}
	System.out.println("It is executed in the order");
	for(int i:order) {
		System.out.print(i + " ");
	}
	System.out.println();
	pointers[0] = 0;
	for(int i=0;i<n-1;i++) {
		pointers[i+1] = pointers[i] + process[order[i]-1];
	}
	System.out.println("Waiting time");
	int sum = 0;
	for(int i:pointers) {
		System.out.print(i + " ");
		sum = sum + i;
	}
	System.out.println();
	System.out.println("Average waiting time is " + ((float)sum/n));
	sum = 0;
	for(int i=0;i<n;i++) {
		pointerend[i] = pointers[i] + process[order[i]-1];
	}
	System.out.println("Turn around time is");
	for(int i:pointerend) {
		System.out.print(i + " ");
		sum = sum + i;
	}
	System.out.println();
	System.out.println(sum);
	System.out.println("Average turn around time is " + ((float)sum/n));
	}
}
SJF.txt
Displaying RR.txt.
