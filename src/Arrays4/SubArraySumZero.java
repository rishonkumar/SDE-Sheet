package Arrays4;



import java.util.HashMap;
import java.util.HashSet;

public class SubArraySumZero {

    static boolean isSum(int A[], int n) {

        for (int i = 0; i < n; i++) {
            int currSum = 0;
            for (int j = i; j < n; j++) {
                currSum += A[i];
                if (currSum == 0)
                    return true;
            }
        }
        return false;
    }

    /*
     * Idea is if we have prefix sum repeating we have subArray
     */
    static boolean findSum(int arr[], int n) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (!map.containsKey(sum))
                map.put(sum, i);

            else
                return true;
        }
        return false;
    }

    // O(N) O(N)
    static boolean findSumC(int arr[], int n) {

        HashSet<Integer> map = new HashSet<>();
        int sum = 0;
        // map.add(0);
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (map.contains(sum))
                return true;

            // if you don't want to write map.add(0) at first
            if (sum == 0)
                return true;

            map.add(sum);
        }
        return false;
    }
}
