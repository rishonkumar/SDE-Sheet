package Arrays2;

import java.util.Arrays;

public class DuplicateNumber {
    //O(Nlogn + N)
    static int findDuplicateBF(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return arr[i];
            }
        }
        return 0;
    }
    /*
       Create freq array and increase the index
       If its already filled return it
       TC - O(n) SC - O(n)
       */
    public int findDuplicate(int[] A){

        int[] freq = new int[A.length + 1];

        for (int i = 0; i < A.length; i++) {
            if (freq[A[i]] == 0) freq[A[i]]++;

            else return A[i];
        }
        return -1;
    }
}


    /*


    */
