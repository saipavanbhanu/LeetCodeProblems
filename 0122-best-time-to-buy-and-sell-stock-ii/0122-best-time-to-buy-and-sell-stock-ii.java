class Solution {
    public int maxProfit(int[] p) {
        int max = 0;
        int prev = p[0];
        
        for(int i = 1; i < p.length; i++){
            if(p[i] > prev ){
                max = max + p[i]-prev;
                if(i+1 < p.length){
                    prev = p[i];
                }
            }else{
                prev = p[i];
            }
        }
        return max;
    }
}