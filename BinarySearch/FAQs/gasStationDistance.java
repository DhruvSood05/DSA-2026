package BinarySearch.FAQs;

import java.util.PriorityQueue;

public class gasStationDistance {
    public double minimiseMaxDistance(int[] arr, int k) {
        int n = arr.length;
        int[] howMany = new int[n - 1];

        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int i = 0; i < n - 1; i++) {
            double dist = arr[i + 1] - arr[i];
            pq.offer(new double[] { dist, i });
        }

        for (int gasStations = 1; gasStations <= k; gasStations++) {
            double[] top = pq.poll();

            int secInd = (int) top[1];
            howMany[secInd]++;

            double initialDist = arr[secInd + 1] - arr[secInd];
            double newSecLen = initialDist / (howMany[secInd] + 1);

            pq.offer(new double[] { newSecLen, secInd });
        }

        return pq.peek()[0];
    }
}
