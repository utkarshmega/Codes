/* REF:   https://www.geeksforgeeks.org/length-of-the-longest-valid-substring/

Problem: To find the longest valid substring
Input: ((()	Output: 0
       )()())	Output: 4
	   )(()()(() Output: 4
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	     Scanner sc = new Scanner(System.in);
	     int t=sc.nextInt();
	     sc.nextLine();
	     while(t--!=0)
	     {
	         String s=sc.nextLine();
	         Stack<Integer> stk=new Stack<>();
	         stk.push(-1);
	         int max=0, count=0;
	         for(int i=0;i<s.length();i++)
	         {
	             char c=s.charAt(i);
	             if(c=='(')
	                stk.push(i);
	             else
	             {
	                 int val=stk.pop();
	                 if(stk.empty())
	                    stk.push(i);
	                 else{
	                     count=i-stk.peek();
	                     if(count>max)
	                        max=count;
	                 }
	             }
	         }
	         System.out.println(max);
	     }
	 
	 }
}