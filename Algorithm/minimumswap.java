class minimumswap
{
    static class pair{
        int data, index;
        pair(int data, int index){
            this.data=data;
            this.index = index;
        }
        int getData()
        {
            return data;
        }
        int getIndex(){
            return index;
        }
    }
	public static int minSwaps(int[] A, int N)
	{
	    ArrayList<pair> arr = new ArrayList<>();
	    for(int i=0;i<N;i++)
	        arr.add(new pair(A[i], i));
	        
	    Collections.sort(arr, (a,b)->a.getData()-b.getData());
	    
	    boolean visited[] = new boolean[N];
	    int ans=0;
	    for(int i=0;i<N;i++){
	        
	        if(visited[i] || arr.get(i).getIndex() == i)
	            continue;
	        
	        int cycle=0;
	        int j=i;
	        while(!visited[j])
	        {
	            visited[j]=true;
	            j=arr.get(j).getIndex();
	            cycle++;
	        }
	        if(cycle>0)
	            ans+=cycle-1;
	    }
	    return ans;
	}
	public static void main(String args[])
	{
		int a[] = {5, 2, 4, 9, 7, 3};
		minswaps(a, a.length);
	}

}