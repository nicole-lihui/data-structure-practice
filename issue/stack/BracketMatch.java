package stack;

import java.util.Stack;

public class BracketMatch {

    public static Boolean match(String ex) {
        Stack<Character> st = new Stack<>();
        Character cur;

        for (int i = 0; i < ex.length(); i++) {
            cur = ex.charAt(i);
            if (cur == '(' || cur == '{' || cur == '[') {
                st.push(cur);
            } else if (cur == ')' && st.peek() == '(') {
                st.pop();
            } else if (cur == '}' && st.peek() == '{') {
                st.pop();
            } else if (cur == ']' && st.peek() == '[') {
                st.pop();
            }
        }

        return st.isEmpty() ? true : false;
    }
    
    public static void main(String[] args) {
        String ex = "{[] [)}";
        System.out.println(match(ex) ? "Yes" : "No");
    }
}
