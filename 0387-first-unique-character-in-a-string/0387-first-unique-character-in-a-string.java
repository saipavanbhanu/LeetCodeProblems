class Solution {
    public int firstUniqChar(String s) {
        int min = Integer.MAX_VALUE;
        for(char ch = 'a'; ch <= 'z'; ch++){
            int first = s.indexOf(ch);
            int last = s.lastIndexOf(ch);
            if(first != -1 && first == last && first < min){
                min = first;
            }
        }
        
        if(min == Integer.MAX_VALUE){
            return -1;
        }
        return min;
    }
}