class Solution {
    public int calculate(String s) {
        if( s == null || s.trim().length() == 0 ){
            return 0;
        }
        int len = s.length();
        Deque<Integer> st = new ArrayDeque<>();
        int num = 0;
        char sign = '+';
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if( ch >= '0' && ch <= '9'){
                num = num * 10 + (ch - '0');
            }else if(ch == ' '){
                
            }
            
            if((!Character.isDigit(ch) &&' '!=ch) || i==len-1){
                if(sign == '+'){
                    st.push(num);
                }else if(sign == '-'){
                    st.push(-num);
                }else if(sign == '*'){
                    st.push(st.pop() * num);
                }else{  // sign == /
                    st.push(st.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        
        int result = 0;
        for(Integer i : st){
            result = result + i;
        }
        return result;
    }
}