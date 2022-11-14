class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 1){
            return;
        }
        
        //calculate rightmost peak
        int incl = -1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                incl = i;
            }
        }
        
        if(incl == -1){
            //descending order
            int i = 0; int j = nums.length-1;
            while(i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;j--;
            }
            return;
        }
        
        //smallest element greater than prev
        int prev = incl-1;
        int index = incl;
        for(int i = incl; i < nums.length; i++){
            if(nums[i] > nums[prev] && nums[i] < nums[index]){
                index = i;
            }
        }
        
        //swap prev and index
        int temp = nums[prev];
        nums[prev] = nums[index];
        nums[index] = temp;
        
        Arrays.sort(nums, incl, nums.length);
        
    }
}