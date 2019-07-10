//https://www.geeksforgeeks.org/ugly-numbers/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	     long ugly[] = new long[10001];
	     ugly[0] = 1;
	     long multiple_2 = 2;
	     long multiple_3 = 3;
	     long multiple_5 = 5;
	     int i2=0, i3=0, i5=0;
	     long next_ugly;
	     for(int i=1;i<10001;i++)
	     {
	         next_ugly = Math.min(multiple_2, Math.min(multiple_3, multiple_5));
	         ugly[i] = next_ugly;
	         
	         if(next_ugly == multiple_2)
	         {
	             i2++;
	             multiple_2 = ugly[i2] * 2; 
	         }
	         if(next_ugly == multiple_3)
	         {
	             i3++;
	             multiple_3 = ugly[i3] * 3;
	         }
	         if(next_ugly == multiple_5)
	         {
	             i5++;
	             multiple_5 = ugly[i5] * 5; 
	         }
	     }
	     //System.out.println(Arrays.toString(ugly));
	     Scanner sc = new Scanner(System.in);
	     int t = sc.nextInt();
	     while(t--!=0)
	     {
	         int n = sc.nextInt();
	         System.out.println(ugly[n-1]);
	     }
	 
	 }
}