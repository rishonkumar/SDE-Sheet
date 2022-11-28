package Arrays1;

public class Sort012 {

    /*
        BF Approach Merge Sort - O(nlogn), O(1)

    */

    /*
    Dutch national algo

    a[0..low-1] => 0
    a[high + 1...] => 2
    a[low - mid-1] => 1

    We will be using these 3 pointers to move around the values.
    The primary goal here is to move 0s to the left and 2s to the
    right of the array and at the same time all the 1s shall be in
    the middle region of the array and hence the array will be sorted.
    */
    public void sortColors(int[] A) {

        int n = A.length, i = 0, j = 0, k = n - 1;

        while (j <= k) {
            if (A[j] == 0) {
                int t = A[i];
                A[i] = A[j];
                A[j] = t;
                i++;
                j++;
            } else if (A[j] == 1) {
                j++;
            } else if (A[j] == 2) {
                int t = A[j];
                A[j] = A[k];
                A[k] = t;
                k--;
            }
        }
    }
}
