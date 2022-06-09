class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        ArrayList<Integer> arr= new ArrayList();
        while(x>0)
        {
            arr.add(x%10);
            x=x/10;
        }
        int s=0;
        int e = arr.size()-1;
        while(s<e)
        {
            if(arr.get(s)!=arr.get(e))
                return false;
            s++;
            e--;
        }
        return true;
    }
}