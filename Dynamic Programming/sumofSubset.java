import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public boolean partition(int arr[], int n) // to divide the array into two parts such that the sum of both parts are same
	{
		int sum=0;
		 for(int i=0;i<n;i++)
			sum+=arr[i];
		 if(sum%2!=0) // I sum of array is not even number then the sum of two halves can't be same
			return false;
		 else
		 {
			 sum/=2;
			 boolean subset[][]=new boolean[n+1][sum+1];
			 for(int i=0;i<=n;i++)
				subset[i][0]=true;
			 for(int i=1;i<=n;i++)
			 {
				 for(int j=1;j<=sum;j++)
				 {
					 if(j<arr[i-1])
						subset[i][j] = subset[i-1][j];
					 else{
						//System.out.print("1");
						subset[i][j] = subset[i-1][j] || subset[i-1][j-arr[i-1]];
					 }
				 }
			 }
			 return subset[n][sum];
		 }
	}
	public void subset(int arr[], int n, int sum)
	{
	
		 boolean subset[][]=new boolean[n+1][sum+1];
		 for(int i=0;i<=n;i++)
			subset[i][0]=true;
		 for(int i=1;i<=n;i++)
		 {
			 for(int j=1;j<=sum;j++)
			 {
				 if(j<arr[i-1])
					subset[i][j] = subset[i-1][j];
				 else{
					subset[i][j] = subset[i-1][j] || subset[i-1][j-arr[i-1]];
				 }
			 }
		 }
		 System.out.println(subset[n][sum]);
		 //To print the number that sums to that number
		 if(subset[n][sum]){
			 ArrayList<Integer> al = new ArrayList<>();
			 int i=n, j=sum;
			 while(i!=0 && j!=0)
			 {
				 if(subset[i-1][j]==true)
					i=i-1;
				 else{
					 al.add(arr[i-1]);
					 i=i-1;
					 j=j-arr[i];
				 }
			 }
			 System.out.print(al.toString());
		 }
	}
	public static void main (String[] args)
	 {
		 GFG gfg = new GFG();
		 int ar[] = {1, 3, 5, 8, 5, 10};
		 System.out.println(gfg.partition(ar, ar.length));
		 
		 int arr[] = {2, 3, 7, 8, 10};
		 gfg.subset(arr, arr.length, 11);
		 
	         
	     
	 }
}