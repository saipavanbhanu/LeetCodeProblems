class Solution {
    static Map<Character, Integer> map; 
    static Map<Character, Integer> positionMap;
    static{
        map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        positionMap = new HashMap<>();
        positionMap.put('I',1);
        positionMap.put('V',2);
        positionMap.put('X',3);
        positionMap.put('L',4);
        positionMap.put('C',5);
        positionMap.put('D',6);
        positionMap.put('M',7);
    }
    public int romanToInt(String s) {   
        int result = 0;
        Character prev = null;
        for(int i = s.length()-1; i >= 0; i--){
            Character ch = s.charAt(i);
            int value = map.get(ch);
            if(prev == null){
                result = value;
                prev = ch;
            }else{
                int prevPosition = positionMap.get(prev);
                int currPosition = positionMap.get(ch);
                if(prevPosition > currPosition){
                    result = result - map.get(ch);    
                }else{
                    result = result + map.get(ch);
                }
                prev = ch;
            }
        }
        return result;
    }
}