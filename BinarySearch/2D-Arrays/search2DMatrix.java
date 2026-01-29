public class search2DMatrix {
    public boolean searchMatrix(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0, high = (n * m) - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / m;
            int col = mid % m;
            if (mat[row][col] == target) {
                return true;
            } else if (mat[row][col] < target) {
                low = mid + 1;
            }

            else {

                high = mid - 1;
            }
        }
        return false;

    }
}

// --------------Better Approach ------------------
// private boolean binarySearch(int[] arr, int x) {
// int n = arr.length;
// int low = 0, high = n - 1;
// while (low <= high) {
// int mid = (low + high) / 2;
// if (arr[mid] == x)
// return true;
// else if (arr[mid] < x) {
// low = mid + 1;
// } else {
// high = mid - 1;
// }
// }
// return false;

// }

// public boolean searchMatrix(int[][] mat, int target) {
// int n = mat.length;
// int m = mat[0].length;
// for (int i = 0; i < n; i++) {
// if ((mat[i][0] <= target) && (target <= mat[i][m - 1])) {
// return binarySearch(mat[i], target);
// }
// }
// return false;
// }