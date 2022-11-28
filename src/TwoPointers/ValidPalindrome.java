package TwoPointers;

//https://leetcode.com/problems/valid-palindrome/description/
public class ValidPalindrome {
    //O(n) time and O(1) space
    public boolean isPalindrome(String s) {

        int n = s.length();
        int i = 0, j = n - 1;

        while (i < j) {
            Character s1 = s.charAt(i);
            Character s2 = s.charAt(j);
            if (!Character.isLetterOrDigit(s1)) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(s2)) {
                j--;
                continue;
            }
            if (Character.toLowerCase(s1) != Character.toLowerCase(s2)) return false;
            i++;
            j--;
        }
        return true;
    }
}
