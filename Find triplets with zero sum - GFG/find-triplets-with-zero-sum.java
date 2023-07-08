//{ Driver Code Starts
import java.util.*;
class Triplets{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			Solution g=new Solution();
			if(g.findTriplets(a,n))
				System.out.println("1");
			else
				System.out.println("0");
			
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
	public boolean findTriplets(int arr[] , int n)
    {
        //add code here.
        HashMap<Integer,Integer> map =new HashMap();
        for(int i=0;i<n;i++)
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                //arr[i]+arr[j]+arr[k]=0  ==> -36+18 = -18
                //cur + arr[k]=0  ==>  arr[k]=-cur
                int cur = arr[i]+arr[j];
                if(cur==0)
                {
                    if(cur==arr[i] || cur==arr[j])
                    {
                        if(cur==arr[i] && cur==arr[j])
                        {
                            if(map.get(cur)>2){
                                // System.out.println("up here at i,j "+i+" "+j);
                                return true;}
                        }
                        else if(map.containsKey(cur))
                        {
                            if(map.get(cur)>1){
                                // System.out.println("here at i,j "+i+" "+j);
                                return true;}
                            else
                                continue;
                                
                        }
                    }
                    else{
                        if(map.containsKey(cur))
                        {
                            // System.out.println("at i,j "+i+" "+j);
                             return true;
                        }
                    }
                }
                else{if(cur==-arr[i] || cur==-arr[j])
                {
                    if(cur==-arr[i] && cur==-arr[j])
                    {
                        if(map.get(-cur)>2){
                            // System.out.println("up here at i,j "+i+" "+j);
                            return true;}
                    }
                    else if(map.containsKey(-cur))
                    {
                        if(map.get(-cur)>1){
                            // System.out.println("here at i,j "+i+" "+j);
                            return true;}
                        else
                            continue;
                            
                    }
                }
                    
                if(map.containsKey(-cur))
                {
                    // System.out.println("at i,j "+i+" "+j);
                     return true;
                }}
                   
            }
        }
        return false;
    }
}