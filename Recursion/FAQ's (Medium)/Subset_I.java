import java.util.ArrayList;
import java.util.List;

public class Subset_I {
    class Solution {
        private void sumArray(int index, int sum, List<Integer> ans, int[] nums, int n) {
            if (index == n) {
                ans.add(sum);
                return;
            }
            sumArray(index + 1, sum + nums[index], ans, nums, n);
            sumArray(index + 1, sum, ans, nums, n);
        }

        public List<Integer> subsetSums(int[] nums) {
            // your code goes here
            int n = nums.length;
            List<Integer> ans = new ArrayList<>();
            sumArray(0, 0, ans, nums, n);
            return ans;
        }
    }
}
