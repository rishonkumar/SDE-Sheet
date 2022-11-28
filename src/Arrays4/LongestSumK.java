package Arrays4;

import java.util.HashMap;

public class LongestSumK {

    public static int longestSubArrWithSumK_BF(int[] arr, int n, int k) {
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k)// cje
                    maxLength = Math.max(maxLength, (j - i + 1));
            }
        }
        return maxLength;
    }

    public int lenOfLongSubarr(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int sum = 0, maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k)
                maxLen = i + 1; // subArray starts with 0
            int remainingSum = sum - k;
            // check remaining sum there in map
            if (map.containsKey(remainingSum)) {
                // update the length
                if (maxLen < i - map.get(remainingSum))
                    maxLen = i - map.get(remainingSum);
            }
            // add in map the sum and index
            //here we update the index only once
            map.put(sum, map.getOrDefault(sum, i));
        }
        return maxLen;
    }
}
