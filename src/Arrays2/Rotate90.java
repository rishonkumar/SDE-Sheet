package Arrays2;

public class Rotate90 {
    /*
    TC - O(n*n) SC - O(n*n)
    Take the first row of the matrix and put it in the last column of the dummy matrix,
     take the second row of the matrix, and put it in the second last column of the matrix and so.
     */
    public static int[][] rotateBF(int[][] m) {
        int n = m.length;
        int[][] ans = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][n - i - 1] = m[i][j];
            }
        }
        return ans;
    }

    	/*
	TC - O(n2)+O(n2) SC - O(1)
	Transpose
	Reverse every row
	*/

    public void rotate(int[][] M) {
        int n = M.length;
        //transpose only the first half
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int t = M[i][j];
                M[i][j] = M[j][i];
                M[j][i] = t;
            }
        }

        //now reverse each row
        for (int i = 0; i < n; i++) {
            int l = 0;
            int h = M[i].length - 1;

            while (l < h) {
                int t = M[i][l];
                M[i][l] = M[i][h];
                M[i][h] = t;
                l++;
                h--;
            }
        }
    }

    public static void main(String args[]) {
        int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int rotated[][] = rotateBF(arr);
        System.out.println("Rotated Image");
        for (int i = 0; i < rotated.length; i++) {
            for (int j = 0; j < rotated.length; j++) {
                System.out.print(rotated[i][j] + " ");
            }
            System.out.println();
        }

    }

}
