import java.util.*;
class rangeMin
{
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int q=sc.nextInt();
        int len=(int)(Math.pow(2,(Math.ceil(Math.log(n)/Math.log(2)))+1))-1;
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        
        seg obj = new seg(len, n);
        obj.build(arr, 0, n-1, 0);
        
        for(int t=1;t<=q;t++)
        {
			sc.nextLine();
			char c=sc.next().charAt(0);
            if(c=='q'){
			int ql=sc.nextInt();
            int qr=sc.nextInt();
            int result = obj.query(arr, ql-1, qr-1);
            System.out.println(result);
			}
			else if(c=='u')
			{
				int i=sc.nextInt();
				int val=sc.nextInt();
				obj.update(arr, i, val);
			}
			
        }
    }
}
class seg
{
    int st[];
    int len, n;
    seg(int len, int n)
    {
        this.len=len;
        this.n=n;
        st=new int[len];
    }
    
    void build(int arr[], int left, int right, int index)
    {
		if(left==right)
		{
			st[index]=arr[left];
			return;
		}
		int mid=left+(right-left)/2;
		build(arr, left, mid, 2*index+1);
		build(arr, mid+1, right, 2*index+2);
		st[index]=Math.min(st[2*index+1],st[2*index+2]);
	}
	int query(int arr[], int left, int right)
	{
	    return query(left, right, 0 ,n-1, 0);
	}
	int query(int ql, int qr, int nl, int nr, int index)
	{
	    if(qr<nl || ql>nr)
	        return Integer.MAX_VALUE;
	    if(nl>=ql && nr<=qr)
	        return st[index];
	        
	   int mid=nl+(nr-nl)/2;
		int x=query(ql, qr, nl, mid, 2*index+1);
		int y=query(ql, qr, mid+1, nr, 2*index+2);
		return Math.min(x,y);     
	}
	void update(int arr[], int i, int val)
	{
		arr[i]=val;
		update(arr, i, val, 0, n-1, 0);
		
	}
		
	void update(int arr[], int i, int value, int nl, int nr, int index)
	{
		if(i<nl || i>nr)
			return;
		
		if(nl==nr)
		{
			st[index]=value;
			return;
		}
		
		int mid=nl+(nr-nl)/2;
		update(arr, i, value, nl, mid, 2*index+1);
		update(arr, i, value, mid+1, nr, 2*index+2);
		st[index]=Math.min(st[2*index+1],st[2*index+2]);
	} 
}





