class Solution {
    public int longestSubstring(String s, int k) {
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            Character ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        
        int n = s.length();
        int l = 0;
        while( l < n && map.get(s.charAt(l)) >= k){
            l++;
        }
        
        if(l >= n-1){
            return l;
        }
        
        int ls1 = longestSubstring(s.substring(0, l), k);
        
        while( l < n && map.get(s.charAt(l)) < k){
            l++;
        }
        
        int ls2 = (l < n) ? longestSubstring(s.substring(l), k) : 0;
        
        return Math.max(ls1, ls2);
    }
}