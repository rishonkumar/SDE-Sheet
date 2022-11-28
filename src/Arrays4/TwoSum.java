package Arrays4;

import java.util.HashMap;

//https://leetcode.com/problems/two-sum/
public class TwoSum     {
    public int[] twoSum(int[] A, int target) {
        int n = A.length;
        //value and index
        HashMap<Integer, Integer>map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0 ; i < n ; i++) {
            int currNo = A[i];
            int reqNo = target - currNo;
            if (map.containsKey(reqNo)) {
                ans[0] = i;
                ans[1] = map.get(reqNo);
                return ans;
            }
            map.put(A[i], i);
        }
        return ans;
    }
}
