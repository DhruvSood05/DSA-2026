//Note : if i am looking for an answer in put OR ( || ) condition
//      and if i am counting like this one i put PLUS ( + ) condition

public class countSubsequencewithSumK {
    private int count1(int index, int k, int[] nums, int n) {

        if (k == 0) {
            return 1;
        }
        if (k < 0 || index == n) {
            return 0;
        }

        int path1 = count1(index + 1, k - nums[index], nums, n);
        int path2 = count1(index + 1, k, nums, n);

        return path1 + path2;
    }

    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        // your code goes here
        int n = nums.length;
        return count1(0, k, nums, n);
    }
}
