package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /*
    Base cases after sorting:

If array size is < 3, means no triplet would exist from that array. Return empty vector of vectors.
If first element is +ve, that means there is no -ve number by which we can make a 0 triplet sum. Return empty vector of vectors.
Two Pointer Approach:
The basic thinking logic for this is: Fix any one number in sorted array and find the other two numbers after it.
The other two numbers can be easily found using two pointers (as array is sorted) and two numbers should have sum = -1*(fixed number).

Traverse the array and fix a number at every iteration.
If number fixed is +ve, break there because we can't make it zero by searching after it.
If number is getting repeated, ignore the lower loop and continue. This is for unique triplets. We want the last instance of the fixed number,
if it is repeated.
Make two pointers high and low, and initialize sum as 0.
Search between two pointers, just similiar to binary search. Sum = num[i] + num[low] + num[high].
If sum is -ve, means, we need more +ve numbers to make it 0, increament low (low++).
If sum is +ve, means, we need more -ve numbers to make it 0, decreament high (high--).
If sum is 0, that means we have found the required triplet, push it in answer vector.
Now again, to avoid duplicate triplets, we have to navigate to last occurences of num[low] and num[high] respectively.
 Update the low and high with last occurences of low and high.

*/
    public List<List<Integer>> threeSum(int[] A) {
        List<List<Integer>>ans = new ArrayList<>();

        int n = A.length;
        Arrays.sort(A);
        if (n < 3) return ans;
        if (A[0] > 1) return ans;

        for (int i = 0 ; i < n ; i++) {
            if (A[i] > 0) break; //If number fixed is +ve, stop there because we can't make it zero by searching after it.

            if (i > 0 && A[i] == A[i - 1]) continue; // number is repeated, ignore the loop and contiune

            int low = i + 1, high = n - 1, sum = 0;

            while (low < high) {
                sum = A[i] + A[low] + A[high];
                if (sum > 0) high--;

                else if (sum < 0) low++;

                else {
                    List<Integer>curr = new ArrayList<>();
                    curr.add(A[i]);
                    curr.add(A[low]);
                    curr.add(A[high]);
                    ans.add(curr);
                    //Now again, to avoid duplicate triplets, we have to navigate to last occurences of num[low] and num[high] respectively
                    int last_low_occurence = A[low] , last_high_occurence = A[high];
                    while (low < high && A[low] == last_low_occurence) {
                        low++;
                    }
                    while (low < high && A[high] == last_high_occurence) {
                        high--;
                    }

                }
            }
        }
        return ans;

    }
}
