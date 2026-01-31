import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses {
    private void generate(int open, int close, int n, String current, List<String> result) {

        if (open + close == 2 * n && open == close) {
            result.add(current);
            return;
        }

        if (open < n) {
            generate(open + 1, close, n, current + "(", result);
        }

        if (open > close) {
            generate(open, close + 1, n, current + ")", result);
        }
    }

    public List<String> generateParenthesis(int n) {
        // your code goes here
        List<String> result = new ArrayList<>();

        generate(0, 0, n, "", result);
        return result;
    }
}
