import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // Push opening brackets
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // Check matching for closing brackets
            else {
                if (stack.isEmpty()) return false; // No matching opening
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        // Stack should be empty if valid
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isValid("()"));        // true
        System.out.println(sol.isValid("()[]{}"));    // true
        System.out.println(sol.isValid("(]"));        // false
        System.out.println(sol.isValid("([)]"));      // false
        System.out.println(sol.isValid("{[]}"));      // true
    }
}
