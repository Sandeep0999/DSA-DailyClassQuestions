class Solution {
    public int lengthOfLongestSubstring(String s) {
    
        Set<Character> set = new HashSet<>();
        if(s.length() == 0) return 0;
        int left = 0, max = 0;
        for(char ch : s.toCharArray()){
            while(set.contains(ch)){
                set.remove(s.charAt(left++));
            }
            set.add(ch);
            max = Math.max(max, set.size());
        }
    return max;
    }
}