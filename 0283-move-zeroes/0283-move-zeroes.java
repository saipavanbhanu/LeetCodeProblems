class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0, index = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                count++;
            }else{
                nums[++index] = nums[i];
            }
        }
        while(count > 0){
            nums[++index] = 0;
            count--;
        }
    }
}