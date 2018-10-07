import java.util.*;
class LCS
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        char c1[]=s1.toCharArray();
        char c2[]=s2.toCharArray();
        lcs(c1, c2);
        //System.out.println(result);
    }
	
	// FINDING THE LENGTH OF LONGEST COMMON SUBSEQUENCE BY RECURSION
	//COMPLEXITY O(2^n)
    public int lcs(char str1[],char str2[]){
		
		int l1=c1.length;
        int l2=c2.length;
        
        if(len1 == str1.length || len2 == str2.length){
            return 0;
        }
        if(str1[len1] == str2[len2]){
            return 1 + lcs(str1,str2,len1+1,len2+1);
        }
        else{
            return Math.max(lcs(str1,str2,len1+1,len2),lcs(str1,str2,len1,len2+1));
        }
    }
    
	// FINDING THE LENGTH OF LONGEST COMMON SUBSEQUENCE BY DYNAMIC PROGRAMMING
	//COMPLEXITY O(mxn)
    public static void lcs(char c1[], char c2[])
    {
        int l1=c1.length;
        int l2=c2.length;
        int temp[][]=new int[l1+1][l2+1];
        int max=0;
        for(int i=1;i<=l1;i++)
        {
            for(int j=1;j<=l2;j++)
            {
                if(c1[i-1]==c2[j-1])
                    temp[i][j] = 1+temp[i-1][j-1];
                else
                    temp[i][j] = Math.max(temp[i-1][j],temp[i][j-1]);
                if(temp[i][j]>max)
                    max = temp[i][j];
            }
        }
        System.out.println(max);
        int x=l1, y=l2;
        String str="";
        while(temp[x][y]!=0)
        {
            if(temp[x][y]!=temp[x-1][y] && temp[x][y]!=temp[x][y-1])
            {
                str=c1[x-1]+str;
                x-=1;
                y-=1;
            }
            else if(temp[x][y]==temp[x-1][y])
                x-=1;
            else
                y-=1;
        }
        System.out.println(str);
    }	
}