class Solution {
    public boolean isAnagram(String s, String t) {
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];
        for(int i = 0; i < s.length(); i++){
            hash1[s.charAt(i)-'a']++;
        }
        for(int i = 0; i < t.length(); i++){
            hash2[t.charAt(i)-'a']++;
        }
        boolean flag = true;
        for(int i = 0; i < 26; i++){
            if(hash1[i] != hash2[i]){
                flag = false;
                break;
            }
        }
        return flag;
    }
}