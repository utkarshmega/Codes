import java.io.*;
import java.util.*;

class heapSort {

    int heap_size;
    void build(int arr[], int n)
    {
        heap_size=n;
        for(int i=(n/2)-1;i>=0;i--)
            max_heapify(arr, i, n);
    }
    void max_heapify(int arr[], int i, int n)
    {
        int l=2*i+1;
        int r=2*i+2;
        int largest=i;
        //int temp;
        if(l<heap_size && arr[l]>arr[i])
            largest=l;
        // else
        //     largest=i;
        
        if(r<heap_size && arr[r]>arr[largest])
            largest=r;
        if(largest!=i)
        {
            int temp=arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;
            max_heapify(arr, largest, n);
        }
        
    }
    void heapSort(int arr[],int n){
        //int i=n-1;
        while(heap_size>0){
            swap(arr,heap_size-1,0);
            heap_size--;
            max_heapify(arr,0,heap_size);
        }
        heap_size=n;
    }
    void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    void extract_max(int arr[], int n)
    {
        for(int i=n-1;i>=0;i--)
        {
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            max_heapify(arr, 0, i);
        }
        
    }

 public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        
        heapSort obj=new heapSort();
        obj.build(arr, n);
        //obj.extract_max(arr, n);
        obj.heapSort(arr,n);
        for(int i=0;i<n;i++)
            System.out.print(arr[i]+" ");
        }
}