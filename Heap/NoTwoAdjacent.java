/* Problem Statement: Generate a string such that no two same 
character are adjacent to each other.
Example: geeksforgeeks
*/
// Reference: https://www.geeksforgeeks.org/rearrange-characters-string-no-two-adjacent/
import java.util.*;
public class NoTwoAdjacent {
    
    public static class key{
        int freq;
        char ch;
        key(char c, int freq)
        {
            ch=c;
            this.freq=freq;
        }
        public char getCh(){
            return ch;
        }
        public int getFreq()
        {
            return freq;
        }
    }
   
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);       
        String s=sc.nextLine();
        int arr[]=new int[26];
        char c;
        for(int i=0;i<s.length();i++)
        {
            c=s.charAt(i);
            arr[c-'a']++;
        }
        PriorityQueue<key> pq=new PriorityQueue<>((a,b)->b.getFreq()-a.getFreq());
        
        for(char x='a';x<='z';x++)
        {
            int val=arr[x-'a'];
            if(val>0)
                pq.add(new key(x, val));
        }
        String str="";
        
        key prev = new key('#', -1);
        while(!pq.isEmpty())
        {
            key k=pq.peek();
            pq.poll();
            str=str+k.getCh();
            
            if(prev.getFreq()>0)
                pq.add(prev);
            
            k.freq--;
            prev=k;
        }
        if(str.length()==s.length())
            System.out.println(str);
        else
        {
            System.out.println(str+"\n Not possible");
            
        }
        
        
        
    }
    
}
