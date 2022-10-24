class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0)
            return new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char []ca = new char[26];
            for(int i = 0; i < str.length(); i++){
                ca[str.charAt(i)-'a']++;
            }
            String keyStr = String.valueOf(ca);
            List<String> list = map.getOrDefault(keyStr, new ArrayList<>());
            list.add(str);
            map.put(keyStr, list); 
        }
        return new ArrayList<>(map.values());
    }
}