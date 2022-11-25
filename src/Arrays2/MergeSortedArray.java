package Arrays2;

public class MergeSortedArray {

    public int[] mergeExtraSpace(int[] A, int m, int[] B, int n) {

        int[] ans = new int[m + n];
        int i = 0, j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (A[i] < B[j]) {
                ans[k] = A[i];
                i++;
                k++;
            } else {
                ans[k] = B[j];
                j++;
                k++;
            }
        }

        while (i < m) {
            ans[k] = A[i];
            i++;
            k++;
        }
        while (j < n) {
            ans[k] = B[j];
            j++;
            k++;
        }
        return ans;
    }
/*
Time complexity: O(M+N)
Space complexity: O(1)

As we know both ‘ARR1’ and ‘ARR2’ are sorted.
So we can declare two variables ‘i’ and ‘j’ and initialize ‘i’ with ‘M’ and ‘j’ with ‘N’.
Then we compare the last element of both arrays/lists and we insert the larger element
to the end of the ‘ARR1’. We continue this process while all the elements of ‘ARR2’
are not merged into ‘ARR1’.
*/
    public void merge(int[] arr1, int m, int[] arr2, int n) {

        int i = m - 1;
        int j = n - 1;
        int lastIndex = m + n - 1;

        while (j >= 0) {

            if (i >= 0 && arr1[i] > arr2[j]) {
                arr1[lastIndex] = arr1[i];
                i--;
            } else {

                arr1[lastIndex] = arr2[j];
                j--;
            }

            lastIndex--;
        }

    }
}
