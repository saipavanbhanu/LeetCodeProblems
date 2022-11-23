class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(k));
        return result;
    }
    
    void backtrack(int start, int n, int k, List<Integer> state){
        if(state.size() == k){
            result.add(new ArrayList<>(state));
            return;
        }
        for(int i = start; i <= n; i++){
            state.add(i);
            backtrack(i+1, n, k, state);
            state.remove(state.size()-1);
        }
    }
    
}