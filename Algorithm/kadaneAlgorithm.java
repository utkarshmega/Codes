//Kadane ALgorithm to find the maximum sum of contigous sub-array. 

import java.util.*;
import java.lang.*;
import java.io.*;
class kadaneAlgorithm
 {
	public static void main (String[] args)throws IOException
	 {
	     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     int t = Integer.parseInt(br.readLine());
	     while(t--!=0)
	     {
	         int n = Integer.parseInt(br.readLine());
	         int arr[] = new int[n];
	         
	         String line = br.readLine();
	         String strs[] = line.trim().split(" ");
	         for(int i=0;i<n;i++)
	            arr[i]=Integer.parseInt(strs[i]);
	         
	         int max = arr[0];
	         int curr_max = arr[0];
	         for(int i=1;i<n;i++)
	         {
	             max = Math.max(arr[i], max+arr[i]);
	             curr_max = Math.max(curr_max, max);
	         }
	         System.out.println(curr_max);
	           
	     }
	 }
}