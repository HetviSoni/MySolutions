class RandomizedSet {

    ArrayList<Integer> list;
    public RandomizedSet() {
        this.list = new ArrayList<>();
    }

    public boolean insert(int val) {
        boolean ans;
        if(!list.contains(val))
        {
            ans=true;
            list.add(val);
//            System.out.println("inserting "+ val);
        }
        else
            ans=false;

        return ans;
    }

    public boolean remove(int val) {
        if(list.isEmpty())
            return false;
        if(list.contains(val))
        {
           int a = list.indexOf(val);
            list.remove(a);

            return true;
        }
        return false;
    }

    public int getRandom() {
        if(list.isEmpty())
            return -1;
        int index = (int)(Math.random() * list.size());

        return list.get(index);
    }
    
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */