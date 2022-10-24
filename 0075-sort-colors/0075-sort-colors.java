class Solution {
    public void sortColors(int[] nums) {
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
                zeros++;
            else if(nums[i] == 1)
                ones++;
            else
                twos++;
        }
        
        int index = 0;
        while(zeros > 0){
            nums[index++] = 0;
            zeros--;
        }
        
        while(ones > 0){
            nums[index++] = 1;
            ones--;
        }
        
        while(twos > 0){
            nums[index++] = 2;
            twos--;
        }

        
    }
}