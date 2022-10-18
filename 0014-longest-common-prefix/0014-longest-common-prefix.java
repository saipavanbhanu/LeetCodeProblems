class Solution {
    public String longestCommonPrefix(String[] strs) {
        int min = 0, minLength = strs[0].length();
        for(int i = 1; i < strs.length; i++){
            if(strs[i].length() < minLength){
                min = i;
                minLength = strs[i].length();
            }
        }
        
        for(int len = minLength; len > 0; len--){
            String str = strs[min].substring(0,len);
            boolean flag = true;
            for(int i = 0; i < strs.length; i++){
                if(!strs[i].startsWith(str)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return strs[min].substring(0,len);
            }
        }
        return "";
    }
}