/**
 * @author Sankalp Saxena
 */
package com.java.sscd.pagereplacement.algorithms;

import java.util.Scanner;

public class OptimalPageReplacement {

	public static void main(String[] args) {
		
		try(Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter the number of pages: ");
			int n = scanner.nextInt();
			
	        int pageNo [] = new int[n];
			System.out.println("Enter the page numbers");
			for(int i = 0; i < n; i++)
	            pageNo[i] = scanner.nextInt();
			
			System.out.println("Enter the number of frames: ");
		       int noOfFrames = scanner.nextInt();	
		
		    int frames [] = new int[noOfFrames];
	        int pageFaults = 0;
	        int replaceFrameIndex = -1;
	        int index = -1;
	        int maxIndex = -1;
	        boolean flag = false;
	        boolean done = false;
	        
		    for(int i = 0; i < n; i++) {
	            if(i < noOfFrames) {
	                frames[i] = pageNo[i];
	                pageFaults++ ;
	                
	                for(int u: frames)
	    				System.out.print(u + " ");
	    			System.out.println();
	                
	    			continue;
	            }
	            else {

	            	for(int j = 0; j < noOfFrames; j++) {
		                if(frames[j] == pageNo[i]) {
		                	flag = false;
		                	break;
		                }
		                flag = true;
		            }
	            	
	            	if(flag) {
	            		
	            		// Checking if any page in the frame doesn't used in the future at all
	            		// if it so replace that page first
	            		for(int k = 0; k < noOfFrames; k++) {	            		
	            			for(int j = i+1; j < n; j++) {
	            				if(frames[k] == pageNo[j]) {
	            					done = false;
	            					break;
	            				}
	            				done = true;
	            				replaceFrameIndex = k;
	            			}
	            			if(done)
	            				break;
	            		}
	            		
	            		// if no such page exists then go with optimal page algorithm
	            		if(!done) {
	            			for(int k = 0; k < noOfFrames; k++) {	            		
		            			for(int j = i+1; j < n; j++) {
		            				
		            				if(frames[k] == pageNo[j]) {
			            				index = j;
			            				
			            				if(index > maxIndex) {
			            					maxIndex = j;
			            					replaceFrameIndex = k;
			            					flag = true;
			            				}

			            				break;
			            			}
			            		}	
			            	}
	            		}
	            		
		            	
			            pageFaults ++;
		            	frames[replaceFrameIndex] = pageNo[i];
		            		
			            for(int u: frames)
			    			System.out.print(u + " ");
			    		System.out.println();
			            
			    		maxIndex = -1;
		            }
	            }
	        }

	        System.out.println("Total number of page faults: " + pageFaults);
		    
		}
			

	}
}

