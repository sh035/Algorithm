import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> store = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            answer[i] = i - store.getOrDefault(c, i + 1);
            store.put(c, i);
        }
        
        return answer;
    }
}