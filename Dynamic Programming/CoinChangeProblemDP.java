/** Coin Change problem
 * Problem statement:- The number of ways of making change for a particular number of
 * units using the given types of coins
   For example, if you have 4 types of coins, and the value of each type is given as
   8,3,1,2 respectively, you can make change for 3 units in three ways:{1,1,1} ,{1,2}
   , {3}.
   **/
//DYNAMIC APPROACH

import java.util.*;
class CoinChangeProblemDP 
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);       //Sort in ascending order
        int dp[][] = new int[n][k+1];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=k;j++)
            {
                if(i==0||j==0)  // At j==0, by default the value the value is taken as 1
                {
                    if(j%arr[i]==0)     //To find if the given value of j can be formed with the given coin i.e. with the first coin 
                        dp[i][j]=1;
                    else
                        dp[i][j]=0;
                }
                else
                {
                    if(j<arr[i])
                        dp[i][j]=dp[i-1][j];
                    if(j>=arr[i])   //to cal the number of possible ways the value of j can be formed with that coins and the coins above it
                        dp[i][j]=dp[i-1][j]+dp[i][j-arr[i]];
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=k;j++)
            {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(dp[n-1][k]);
    }
}







