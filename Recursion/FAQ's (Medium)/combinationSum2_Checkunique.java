import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum2_Checkunique {
    class Solution {
        private int upperBound(int[] nums, int index) {
            int n = nums.length;
            int low = index;
            int high = n - 1;
            int ans = n;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] != nums[index]) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return ans;
        }

        private void checkUnique(int index, int sum, List<Integer> list, List<List<Integer>> ans, int[] nums, int n) {
            if (sum == 0) {
                ans.add(new ArrayList<>(list));
                return;
            }
            if (sum < 0 || index == n) {
                return;
            }
            list.add(nums[index]);
            checkUnique(index + 1, sum - nums[index], list, ans, nums, n);
            list.remove(list.size() - 1);

            int next = upperBound(nums, index);
            checkUnique(next, sum, list, ans, nums, n);

        }

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            // your code goes here
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            int n = candidates.length;
            Arrays.sort(candidates);

            checkUnique(0, target, list, ans, candidates, n);
            return ans;
        }
    }
}
