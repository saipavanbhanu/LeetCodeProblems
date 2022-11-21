class Solution {
    List<List<Integer>> result;
    int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = nums;
        Arrays.sort(this.nums);
        result = new ArrayList<>();
        
        backtrack(0, new ArrayList<>());
        
        return result;
    }
    
    void backtrack(int index, List<Integer> state){
        if(index == nums.length){
            result.add(new ArrayList<>(state));
            return;
        }
        //include index 
        state.add(nums[index]);
        backtrack(index+1, state);
        state.remove(state.size()-1);
        
        //don't include the value at index or after that
        int i = index;
        while(i + 1 < nums.length && nums[i] == nums[i+1])
            i++;
        backtrack(i+1, state);    
    }
    
}