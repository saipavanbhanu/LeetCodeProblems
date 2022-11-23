class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        result = new ArrayList<>();
        backtrack(0, nums, target, new ArrayList<>());
        return result;
    }
    
    void backtrack(int index, int[] nums, int target, List<Integer> state){
        if(index >= nums.length && target != 0){
            return;
        }
        
        if(target == 0){
            result.add(new ArrayList<>(state));
        }else if(target < 0){
            
        }else{
            //include index
            if(target - nums[index] >= 0){
                state.add(nums[index]);
                backtrack(index+1, nums, target - nums[index], state);
                state.remove(state.size()-1);
            }
            
            //don't include index
            int start = index;
            for( ; start + 1 < nums.length; start++){
                if(nums[start] == nums[start + 1]){
                    continue;
                }else{
                    break;
                }
            }
            backtrack(start+1, nums, target, state);
        }
    }
    
}