
public class MatrixMedian {
    private int upperBound(int[] arr, int x) {
        int n = arr.length;

        int low = 0;
        int high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private int countSmallest(int[][] arr, int n, int m, int x) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += upperBound(arr[i], x);
        }

        return count;
    }

    public int findMedian(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int required = (n * m) / 2;

        for (int i = 0; i < n; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][m - 1]);

        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int smallerEquals = countSmallest(matrix, n, m, mid);
            if (smallerEquals <= required) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}
