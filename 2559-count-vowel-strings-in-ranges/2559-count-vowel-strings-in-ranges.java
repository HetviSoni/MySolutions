class Solution {
    static boolean isVowel(char a)
    {
        if(a=='a' || a=='e' || a=='i' || a=='o' || a=='u')
            return true;
        return false;
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n =words.length;
        int arr[]= new int[n];
        for(int i=0;i<n;i++)
        {
            if(isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length()-1))) 
                arr[i]=1;
        }
        int sum[]= new int[n];
        sum[0] = arr[0];
        for(int i=1;i<n;i++)
        {
            sum[i]=arr[i]+sum[i-1];
        }
        int ans[]= new int[queries.length];
        for(int i=0;i<queries.length;i++)
        {
            int l = queries[i][0];
            int r = queries[i][1];
            if(l==0)
                ans[i]=sum[r];
            else{
                ans[i]=sum[r]-sum[l-1];
            }
        }
        return ans;
    }
}
