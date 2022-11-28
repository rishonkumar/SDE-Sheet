package Arrays2;

public class CountInversion {
    /*

            NLOGN

            While merging we calculate inversion
            left side is sorted and right side is also sorted

            if(left side > right side) then we calculate Inversion
                whatever is left side of that elements will make pairs will j
        */
    public static void main(String[] args) {

//        mergeSort(A, 0, n - 1);
        System.out.println(count);

    }
    static long count = 0;

    static int[] mergeSort(int[] A, int l, int h) {

        // only one element is present
        // low == high
        // return the element
        if (l == h) {
            int[] ba = new int[1];
            ba[0] = A[l];
            return ba;
        }

        //mid
        int mid = (l + h) / 2;
        int[] left = mergeSort(A, l, mid);
        int[] right = mergeSort(A, mid + 1, h);

        int[] merged = merge2SortedArray(left, right);

        return merged;
    }

    static int[] merge2SortedArray(int[] left, int[] right) {

        int i = 0 , j = 0 , k = 0;
        int[] mergedArray = new int[left.length + right.length];

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                mergedArray[k] = left[i];
                i++;
                k++;
            }
            // we will calculate the inversion
            /*
                [3,4,5,8,9]  [1,2,6]
                 i          j
                 here A[i] > A[j]
                 so whatever on left is greater than j (OBSERVATION COZ elements in i are already increasing)
            */
            else {
                count += (left.length - i);
                mergedArray[k] = right[j];
                k++;
                j++;
            }
        }
        //here only one elements are left so no comparison left just exhaust the array
        while (i < left.length) {
            mergedArray[k] = left[i];
            k++;
            i++;
        }

        while (j < right.length) {
            mergedArray[k] = right[j];
            k++;
            j++;
        }
        return mergedArray;
    }
}
