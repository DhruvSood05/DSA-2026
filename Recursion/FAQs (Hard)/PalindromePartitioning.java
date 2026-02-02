
import java.util.*;

public class PalindromePartitioning {
    private boolean palindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private void subStrings(int index, List<String> sub, List<List<String>> ans, String s) {
        int n = s.length();
        if (index == n) {
            ans.add(new ArrayList<>(sub));
            return;
        }

        for (int i = index; i < n; i++) {
            if (palindrome(s, index, i)) {
                sub.add(s.substring(index, i + 1));
                subStrings(i + 1, sub, ans, s);
                sub.remove(sub.size() - 1);
            }

        }
    }

    public List<List<String>> partition(String s) {
        // your code goes here
        List<String> sub = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();

        subStrings(0, sub, ans, s);
        return ans;
    }
}
