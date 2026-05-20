package string;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    /* Day 18 - Valid Parentheses
    *
    * 🔹 Approach: Optimal (Stack + Mapping)
    * ----------------------------------------------
    * Idea:
    * - Use stack to track opening brackets
    * - Match closing brackets with latest opening bracket
    *
    * How it works:
    * - Traverse each character
    *
    * - If opening bracket:
    *     → Push into stack
    *
    * - If closing bracket:
    *     → Check top of stack
    *     → If mismatch or stack empty:
    *         → Return false
    *
    * - At end:
    *     → Stack should be empty
    *
    * Time Complexity:
    * - O(n)
    *
    * Space Complexity:
    * - O(n)
    *
    * Why this is optimal:
    * - Single pass traversal
    * - Efficient bracket matching using stack
    */
    public static boolean validParenthesesOptimal(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || stack.peek() != map.get(ch)) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}