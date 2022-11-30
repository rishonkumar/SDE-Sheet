package TwoPointers;
//https://leetcode.com/problems/container-with-most-water/description/
public class ContainerWithMostWater {
    /*
    TC - O(n2)
    BF - Start l = 0 and r = n - 1
    and try every combinations


*/
    public int maxAreaBF(int[] A) {

        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int area = (j - i) * Math.min(A[i], A[j]);

                res = Math.max(res, area);
            }
        }
        return res;
    }
    /*
    O(n)
    2 pointer l = 0 , r = n - 1
    Why coz we need max width

    */

    public int maxArea(int[] A) {

        int res = 0;
        int l = 0, r = A.length - 1;

        while (l < r) {
            int area = (r - l) * Math.min(A[l], A[r]);
            res = Math.max(res, area);

            if (A[l] < A[r]) l++;

            else r--;
        }

        return res;
    }
}
