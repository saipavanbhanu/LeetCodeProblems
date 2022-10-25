class Solution {
    public int longestConsecutive(int[] nums) {
        TreeSet<Integer> ts = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            ts.add(nums[i]);
        }
        
        int max = Integer.MIN_VALUE;
        int start = Integer.MIN_VALUE;
        int count = 0;
        for(Integer i : ts){
            
            if(start == Integer.MIN_VALUE){
                start = i;
                count++;
            }else if( i == start + 1){
                count++;
                start = i;
            }else{
                
                count = 1;
                start = i;
            }
            
            
            if(count > max){
                max = count;
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}