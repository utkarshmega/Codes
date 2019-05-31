//https://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	     Scanner sc = new Scanner(System.in);
	     int t= sc.nextInt();
	     while(t--!=0)
	     {
	         int n = sc.nextInt();
	         long arr[] = new long[n];
	         for(int i=0;i<n;i++)
	            arr[i]=sc.nextInt();
	         
	         long lmin[]=new long[n];
	         long rmax[]=new long[n];
	         lmin[0]=arr[0];
	         for(int i=1;i<n;i++)
	            lmin[i] = Math.min(lmin[i-1], arr[i]);
	         rmax[n-1]=arr[n-1];
	         for(int i=n-2;i>=0;i--)
	            rmax[i] = Math.max(rmax[i+1], arr[i]);
	            
	         int i=0, j=0, maxdiff=-1;
	         while(i<n && j<n)
	         {
	             if(lmin[i]<=rmax[j])
	             {
	                 maxdiff = Math.max(maxdiff, j-i);
	                 j++;
	             }
	             else
	                i++;
	         }
	         System.out.println(maxdiff);
	     }
	 }
}