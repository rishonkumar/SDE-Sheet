package Arrays1;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
        /*

        Approach
            if j == 0 or j == i print 1
            else a[i][j] = a[i-1][j-1] + a[i-1][j]
        TC - O(numRows2), SC - O(numRows2).

    */


    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || i == j) {
                    list.add(1);
                } else {
                    // get value from answer
                    int a = ans.get(i - 1).get(j - 1);
                    int b = ans.get(i - 1).get(j);
                    list.add(a + b);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
