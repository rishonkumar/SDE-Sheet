package Arrays1;

public class MaximumSubarray {

    /*
        Brute Force
        TC - O(n2)
     */
    public int maxSubArrayBF(int[] nums) {
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int currSum = 0;
            for (int j = i; j < nums.length; j++) {
                currSum += nums[j];
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }

    /*
        Kadane Algo
        We will never add -ve previous sum to current Value
    */
    public int maxSubArray(int[] A) {

        int maxSum = A[0], sum = 0;

        for (int i = 0 ; i < A.length ; i++) {

            sum += A[i];
            maxSum = Math.max(maxSum, sum);
            // if sum become -ve make it 0
            if (sum < 0) sum = 0;
        }
        return maxSum;
    }
    // To print Largest Sum Contigous Sub Array
    static void maxSubArraySum(int a[], int size) {
        int max_so_far = Integer.MIN_VALUE,
            max_ending_here = 0, start = 0, end = 0, s = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here += a[i];

            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }

            if (max_ending_here < 0) {
                max_ending_here = 0;
                s = i + 1;
            }
        }
        System.out.println("Maximum contiguous sum is "
                           + max_so_far);
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);
    }

}
