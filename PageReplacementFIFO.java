/**
 * @author Sankalp Saxena
 */
package com.java.sscd.pagereplacement.algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class PageReplacementFIFO {
    
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
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
        int pointer = 0;
        boolean flag = true;
        ArrayList<Integer> values = new ArrayList<Integer>();
        
        for(int i = 0; i < n; i++) {
            if(i < noOfFrames) {
                frames[i] = pageNo[i];
                pageFaults++ ;
                for(int u: frames)
    				System.out.print(u + " ");
    			System.out.println();
                continue;
            } else {
            	
	            for(int j = 0; j < noOfFrames; j++) {
	                if(frames[j] == pageNo[i]) {
	                	flag = false;
	                	break;
	                }
	                flag = true;
	            }
	            if(flag) {
	            	frames[pointer] = pageNo[i];
	                pointer = (pointer+1)%noOfFrames;
	                pageFaults++;
	                flag = true;
	                for(int u: frames)
        				System.out.print(u + " ");
        			System.out.println();
	            }
            }
        }

        System.out.println("Total number of page faults: " + pageFaults);
    }
}