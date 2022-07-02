class Solution {
    public int maxArea(int h, int w, int[] hor, int[] ver) {
        Arrays.sort(hor);
        Arrays.sort(ver);
        
        long x = hor[0]-0;
        for(int i=1; i<hor.length; i++){
            x = Math.max(x, hor[i]-hor[i-1]);
        }
        x = Math.max(x, h-hor[hor.length-1]);
        
        long y = ver[0]-0;
        for(int i=1; i<ver.length; i++){
            y = Math.max(y, ver[i]-ver[i-1]);
        }
        y = Math.max(y, w-ver[ver.length-1]);
        
        return (int)(x*y%1000000007);
    }
}