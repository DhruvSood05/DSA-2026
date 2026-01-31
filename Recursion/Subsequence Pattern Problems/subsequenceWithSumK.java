// 1. generating all subsequences
// 2. taking a sum variable which is k in this. 
// 3. as checking the possibility if we should take it or not : if take it subtract the number from sum else pass on the next index without changing sum
// 4. and when the sum is zero return true ootherwise false

public class subsequenceWithSumK {

    private boolean checkSum(int index, int k, int[] nums, int n) {
        if (k == 0) {
            return true;
        }
        if (k < 0 || index == n) {
            return false;
        }

        boolean path1 = checkSum(index + 1, k - nums[index], nums, n);
        boolean path2 = checkSum(index + 1, k, nums, n);

        return path1 || path2;
    }

    public boolean checkSubsequenceSum(int[] nums, int k) {
        // your code goes here
        int n = nums.length;
        return checkSum(0, k, nums, n);
    }
}