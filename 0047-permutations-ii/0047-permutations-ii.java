class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int no : nums){
            map.put(no, map.getOrDefault(no, 0)+1);
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> state = new ArrayList<>();
        
        dfs(map, result, state, nums);
        
        return result;
    }
    
    void dfs(Map<Integer, Integer> map, List<List<Integer>> result, List<Integer> state, int[] nums){
        if(nums.length == state.size()){
            result.add(new ArrayList<>(state));
            return;
        }
        
        for(Integer key : map.keySet()){
            if(map.get(key) > 0){
                map.put(key, map.get(key)-1);
                state.add(key);
                dfs(map, result, state, nums);
                state.remove(state.size()-1);
                map.put(key, map.get(key)+1);
            }
        }
        
    }
}