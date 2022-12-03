package ArraysHashing;

public class ProductExceptSelf {
        /*

    Approach 1
        [1,2,3,2,5,4]

        Left product - [1,2,6,12,60,240]
        Right product - [240,240,120,40,20,4]

        Now res Array will be
        res[i] = leftProduct[i-1] * rightProduct[i+1]

        [240,120,80,120,48,60]

    */

    /*
        Better Approach
        Using only 1 Array
        Better Approach
            [1,2,2,3,0,1,2]

        Right Array - [0,0,0,0,0,2,2]

        leftProduct = 1,2,4,12,0,0
        res[i] = leftProduct * right[i+1]
            res = [0,0,0,0,24,0,]
            res[n-1] = leftProduct


    */
    public int[] productExceptSelf(int[] A) {
        int n = A.length;
        int[] right = new int[n];
        int product = 1;

        // 1. right product array
        for (int i = n - 1; i >= 0; i--) {
            product *= A[i];
            right[i] = product;
        }

        // 2. make result with maintaining of left product
        product = 1;
        int[] result = new int[n];

        for (int i = 0; i < n - 1; i++) {
            int lp = product;
            int rp = right[i + 1];
            result[i] = lp * rp;

            product *= A[i];
        }
        //fill last element
        result[n - 1] = product;
        return result;
    }
}
