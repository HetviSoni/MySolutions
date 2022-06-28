class Solution {
    public int minDeletions(String s) {
        int n = s.length();
        ArrayList<Integer> frq = new ArrayList();
        for(int j=0;j<26;j++)
            frq.add(0);
        for(int i=0;i<n;i++)
        {
            char ch = s.charAt(i);
            int a = ch-'a';
            frq.set(a,frq.get(a)+1);
        }
        for(int k=0;k<frq.size();k++)
        {
            if(frq.get(k)==0)
            {
                frq.remove(k);
                k--;
            }
        }
        Integer arr[]=new Integer[frq.size()];
        for(int z=0;z<arr.length;z++)
            arr[z]=frq.get(z);
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));
        int temp[]= new int[arr.length];
        for(int u=0;u<temp.length;u++)
            temp[u]=arr[u];
        // 4 4 4 4 4
        int ans=0;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>=arr[i-1] )       
            {
                arr[i]=arr[i-1]-1;
                if(arr[i]<0)
                    arr[i]=0;
            }
            // 4 1 0 
        }
        for(int h=1;h<arr.length;h++)
            ans+=temp[h]-arr[h];
        return ans;
    }
}











