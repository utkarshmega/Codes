//Link: https://www.geeksforgeeks.org/sum-of-all-subarrays/
//To find the sum-of-all-subarrays/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	     Scanner sc = new Scanner(System.in);
	     int t = sc.nextInt();
	     while(t--!=0)
	     {
	         int n = sc.nextInt();
	         int arr[] = new int[n];
	         for(int i=0;i<n;i++)
	            arr[i] = sc.nextInt();
	         
	         long sum=0;
	         for(int i=0;i<n;i++)
	         {
	             sum = (sum + (arr[i] * ((i+1)*(n-i))));
	         }
	         System.out.println(sum);
	     }
	 }
}