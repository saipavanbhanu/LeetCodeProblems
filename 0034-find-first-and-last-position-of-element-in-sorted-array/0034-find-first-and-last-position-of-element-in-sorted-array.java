class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = leftMost(nums, target);
        if(first != -1){
            int second = rightMost(nums, target, first);
            return new int[]{first, second};
        }
        return new int[]{-1,-1};
    }
    
    int rightMost(int [] nums, int target, int minIndex){
        int max = minIndex;
        for( int i = minIndex + 1; i < nums.length && i >= 0; i++){
            if(nums[i] == target ){
                max = i;
            }
        }
        return max;
    }
    
    int leftMost(int[] nums, int target){
        int l = 0, r = nums.length-1;
        while(l <= r ){
            int m = (l + r)/2;
            if(nums[m] == target){
                int min = m;
                for(int i = m-1; i >= 0; i-- ){
                    if(nums[i] == target){
                        min = i;
                        continue;
                    }
                }
                return min;
            }
            
            if(nums[m] < target){
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        return -1;
    }
    
}