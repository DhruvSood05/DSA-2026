
public class rowWithMax1s {

    private int lowerBound(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return ans;
    }

    public int rowWithMax1s(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int maxCount = 0;
        int index = -1;

        for (int i = 0; i < n; i++) {
            int count = m - lowerBound(mat[i], 1);
            if (count > maxCount) {
                maxCount = count;
                index = i;
            }

        }
        return index;
    }
}
