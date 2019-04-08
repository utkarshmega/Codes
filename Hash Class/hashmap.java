import java.io.*;
import java.lang.*;

class GFG {
    
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ar[] = new int[n];
        for(int i=0;i<n;i++)
            ar[i]=sc.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        
        //Declaration of HashMap
	    HashMap<Integer, Integer> h = new HashMap<>();
	    
	    for(int i=0;i<n;i++)
	    {
	        al.add(arr[i]);
	        if(!h.containsKey(arr[i]))
	            h.put(arr[i], 1);
	        else
	            h.put(arr[i], h.get(arr[i])+1);
	    }
	    
	    //Traversing HashMap using Iteartor
	    Iterator it = h.entrySet().iterator();
	    int a, b, diff=0, max=0;
	    while(it.hasNext())
	    {
	        //element will store both the key-value pair since element has been 
	        //declared Map.Entry
	        Map.Entry element = (Map.Entry)it.next(); 
	        //int has been written to type the object to int type
	        int x=(int)element.getValue(); //to access the value of that key
	        if(x>1)
	        {
    	        a = al.indexOf((int)element.getKey());
    	        b = al.lastIndexOf((int)element.getKey());
    	        diff=b-a;
	        }
	        if(diff>max)
	            max=diff;
	    }
    }
    
}