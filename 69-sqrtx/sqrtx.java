class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;  // sqrt(0) = 0, sqrt(1) = 1

        int left = 1, right = x / 2;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if ((long)mid * mid == x) {
                return mid;
            } else if ((long)mid * mid < x) {
                ans = mid;  // store last known lower bound
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}