import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> store = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!store.containsKey(s.charAt(i))) {
                answer[i] = -1;
            } else {
                answer[i] = i - store.get(s.charAt(i));
            }
            store.put(s.charAt(i), i);
        }
        
        return answer;
    }
}