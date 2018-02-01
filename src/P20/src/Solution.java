import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap<Character, Character>();

        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');


        for (int i = 0;i < s.length();i++) {
            if (map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            }
            else {
                if (stack.isEmpty() || map.get(stack.peek()) != s.charAt(i)) {
                    return false;
                }
                else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}