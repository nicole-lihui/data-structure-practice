package stack;

import java.util.Stack;

/**
 * StatckDemo
 */
public class DemoStatck {

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(11);
        st.push(22);
        st.push(33);

        System.out.println(st.peek());
        int x = st.pop();
        System.out.println(x);
        x = st.pop();
        System.out.println(x);
        x = st.pop();
        System.out.println(x);
    }
}
