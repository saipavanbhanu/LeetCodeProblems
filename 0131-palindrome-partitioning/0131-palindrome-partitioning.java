class Solution {
    List<List<String>> result;
    List<String> parts;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        parts = new ArrayList<>();
        
        backtrack(0, s);
        
        return result;
    }
    
    void backtrack(int index, String s){
        if(index == s.length()){
            result.add(new ArrayList<>(parts));
            //System.out.println(result);
        }else{
            for(int i = index; i < s.length(); i++){
                String str = s.substring(index, i+1);
                if(isPalindrome(str)){
                    parts.add(str);
                    backtrack(i+1, s);
                    parts.remove(parts.size()-1);
                }
            }            
        }
    }
    
    boolean isPalindrome(String str){
        int l = 0, r = str.length()-1;
        boolean flag = false;
        while(l <= r){
            if(str.charAt(l) == str.charAt(r)){
                flag = true;
            }else{
                flag = false;
                break;
            }
            l++;r--;
        }
        return flag;
    }
    
}