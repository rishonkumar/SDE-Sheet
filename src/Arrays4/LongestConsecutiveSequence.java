package Arrays4;
import java.util.Arrays;
import java.util.HashSet;


//https://leetcode.com/problems/longest-consecutive-sequence/description/
public class LongestConsecutiveSequence {
    //TC - (NLogN)
    public int longestConsecutiveBF(int[] A) {
        if (A.length == 0)
            return 0;
        int maxLen = 1, curr = 1;
        int n = A.length;
        Arrays.sort(A);
        for (int i = 1; i < n; i++) {
            if (A[i] == A[i - 1] + 1) {
                curr++;
            } else if (A[i] != A[i - 1]) {
                curr = 1;
            }
            maxLen = Math.max(maxLen, curr);
        }
        return maxLen;
    }

    /*
     * O(n)
     * Approach:
     * We will first push all are elements in the HashSet.
     * Then we will run a for loop and check for any number(x) if it is the starting
     * number
     * of the consecutive sequence by checking if the HashSet contains (x-1) or not.
     * If ‘x’ is the starting number of the consecutive sequence we will keep
     * searching
     * for the numbers y = x+1, x+2, x+3, ….. And stop at the first ‘y’ which is not
     * present in the HashSet. Using this we can calculate the length of the longest
     * consecutive subsequence.
     */
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> s = new HashSet<Integer>();
        for (int num : nums)
            s.add(num);

        int longestStreak = 0;
        for (int num : nums) {
            if (!s.contains(num - 1)) {
                int currNum = num;
                int currStreak = 1;
                // check next number is present if yes increment currentStreak and move
                // currentNumber
                while (s.contains(currNum + 1)) {
                    currNum++;
                    currStreak++;
                }
                longestStreak = Math.max(longestStreak, currStreak);
            }
        }
        return longestStreak;
    }

}

