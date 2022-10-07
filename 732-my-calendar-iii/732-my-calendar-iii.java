class MyCalendarThree {
    ArrayList<Integer> start= new ArrayList();
    ArrayList<Integer> end=new ArrayList();
    public MyCalendarThree() {
        
    }
    
    public int book(int s, int e) {
        start.add(s);
        end.add(e);
        Collections.sort(start);
        Collections.sort(end);
        int booking=1;
        int max=1;
        int i=1;
        int j=0;
        while(i<start.size() && j<end.size())
        {
            if(start.get(i)<end.get(j))
            {
                booking++;
                i++;
            }
            else
            {
                booking --;
                j++;
            }
            max=Math.max(max,booking);
        }
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */