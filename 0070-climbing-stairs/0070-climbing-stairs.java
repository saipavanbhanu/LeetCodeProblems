class Solution {
    public int climbStairs(int n) {
        if(n <= 0)
            return 0;
        else if(n == 1)
            return 1;
        else if(n == 2)
            return 2;
        
        int n1 = 1, n2 = 2, ways = 0;
        for(int i = n - 2; i > 0; i--){
            ways = n1 + n2;
            n1 = n2;
            n2 = ways; 
        }
        return ways;
    }
}