package SlidingWindow;

import java.util.Arrays;
//https://leetcode.com/problems/frequency-of-the-most-frequent-element/
public class FrequencyoftheMostFrequentElement {
    /*
Sort and Sliding Window O(nlogn)
    Why sorting -> we are looking for max no and increase the on of its left and we increase close ones
    L and R we will keep R and we will see wether we can increase L value to
    and it we have k we can Increse the window

    expland while(A[R]*windowLength  <= TotalSum + k)
                A[R]*windowLength -> tell us we want to convert r-1 to l to R
                totalSum + k will tell us we can do it or not

                [1,1,1,2,2,4] k = 2
                L = 0 R = 4
                2*4 < 5 + 2 => (8 < 7) not possible here we are trying to change window to 2
                    Increase left pointer
                L = 1 R = 4
                2*4 <= 6+2 possible so store window length

*/
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0 , r = 0;
        int res = 0;
        long totalSum = 0;

        while (r < nums.length) {
            totalSum += nums[r];
            //while window is not valid increase left and remove the sum
            //else keep increse thing window length from right
            while (((long)nums[r] * (r - l + 1) > totalSum + k)) {
                totalSum -= nums[l];
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}
