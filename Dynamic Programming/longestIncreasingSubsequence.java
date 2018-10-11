import java.util.*;
class longestIncreasingSubsequence{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);    
        int n = sc.nextInt();
        int arr[]=new int[n];
     for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
            
        //System.out.println(LIS(arr));
        LIS(arr);
    }
       //DYNAMIC APPROACH USED TO FIND THE LONGEST INCREASING SUBSEQUENCE
    public static void LIS(int arr[])
    {
        int lis[]=new int[arr.length];
        int actual[] = new int[arr.length];
        Arrays.fill(lis,1);
         for(int i=0;i<arr.length;i++)
             actual[i]=i;
        for(int i=1;i<arr.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                //lis[i]=Math.max(lis[i],lis[j]+1);
                if(arr[j]<arr[i]){
                    if(lis[i]<lis[j]+1)
                    {
                        lis[i] = lis[j]+1;
                        actual[i] = j;
                    }
                }
            }
        }
        int max=0;
        for(int i=0;i<arr.length;i++)
            if(lis[i]>lis[max])
                max=i;
                
        System.out.println(lis[max]);
        int t = max;
        int newt = max;
        ArrayList<Integer> al = new ArrayList<Integer>();
        do{
            t=newt;
            al.add(arr[t]);
            newt=actual[t];
        }
        while(t!=newt);
        
        for(int i=al.size()-1;i>=0;i--)
            System.out.print(al.get(i)+" ");
    }
}





