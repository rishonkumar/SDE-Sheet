package Stacks;

import java.util.Stack;

public class DailyTemperatures {
    /*
    TC - O(n) SC - O(n)
    Stack from backward
    Add idx in stack
    If stack is empty,add the index to stack and put 0 in o/p array
    If element corresponding to top idx is smaller, pop element till you get a greater element

 */
    public int[] dailyTemperatures(int[] A) {
        int[] ans = new int[A.length];

        Stack<Integer> st = new Stack<>();
        for (int idx = A.length - 1; idx >= 0; idx--) {
            //popping all the idx with a lower or equal temp than the current index
            while (!st.isEmpty() && A[idx] >= A[st.peek()]) {
                st.pop();
            }
            //if stack still has elements then the warmer temp exists
            if (!st.isEmpty()) {
                ans[idx] = st.peek() - idx;
            }
            //inserting current idx in stack
            st.push(idx);
        }
        return ans;
    }
}
