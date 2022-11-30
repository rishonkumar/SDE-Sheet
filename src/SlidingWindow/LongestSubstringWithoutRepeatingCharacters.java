package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LongestSubstringWithoutRepeatingCharacters {
    /*
 O(n2)
 The idea is to use window sliding. Whenever we see repetition
 we remove the previous occurrence and slide the window.

*/
    public int lengthOfLongestSubstringBF(String s) {

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

    /*

    2nd Approach
    TC - O(2n) Worst case both l and r will be visitng a character twice
    SC = O(n)
    Use set
    Start l and r from 0 index
    Add elements in set and keep cal the res (j - i + 1)
    Keep moving right pointer ahead
    If repetions found move the left pointer and remove from set
*/
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            //contains dup remove from left and keep incrementing left
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    /*
        TC - O(n) SC - O(n)
        Here we will reduce left (travel time)
        Character and idx in map

        If already exist in map
            we will move left to prev freq + 1 and update the freq in map
     */
    public int LongestSubstring(String s) {
        int left = 0, right = 0, len = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            // update the left
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }
            map.put(s.charAt(right),right);
            len = Math.max(len,right-left+1);
            right++;
        }

        return len;
    }
}
