import java.util.*;

// 1. there can be duplicated numbers in the list in order to acheive the target
// 

public class CombinationSum {
    public void checkSum(int index, List<Integer> list, int sum, List<List<Integer>> ans, int n, int[] nums) {
        if (sum == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (sum < 0 || index == n) {
            return;
        }
        list.add(nums[index]);
        checkSum(index, list, sum - nums[index], ans, n, nums);
        list.remove(list.size() - 1);
        checkSum(index + 1, list, sum, ans, n, nums);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // your code goes here
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int n = candidates.length;

        checkSum(0, list, target, ans, n, candidates);

        return ans;
    }
}