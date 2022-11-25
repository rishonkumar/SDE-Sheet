package Arrays2;

public class DuplicateNumber {

    /*
    Create freq array and increase the index
    If its already filled return it
    TC - O(n) SC - O(n)
*/
    public int findDuplicate(int[] A) {

        int[] freq = new int[A.length + 1];

        for (int i = 0; i < A.length; i++) {
            if (freq[A[i]] == 0) freq[A[i]]++;

            else return A[i];
        }
        return -1;
    }
}
