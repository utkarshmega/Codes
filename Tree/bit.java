import java.util.*;
class bit
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        n=n+1;
        int arr[]=new int[n];
        for(int i=1;i<n;i++)
            arr[i]=sc.nextInt();
        bit obj = new bit(n);
        obj.build(arr);
        obj.print();
		
		System.out.println("\nEnter the query");
		int l=sc.nextInt();
		int r=sc.nextInt();
		int ans = obj.query(l, r);
		System.out.println(ans);
        
    }   
    
    int bit[];
    int n;
    bit(int n)
    {
        this.n=n;
        bit=new int[n];
    }
    void update(int arr[], int i, int val)
    {
        arr[i]=val;
        update(i, val);
    }
    void update(int index, int value)
    {
        while(index < bit.length)
        {
            bit[index]+=value;
            index+=index&(-index);
        }
    }
    void build(int arr[])
    {
        for(int i=1;i<n;i++)
            update(i, arr[i]);
    }
    void print()
    {
        System.out.print("Bit Array\n");
        for(int i=1;i<n;i++)
            System.out.print(bit[i]+" ");   
    }
    int query(int left, int right)
    {
        int x = query(right);
		int y = query(left-1);
		return x-y;
    }
    int query(int index)
    {
        int sum=0;
		while(index>0)
        {
            sum=sum+bit[index];
            index-=index & (-index);
        }
        return sum;
    }
        
}