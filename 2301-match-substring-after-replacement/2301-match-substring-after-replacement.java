class Solution {
    static boolean convertible(String a, String b, boolean arr[][] )
    {
        for(int i=0;i<a.length();i++)
        {
            if(a.charAt(i)!=b.charAt(i))
            {
                int x = findValue(b.charAt(i));
                int y = findValue(a.charAt(i));
                if(!arr[x][y])
                    return false;
                // if(map.containsKey(b.charAt(i)))
                // {
                //     if(map.get(b.charAt(i))!=a.charAt(i))
                //         return false;
                // }
                // else
                //     return false;
            }
        }
        return true;
    }
    static int findValue(char c)
    {
        if(Character.isDigit(c))
            return (int)c-48;
        if(Character.isLowerCase(c))
            return (int)c - 97+10;
        else
            return (int)c-65+36;
    }
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        boolean arr[][]= new boolean[62][62];
        for(int i=0;i<mappings.length;i++)
        {
            char c1=mappings[i][0];
            char c2=mappings[i][1];
            int i1=findValue(c1);
            int i2=findValue(c2);
            arr[i1][i2]=true;
        }
        // for(int y=0;y<62;y++)
        // {
        //     for(int z=0;z<62;z++)
        //         System.out.print(arr[y][z]+" ");
        //     System.out.println();
        // }
        int n=s.length();
        int m=sub.length();
        boolean ans=false;
        for(int i=0;i<n;i++)
        {
            // System.out.println("checking in main string from index "+i);
            if(i+m<=n){
            String temp = s.substring(i,i+m);
            // System.out.println(temp);
            ans = ans|convertible(temp,sub,arr);}
            else break;
        }
        return ans;
    }
}