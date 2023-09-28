//{ Driver Code Starts
import java.util.*;
class Heap_Sort
{
    void printArray(int arr[],int n)
    {
        //int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        Heap_Sort hs = new Heap_Sort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
                
            Solution ob=new Solution();
            ob.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        }
    }
    
}



// } Driver Code Ends




class Solution
{
    //Function to build a Heap from array.
    void buildHeap(int arr[], int n)
    {
        // Your code here
        for(int i=n;i>=0;i--)
        {
            
            heapify(arr,i,n);
            // System.out.println("heapify at i= "+i);
            // for(int j=0;j<n;j++)
            // {
            //       System.out.print(arr[j]+" ");
            // }
            //  System.out.println();
        }
    }
 
    //Heapify function to maintain heap property.
    
    static void heapify(int arr[], int i,int n)
    {

        int lc= 2*i+1;
        int rc=2*i+2;
        if(lc>=n && rc>=n)
            return;
        if(rc>=n)
        {
            if(arr[lc]>arr[i])
            {
                int temp=arr[i];
                arr[i]=arr[lc];
                arr[lc]=temp;
            }
        }else{
            if(arr[lc]<=arr[i] && arr[rc]<=arr[i])
                return;
            if(arr[lc]>arr[rc] && arr[i]<arr[lc])
            {
                int temp=arr[lc];
                arr[lc]=arr[i];
                arr[i]=temp;
                heapify(arr,lc,n);
            }else if(arr[rc]>=arr[lc] && arr[i]<arr[rc])
            {
                int temp=arr[rc];
                arr[rc]=arr[i];
                arr[i]=temp;
                heapify(arr,rc,n);
            }

        }}
    
    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n)
    {
        //code here
        buildHeap(arr,n);
        // for(int i=0;i<n;i++)
        // {
        //       System.out.print(arr[i]+" ");
        // }
        //   System.out.println("here");
        for(int i=0;i<n;i++)
        {
            int temp=arr[0];
            arr[0]=arr[n-i-1];
            arr[n-i-1]=temp;
            heapify(arr,0,n-i-1);
        }
        
    }
 }
 
 
