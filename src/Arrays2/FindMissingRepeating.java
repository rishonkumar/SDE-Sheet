package Arrays2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindMissingRepeating {
    // TC - O(N) SC - O(n)
    int[] findTwoElement(int A[], int n) {
        int[] temp = new int[n + 1];

        Arrays.fill(temp, 0);

        for (int i = 0 ; i < n ; i++) {
            temp[A[i]]++;
        }
        int missing = 0 , repeating = 0;
        for (int i = 1 ; i <= n ; i++) {
            if (temp[i] == 2 ) {
                repeating = i;
            }
            if (temp[i] == 0) {
                missing = i;
            }
        }
        int[] ans = {repeating, missing};

        return ans;
    }

    /*

 In this, the elements are mapped to their natural index.
  In this process, if an element is mapped twice, then it is the repeating element.
  And if an element’s mapping is not there, then it is the missing element.
*/
    public static void main(String[] args) {

        int[] arr = { 4, 3, 6, 2, 1, 1 };

        Map<Integer, Boolean> numberMap
                = new HashMap<>();

        int max = arr.length;

        for (Integer i : arr) {

            if (numberMap.get(i) == null) {
                numberMap.put(i, true);
            } else {
                System.out.println("Repeating = " + i);
            }
        }
        for (int i = 1; i <= max; i++) {
            if (numberMap.get(i) == null) {
                System.out.println("Missing = " + i);
            }
        }
    }
}

