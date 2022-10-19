class Solution {
    public int[] plusOne(int[] d) {
        int carry = 1;
        for(int i = d.length-1; i >= 0; i--){
            d[i] = d[i] + carry;
            if(d[i] > 9 ){
                d[i] = 0;
                carry = 1;
            }else{
                carry = 0;
                break;
            }
        }
        if(carry == 1){
            int[] result = new int[d.length+1];
            result[0] = 1;
            for(int i = 1; i < result.length; i++){
                result[i] = d[i-1];
            }
            return result;
        }
        return d;
    }
}