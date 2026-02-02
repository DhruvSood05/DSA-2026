import java.util.*;
import Recursion.Hard.*;

public class LetterComboPhnNum {
    private final String[] map;

    public LetterComboPhnNum() {

        map = new String[] {
                "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
    }

    private void combos(int index, String letter, List<String> ans, String digits) {
        if (index == digits.length()) {
            ans.add(letter);
            return;
        }

        String s = map[digits.charAt(index) - '0'];
        for (int i = 0; i < s.length(); i++) {
            combos(index + 1, letter + s.charAt(i), ans, digits);
        }
    }

    public List<String> letterCombinations(String digits) {
        // your code goes here
        List<String> ans = new ArrayList<>();
        combos(0, "", ans, digits);
        return ans;
    }
}