class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = leftMost(nums, target);
        if(first != -1){
            //System.out.println("first: "+first);
            int second = rightMost(nums, target, first);
            return new int[]{first, second};
        }
        return new int[]{-1,-1};
    }
    
    int rightMost(int [] nums, int target, int minIndex){
        int max = minIndex;
        int l = minIndex, r = nums.length-1;
        while(l <= r){
            int m = (l + r)/2;
            if(nums[m] == target){
                if(m >= max){
                    max = m;
                    l = m + 1;
                    continue;
                }
            }else if(nums[m] < target){
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        return max;
    }
    
    int leftMost(int[] nums, int target){
        int l = 0, r = nums.length-1, min = Integer.MAX_VALUE;
        while(l <= r ){
            int m = (l + r)/2;
            if(nums[m] == target){
                if(m < min){
                    min = m;
                    r = m - 1;
                    continue;
                }
            }else if(nums[m] < target){
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        return ( min == Integer.MAX_VALUE ) ? -1 : min;
    }
    
}