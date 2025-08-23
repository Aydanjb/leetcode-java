public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        char[] chars = s.toLowerCase().toCharArray();

        while (l < r) {
            char charL = chars[l];
            char charR = chars[r];

            while (l < r && !Character.isLetterOrDigit(chars[l])) l++;
            while (l < r && !Character.isLetterOrDigit(chars[r])) r--;

            if (chars[l] != chars[r]) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
