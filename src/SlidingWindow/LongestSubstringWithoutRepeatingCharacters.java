package SlidingWindow;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LongestSubstringWithoutRepeatingCharacters {
    /*
 O(n2)
 The idea is to use window sliding. Whenever we see repetition
 we remove the previous occurrence and slide the window.

*/
    public int lengthOfLongestSubstring(String s) {

        int n = s.length(), res = 0;


        for (int i = 0; i < n; i++) {

            boolean[] visited = new boolean[256];

            for (int j = i; j < n; j++) {
                //if already visited then reptition break the loop
                if (visited[s.charAt(j)] == true) break;

                else {
                    res = Math.max(res, j - i + 1);
                    //mark it visited
                    visited[s.charAt(j)] = true;
                }
            }
            // Remove the first character of previous window
            visited[s.charAt(i)] = false;
        }
        return res;

    }
}
