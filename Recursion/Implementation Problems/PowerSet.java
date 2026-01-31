import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    private void backTrack(int index, int n, int[] nums, List<Integer> current, List<List<Integer>> ans) {
        if (index == n) {
            ans.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        backTrack(index + 1, n, nums, current, ans);
        current.remove(current.size() - 1);

        backTrack(index + 1, n, nums, current, ans);
    }

    public List<List<Integer>> powerSet(int[] nums) {
        // your code goes here
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backTrack(0, n, nums, current, ans);

        return ans;

    }
}
