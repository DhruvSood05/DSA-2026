import java.util.*;

public class Subset_II {
    private void function(int index, List<Integer> list, List<List<Integer>> ans, int[] nums, int n) {
        if (index == n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        function(index + 1, list, ans, nums, n);
        list.remove(list.size() - 1);

        for (int i = index + 1; i < n; i++) {
            if (nums[index] != nums[i]) {
                function(i, list, ans, nums, n);
                return;
            }
        }
        function(n, list, ans, nums, n);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // your code goes here
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        function(0, list, ans, nums, n);
        return ans;
    }
}
