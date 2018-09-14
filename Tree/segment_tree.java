import java.util.*;
class segment_tree
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		int left=sc.nextInt();
		int right=sc.nextInt();
		
		int len=(int)(Math.pow(2,(Math.ceil(Math.log(n)/Math.log(2)))+1))-1;
		
		Seg obj=new Seg(len, n);
		obj.build(arr, 0, n-1, 0);
		int allSum=obj.query(arr, 0, n-1);
		int sum=obj.query(arr, left-1, right-1);
		
		System.out.println("Sum of Array = "+allSum);
		System.out.println("Sum of Query = "+sum); 
		
		int ind, val;		
		System.out.print("Enter the index position = ");
		ind=sc.nextInt();
		System.out.print("\nEnter the value = ");
		val=sc.nextInt();
		obj.update(arr, ind-1, val);
		
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
		int left1=sc.nextInt();
		int right1=sc.nextInt();
		int sum1=obj.query(arr, left1-1, right1-1);
		System.out.println("Sum after updation = "+sum1);
		
		
	}
}
class Seg
{
	int st[];
	int len, n;
	Seg(int len, int n)
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
		st[index]=st[2*index+1]+st[2*index+2];
	}
	
	int query(int arr[], int left, int right)
	{
		return(query(left, right, 0, n-1, 0));
	}
	
	int query(int ql, int qr, int nl, int nr, int index)
	{
		if(qr<nl || ql>nr)
			return 0;
		if(ql<=nl && qr>=nr)
			return st[index];
		
		int mid=nl+(nr-nl)/2;
		int x=query(ql, qr, nl, mid, 2*index+1);
		int y=query(ql, qr, mid+1, nr, 2*index+2);
		return x+y;
		
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
		st[index]=st[2*index+1]+st[2*index+2];
	} 
	
}
