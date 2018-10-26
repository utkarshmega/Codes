import java.util.*;
class knapsack_01_dp
{
    static int knapsack(int wt[], int val[], int W)
    {
        int n = wt.length;
        int knaparr[][]=new int[n+1][W+1];
        
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=W;j++)
            {
                if(i==0||j==0)
                {
                    knaparr[i][j]=0;
                    continue;
                }
                if(wt[i-1]<=j)
                {
                    knaparr[i][j]=Math.max(val[i-1] + knaparr[i-1][j-wt[i-1]], knaparr[i-1][j]);
                }
                else
                    knaparr[i][j]=knaparr[i-1][j];
            }
        }
        return knaparr[n][W];
        
    }
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int wt[] = new int[n];
        int val[] = new int[n];
        
        /*
        **Enter the weightt and value of that corresponding item  
        */
        
        for(int i=0;i<n;i++)
        {
            wt[i] = sc.nextInt();
            val[i] = sc.nextInt();
        }
        /*
        **Enter the weight of the knapsack   *
        */
        
        int W = sc.nextInt();
        int result = knapsack(wt, val, W);
        System.out.println(result);
    }
}