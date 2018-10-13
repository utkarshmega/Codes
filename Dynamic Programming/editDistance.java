
// TIME AS WELL AS SPACE COMPLEXITY TO CALCULATE NO OF EDITS IS O(M*N);

import java.util.*;
class editDistance
{
    // FILLS THE TABLE AND ALSO CALCULATES THE NUMBER OF EDITS REQUIRED
    void edits(char[] str1, char[] str2)
    {
        int[][] temp=new int[str1.length+1][str2.length+1];
        for(int i=0;i<temp.length;i++)
            temp[i][0]=i;
            
        for(int i=0;i<temp[0].length;i++)
            temp[0][i]=i;
            
        for(int i=1;i<=str1.length;i++)
        {
            for(int j=1;j<=str2.length;j++)
            {
                if(str1[i-1]==str2[j-1])
                    temp[i][j]=temp[i-1][j-1];
                else
                    temp[i][j]=1+Math.min(temp[i-1][j-1],Math.min(temp[i-1][j],temp[i][j-1]));
            }
        }
        print(str1, str2, temp);
        System.out.println(temp[str1.length][str2.length]); //PRINTS THE NUMBER OF EDITS REQUIRED
        
    }
	
	// PRINTS THE CHARACTERS NEEDED TO CHANGE TO MAKE BOTH STRINGS EQUAL
    void print(char[] str1, char[] str2, int[][] temp)
    {
        int i=temp.length-1;
        int j=temp[0].length-1;
        while(true)
        {
            if(i==0||j==0)
                break;
            else if(str1[i-1]==str2[j-1])
            {
                i-=1;
                j-=1;
            }
            else if(temp[i][j]==temp[i-1][j-1]+1)
            {
                System.out.println("Change "+str2[j-1]+" in String 2 to "+str1[i-1]);
                i-=1;
                j-=1;
            }
            else if(temp[i][j]==temp[i-1][j]+1)
            {
                System.out.println("Delete "+str1[i-1]+" from String 1");
                i-=1;
            }
            else if(temp[i][j]==temp[i][j-1]+1)
            {
                System.out.println("Delete "+str2[j-1]+" from String 2");
                j-=1;
            }
           /* else
                throw new IllegalArgumentException("Some wrong string has been entered");*/
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);    
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(s1+"\n"+s2);
        char[] str1=s1.toCharArray();
        char[] str2=s2.toCharArray();
        
        editDistance obj=new editDistance();
        obj.edits(str1, str2);
    }
}







