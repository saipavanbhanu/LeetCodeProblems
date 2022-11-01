class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strs[i] = Integer.toString(nums[i]);
        }
        Comparator<String> comp = new Comparator<String>(){
		    @Override
		    public int compare(String str1, String str2){
		        String s1 = str1 + str2;
				String s2 = str2 + str1;
				return s2.compareTo(s1); // reverse order here, so we can do append() later
		    }
	     };
        Arrays.sort(strs, comp);
        
        if(strs[0].charAt(0) == '0'){
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str);
        }
        return sb.toString();
    }
}