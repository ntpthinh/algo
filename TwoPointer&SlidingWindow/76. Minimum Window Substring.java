class Solution {
    public String minWindow(String s, String t) {
        int start = 0, end = 0;        
        String res = "";
        int min = Integer.MAX_VALUE;
        
        int totalChar = t.length(), curChar = 0;
        int windowSize = 0;
         Map<Character, Integer> counterMap = new HashMap();
        for(int i = 0; i < t.length(); i++){
            counterMap.put(t.charAt(i), counterMap.getOrDefault(t.charAt(i), 0)+1);
        }

        while(end < s.length()){
            Character cur = s.charAt(end);
            if(counterMap.getOrDefault(cur,0)>0){
                curChar++;
            }
            counterMap.put(cur, counterMap.getOrDefault(cur, 0) - 1);
            while(start<=end && curChar == totalChar){
                windowSize = end - start + 1;
                if(windowSize < min){
                    min = windowSize;
                    res = s.substring(start, end + 1);
                }
                counterMap.put(s.charAt(start), counterMap.get(s.charAt(start)) + 1);
                if(counterMap.get(s.charAt(start))>0)
                    curChar--;
                start++;
            }
            end++;
        }
        return res;
            
    }

}
// class Solution {
//     public String minWindow(String s, String t) {
//         if(s.length() < t.length()) return "";
//         int start = 0, end = 0;
//         String res = s+" ";
//         int totalChar = t.length(), curChar = 0;
//         //find all characters in string t
//         Map<Character, Integer> requiredMap = new HashMap();
//         for(int i = 0; i < t.length(); i++){
//             requiredMap.put(t.charAt(i), requiredMap.getOrDefault(t.charAt(i), 0)+1);
//         }
        
//         Map<Character, Integer> charMap = new HashMap();
//         while(end < s.length()){
//             Character cur = s.charAt(end);
//             if(requiredMap.containsKey(cur)){
//                 charMap.put(cur, charMap.getOrDefault(cur, 0) + 1);
//                 curChar++;
//                 while(curChar >= totalChar && containsAllCharacter(requiredMap, charMap)){
//                     if(end - start + 1 < res.length()){
//                         res = s.substring(start, end + 1);
//                     }
                    
//                     if(charMap.containsKey(s.charAt(start))){
//                         charMap.put(s.charAt(start), charMap.get(s.charAt(start)) - 1);
//                         curChar--;
//                     }                    
//                     start++;

//                 }
//             }
//             end++;
//         }
        
//         return res.length()>s.length()?"":res;
//     }
    
//     public boolean containsAllCharacter(Map<Character, Integer> requiredMap, Map<Character, Integer> charMap){
//         for(Character c : requiredMap.keySet()){
//             if(charMap.getOrDefault(c, 0)<requiredMap.get(c))
//                 return false;
//         }
//         return true;
//     }
// }