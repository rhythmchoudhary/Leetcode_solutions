class Solution {
    public long minOperations(int[][] queries) {
        long ans = 0;
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            ans += (getOperations(r) - getOperations(l - 1) + 1) / 2;
        }
        return ans;
    }

    private long getOperations(int n) {
        long res = 0;
        int ops = 0;
        for (long powerOf4 = 1; powerOf4 <= n; powerOf4 *= 4) {
            long l = powerOf4;
            long r = Math.min(n, powerOf4 * 4 - 1);
            ops++;
            res += (r - l + 1) * ops;
        }
        return res;
    }
}
