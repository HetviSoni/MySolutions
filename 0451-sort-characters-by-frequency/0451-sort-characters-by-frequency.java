class Solution {
    public String frequencySort(String s) {
        int arr[]= new int[62];
        String ans="";
        for(int i=0;i<s.length();i++)
        {
            if((int)s.charAt(i)>=97 && (int)s.charAt(i)<=122)
            {
                int a = (int)s.charAt(i);
                arr[a-97]=arr[a-97]+1;
            }
            else if((int)s.charAt(i)>=65 && (int)s.charAt(i)<=90)
            {
                int b = (int)s.charAt(i);
                arr[b-39]=arr[b-39]+1;
            }
            else
            {
                int c = (int)s.charAt(i);
                arr[c+4]=arr[c+4]+1;
            }
        }
        for(int i=0;i<62;i++)
        {
            int max = 0;
            for(int j=0;j<62;j++)
            {
                if(arr[j]>arr[max])
                    max = j;
            }
            if(max<26)
            {
                for(int k =0;k<arr[max];k++)
                {
                    ans=ans+ (char)(max+97);
                }
            }
            else if(max>=26 && max<52)
            {
                for(int k=0;k<arr[max];k++)
                    ans = ans + (char)(max+39);
            }
            else
            {
                for(int k=0;k<arr[max];k++)
                    ans=ans+ (char)(max-4);
            }
            arr[max]= Integer.MIN_VALUE;
        }
        return ans;
    }
}
