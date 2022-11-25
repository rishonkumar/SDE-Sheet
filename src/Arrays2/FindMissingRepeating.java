package Arrays2;

import java.util.Arrays;

public class FindMissingRepeating {
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
            if(temp[i] == 0) {
                missing = i;
            }
        }
        int[] ans = {repeating,missing};

        return ans;
    }
}
