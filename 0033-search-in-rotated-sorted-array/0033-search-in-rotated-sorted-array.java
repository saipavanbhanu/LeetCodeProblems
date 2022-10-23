class Solution {
    public int search(int[] nums, int target) {
        int l = 0, h = nums.length-1;
        while(l <= h && l < nums.length && h < nums.length){
            int m = ( l + h )/2;
            //System.out.println(l+":"+h+":"+m);
            if(nums[m] == target){
                return m;
            }
            if( (nums[l] <= nums[m])){
                if(target >= nums[l] && target <= nums[m])
                    return binarySearch(nums, target, l, m);
                else{
                    l = m + 1;
                    continue;
                }
            }else if(nums[m] <= nums[h]){
                if(target >= nums[m] && target <= nums[h])
                    return binarySearch(nums, target, m, h);
                else{
                    h = m - 1;
                    continue;
                }
            }
        }
        return -1;
    }
    int binarySearch(int[] nums, int target, int l, int h){
        while(l <= h){
            int m = (l + h)/2;
            //System.out.println("bs:"+l+":"+h+":"+m);
            if(nums[m] == target){
                return m;
            }else if(l == h){
                return -1;
            }
            
            if(nums[m] < target){
                l = m + 1;
            }else
                h = m - 1;
        }
        return -1;
    }
    
}