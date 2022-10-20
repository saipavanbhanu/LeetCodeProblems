class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        boolean flag = false;
        int i = 0;
        while( i < nums.length-1 ){
            if(nums[i] == nums[i+1]){
                flag = true;
                break;
            }
            i++;
        }
        return flag;
    }
}