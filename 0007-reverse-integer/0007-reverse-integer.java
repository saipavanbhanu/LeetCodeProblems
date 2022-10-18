class Solution {
    public int reverse(int x) {
        boolean isNegative = false;
        if( x < 0){
            isNegative = true;
            x = x * (-1);
        }
        
        int result = 0;
        while(x > 0){
            int newResult = (result * 10) + x % 10; 
            if ((newResult - (x%10)) / 10 != result){
                return 0; 
            }
            result = newResult;
            x = x/10;
        }
        
        if(result > 0){
            if(isNegative){
                return -1 * result;
            }
            return result;
        }else{
            return 0;
        }
    }
}