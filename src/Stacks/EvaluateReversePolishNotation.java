package Stacks;

import java.util.Stack;

//https://leetcode.com/problems/evaluate-reverse-polish-notation/
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {

        Stack<String> st = new Stack<>();

        for (String str : tokens) {

            if (isOperator(str)) {
                int ele2 = Integer.parseInt(st.pop());
                int ele1 = Integer.parseInt(st.pop());

                int ans = 0;

                if (str.equals("*")) ans = ele1 * ele2;

                else if (str.equals("/")) ans = ele1 / ele2;

                else if (str.equals("-")) ans = ele1 - ele2;

                else if (str.equals("+")) ans = ele1 + ele2;
                //we are pushing string so convert it
                st.push(ans + "");
            } else {
                st.push(str);
            }
        }

        return Integer.parseInt(st.peek());
    }

    private boolean isOperator(String str) {
        if (str.equals("*") || str.equals("/") || str.equals("-") || str.equals("+")) return true;
        return false;
    }
}
