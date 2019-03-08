import java.util.*;
class segmentedSieve
{
	static ArrayList<Integer> arr;
	static void normalSieve(int r)
	{
		boolean prime[] = new boolean[100001];
        for(int i=2;i*i<=100000;i++)
        {
            for(int j=i*i;j<=100000;j+=i)
                if(prime[i]==false)
                    prime[j]=true;
        }
        arr = new ArrayList<>();
        arr.add(2);
        for(int i=3;i<=100000;i+=2)
            if(prime[i]==false)
                arr.add(i);
        System.out.print(arr.toString());
	}
	static void sieveSegmented(int l, int r)
	{
		boolean primeno[]=new boolean[r-l+1];
		for(int i=0;arr.get(i)*(long)arr.get(i)<=r;i++)
		{
			int base = (l/arr.get(i))*arr.get(i);
			if(base<l)
				base+=arr.get(i);
			for(long j=base;j<=r;j+=arr.get(i))
			{
				int k = (int)j-l;
				prime[k] = true;
			}
			if(base == arr.get(i))
				primeno[base-l]=false;
		}
		for(int i=0;i<=r-l;i++)
			if(primeno == false)
				System.out.println(i+l+" ");
	}
}