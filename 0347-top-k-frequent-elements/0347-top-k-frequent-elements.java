class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int no : nums){
            map.put(no, map.getOrDefault(no,0)+1);
        }
        
        Map<Integer, Integer> sortedMap = map.entrySet().stream()
                                        .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                              (e1, e2) -> e1, LinkedHashMap::new));
     
        int[] result = new int[k];
        int count = 0;
        for(Map.Entry<Integer, Integer> e : sortedMap.entrySet()){
            if(count < k){
                result[count++] = e.getKey();
            }else{
                break;    
            }
        }
        
        return result;
    }
}