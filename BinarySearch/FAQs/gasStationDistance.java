package BinarySearch.FAQs;

import java.util.PriorityQueue;

public class gasStationDistance {
    private int numberOfGasStationsRequired(double dist, int[] arr) {
        int n = arr.length;
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            int numberInBetween = (int) ((arr[i] - arr[i - 1]) / dist);

            if ((arr[i] - arr[i - 1]) == (dist * numberInBetween)) {
                numberInBetween--;
            }

            cnt += numberInBetween;
        }
        return cnt;
    }

    public double minimiseMaxDistance(int[] arr, int k) {
        int n = arr.length;
        double low = 0;
        double high = 0;

        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, arr[i + 1] - arr[i]);
        }

        double diff = 1e-6;
        while (high - low > diff) {
            double mid = (low + high) / 2.0;
            int cnt = numberOfGasStationsRequired(mid, arr);

            if (cnt > k) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return high;
    }

}

// ---------Better Approach-------------
// public double minimiseMaxDistance(int[] arr, int k) {
// int n = arr.length;
// int[] howMany = new int[n - 1];

// PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) ->
// Double.compare(b[0], a[0]));

// for (int i = 0; i < n - 1; i++) {
// double dist = arr[i + 1] - arr[i];
// pq.offer(new double[] { dist, i });
// }

// for (int gasStations = 1; gasStations <= k; gasStations++) {
// double[] top = pq.poll();

// int secInd = (int) top[1];
// howMany[secInd]++;

// double initialDist = arr[secInd + 1] - arr[secInd];
// double newSecLen = initialDist / (howMany[secInd] + 1);

// pq.offer(new double[] { newSecLen, secInd });
// }

// return pq.peek()[0];
// }
