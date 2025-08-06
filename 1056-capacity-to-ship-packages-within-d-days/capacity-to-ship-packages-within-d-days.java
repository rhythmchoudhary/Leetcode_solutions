class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(weights, days, mid)) {
                ans = mid; 
                high = mid - 1;
            } else {
                low = mid + 1; 
            }
        }

        return ans;
    }

    public boolean isPossible(int[] weights, int D, int capacity) {
        int days = 1;
        int load = 0;

        for (int weight : weights) {
            if (load + weight > capacity) {
                days++;          
                load = weight; 
            } else {
                load += weight;  
            }
        }

        return days <= D;
    }
}
