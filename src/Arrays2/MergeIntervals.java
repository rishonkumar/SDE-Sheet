package Arrays2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    /*
    O(NlogN) + O(N) , O(N)
    Sort the array
    Check previous end is greater than current start
    update start and end everytime
    Intuition
    Since we have sorted the intervals, the intervals which will be merging are
    bound to be adjacent. We kept on merging simultaneously as we were traversing
    through the array and when the element was non-overlapping we simply inserted
    the element in our data structure.

    */
    public int[][] merge(int[][] A) {

        List<int[]> res = new ArrayList<>();

        if (A.length == 0 || A == null) return res.toArray(new int[0][]);

        //Sort
        Arrays.sort(A, (a, b) -> a[0] - b[0]);

        int start = A[0][0];
        int end = A[0][1];

        for (int[] i : A) {
            // now check current start is less than prev end then its merging
            if (i[0] <= end) {
                //if yes we will take right max of both intervals
                end = Math.max(end, i[1]);
            }
            //if not we will add to ans and update start and end
            else {
                res.add(new int[] {start, end});
                start = i[0];
                end = i[1];
            }
        }
        //remaining pair
        res.add(new int[] {start, end});
        return res.toArray(new int[0][0]);
    }
}
