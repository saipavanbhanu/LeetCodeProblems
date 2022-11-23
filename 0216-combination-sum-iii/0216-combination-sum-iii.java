class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum3(int k, int target) {
        result = new ArrayList<>();
        backtrack(k, target, 1, new ArrayList<>());
        return result;
    }
    
    void backtrack(int k, int target, int no, List<Integer> state){
        if(target == 0 && state.size() == k){
            result.add(new ArrayList<>(state));
            return;
        }else if(target < 0){
            
        }else if(target > 0 && no <= 9){
            //include no
            if(target - no >= 0){
                state.add(no);
                backtrack(k, target-no, no + 1, state);
                state.remove(state.size()-1);
            }
            
            //exclude no
            backtrack(k, target, no + 1, state);
        }
    }
}