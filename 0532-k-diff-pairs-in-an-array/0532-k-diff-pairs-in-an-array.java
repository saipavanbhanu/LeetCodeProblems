class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        int result = 0;
        for(int key : map.keySet()){
            if( (k > 0 && map.containsKey(key + k)) || ( k == 0 && map.get(key) > 1) )
                result++;
        }
        
        return result;
    }
}