class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        final int MOD = 1_000_000_007;
        long[] dp = new long[n + 1];     // dp[i] = new people who learn on day i
        long[] pref = new long[n + 1];   // prefix sums of dp
        dp[1] = 1;
        pref[1] = 1;

        for (int day = 2; day <= n; day++) {
            // sharing window j in [day - forget + 1, day - delay]
            int left = day - forget + 1;
            int right = day - delay;

            if (right >= 1) {
                left = Math.max(left, 1);
                long sum = pref[right] - (left - 1 >= 1 ? pref[left - 1] : 0);
                sum %= MOD;
                if (sum < 0) sum += MOD;
                dp[day] = sum;
            } else {
                dp[day] = 0;
            }

            pref[day] = (pref[day - 1] + dp[day]) % MOD;
        }

        // sum dp[j] for j in [n - forget + 1, n] -> people who haven't forgotten by day n
        int start = Math.max(1, n - forget + 1);
        long ans = (pref[n] - (start - 1 >= 1 ? pref[start - 1] : 0)) % MOD;
        if (ans < 0) ans += MOD;
        return (int) ans;
    }
}
