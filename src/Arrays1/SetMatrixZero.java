package Arrays1;

import java.util.Arrays;

public class SetMatrixZero {
    /*
Create a Dummy array and traverse the array and if any point i get a[i][j] == 0  mark particular
d1[i] and d2[j] == 0

Traverse the original array and d[i] or d[j] == 0 then matrix[i][j] == 0

TC - O(n*m+n*m) SC - O(n*m)

*/
    public void setZeroesBF(int[][] matrix) {

        int r = matrix.length, c = matrix[0].length;

        int[] d1 = new int[r];
        int[] d2 = new int[c];
        Arrays.fill(d1, -1);
        Arrays.fill(d2, -1);

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    //mark entire row and col as 0 in d1 and d2
                    d1[i] = 0;
                    d2[j] = 0;
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (d1[i] == 0 || d2[j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

    }
    /*
    Better Approach
    Make 0th row and col act as dummy array
    edge case make sure you check if 0th row and col already has 0 if yes it true

    traverse from r,c(1,1) if you encounter 1 then mark corresponding dummy(0,0) array 0

    now traverse whole array check [i][o] == 0 and [o][j] == 0
    TC - O(2*(n*m)) SC - O(1)
*/
    public void setZeroes(int[][] matrix) {

        int n = matrix.length , m = matrix[0].length;

        boolean row0 = false, col0 = false;

        //check 0th row and col has zero if yes mark it boolean
        //at the end we have to make sure we have particular row and col 0
        for (int i = 0 ; i < n ; i++) if (matrix[i][0] == 0) col0 = true;

        for (int j = 0 ; j < m ; j++) if (matrix[0][j] == 0) row0 = true;


        for (int i = 1 ; i < n ; i++) {
            for (int j = 1 ; j < m ; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // //check [i][0] has 0 if yes then mark row and col has 0
        // for (int i = 1 ; i < n ; i++) {
        //     if (matrix[i][0] == 0) {
        //         for (int j = 0 ; j < m ; j++) {
        //             matrix[i][j] = 0;
        //         }
        //     }
        // }
        // //check [0][j] has 0 if yes then mark row and col has 0
        // for (int j = 1 ; j < m ; j++) {
        //     if (matrix[0][j] == 0) {
        //         for (int i = 0 ; i < n ; i++) {
        //             matrix[i][j] = 0;
        //         }
        //     }
        // }

        for (int i = 1  ; i < n ; i++) {
            for (int j = 1 ; j < m ; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (row0) {
            for (int j = 0 ; j < m ; j++) matrix[0][j] = 0;
        }

        if (col0) {
            for (int i = 0 ; i < n ; i++) matrix[i][0] = 0;
        }

    }
}
