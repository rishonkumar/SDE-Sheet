package ArraysHashing;

import java.util.HashSet;

import javax.swing.border.Border;

public class ValidSudoku {

    /*
     * One iteration
     * TC - O(K
     * k = 81
     * Row = 3, Col = 3
     * Box Index = (row/3)*3+(col/3) = 4
     * 
     * Row = 4 Col = 8
     * Box Index = 5
     * Use HashSet it doesn't contain duplicates
     * 
     * How to store use String
     * "Row+ 4+ 7" "Col + 4 + 7" "Box + 5 + 7" add in hashSet
     */
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                if (!seen.add("row" + i + board[i][j])
                        || !seen.add("column" + j + board[i][j]))
                    return false;

                if (!seen.add("box" + (i / 3) * 3 + j / 3 + board[i][j]))
                    return false;
            }
        }
        return true;
    }
}
