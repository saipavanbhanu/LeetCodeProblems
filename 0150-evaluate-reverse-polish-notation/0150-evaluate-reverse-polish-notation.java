class Solution {
    public int evalRPN(String[] ts) {
        Deque<Integer> st = new ArrayDeque<>();
        
        for(int i = 0; i < ts.length; i++){
            try{
                int no = Integer.parseInt(ts[i]);
                st.push(no);
            }catch(Exception e){
                int second = st.pop();
                int first = st.pop();
                int result;
                if("+".equals(ts[i])){
                    result = first + second;
                }else if("-".equals(ts[i])){
                    result = first - second;
                }else if("*".equals(ts[i])){
                    result = first * second;
                }else{
                    result = first / second;
                }
                st.push(result);
            }
        }
        return st.pop();
    }
}