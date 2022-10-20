class Solution {
    static String ch[] = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
    static int val[] = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
    static String h(int n)
    {
        
        int close = 10000;
        int ind;
        String s="";
        if(n==0)
            return s;
        for(int i=0;i<13;i++)
        {
            if(Math.abs(n-val[i])==0)
            {
                 // System.out.println("here at "+i);
                s+=ch[i];
                return s;
            }
        }
        int c=12;
        while(true)
        {
            if(n<val[c])
                c--;
            else
                break;
        }
         // System.out.println("c is "+c);
        while(n>0)
        {
            if(n%val[c]==0)
            {
                for(int i=0;i<n/val[c];i++)
                    s+=ch[c];
                return s;
            }
            else if(ch[c].length()==1)
            {
                s+=ch[c];
                n-=val[c];
                c--;
            }
            else
                c--;
        }
        // D n=300 val[c]=400
        return s;
    }
    public String intToRoman(int num) {
        String ans="";
        Stack<Integer> s = new Stack();
        int a=10;
        while(num>0)
        {
            s.push(num%a);
            // System.out.println(s.peek());
            num-=s.peek();
            a*=10;
        }
        // 246 --> 6 40 200
        while(s.size()>0)
        {
            // System.out.println("calling for "+s.peek());
            String cur = h(s.pop());
            // System.out.println("adding "+cur);
           ans+= cur;
        }
        return ans;
    }
}

