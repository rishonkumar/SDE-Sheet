package SlidingWindow;

public class LongestRepeatingCharacterReplacement {
    /*
Add element in freq array
Find the max occurence element in the window
windowlength - maxFreq = no of character to replace
if its greater than k then remove from freq and move the window

*/
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0, res = 0;
        int[] arr = new int[26];
        int max = 0;
        for (int r = 0; r < n; r++) {
            //increase the freq
            arr[s.charAt(r) - 'A']++;
            max = Math.max(max, arr[s.charAt(r) - 'A']);
            // windowlength - maxfrequent character in that window => no of character to replace
            while ((r - l + 1) - max > k) {
                //remove the freq
                arr[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;

    }
}
