package SlidingWindow;
//https://leetcode.com/problems/minimum-size-subarray-sum/description/
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] A) {


        if (A == null || A.length == 0) return 0;
        int start = 0, end = 0, sum = 0, minLength = Integer.MAX_VALUE;

        while (end < A.length) {
            // keep a running sum as the end pointer expands your window

            sum += A[end];
            // this while loop will be skipped until your window meets the condition that
            // the running sum is equal or greater than the int 's' passed in. aka the window
            // is valid
            while (sum >= target) {
                // now you want to condense your window to find the minimum window as the
                // problem wants

                // updates the min length
                minLength = Math.min(minLength, end - start + 1);
                sum -= A[start];
                start++;
            }
            end++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
