class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);
        for(int i = 1; i <= n; i++){
            boolean flag3 = (i % 3 == 0);
            boolean flag5 = (i % 5 == 0);
            //System.out.println(flag3+" "+flag5);
            if(flag3 == true && flag5 == true){
                result.add("FizzBuzz");
            }else if(flag3 == true){
                result.add("Fizz");
            }else if(flag5 == true){
                result.add("Buzz");
            }else{
                result.add(""+i);
            }
        }
        return result;
    }
}