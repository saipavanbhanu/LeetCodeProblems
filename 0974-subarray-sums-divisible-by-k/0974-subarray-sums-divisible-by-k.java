class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0,1);
        for(int no : nums){
            sum = ( sum + no ) % k ;
            if(sum < 0)
                sum = sum + k;
            count = count + map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}