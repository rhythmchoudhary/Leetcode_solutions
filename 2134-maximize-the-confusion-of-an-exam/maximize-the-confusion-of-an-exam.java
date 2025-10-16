class Solution {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        // Maximum of making all 'T's or all 'F's
        return Math.max(
            maxConsecutive(answerKey, k, 'T'),
            maxConsecutive(answerKey, k, 'F')
        );
    }

    // Helper function: returns max consecutive chars equal to target (c)
    private int maxConsecutive(String s, int k, char c) {
        int si = 0; // start index
        int ans = 0;
        int n = s.length();

        for (int ei = 0; ei < n; ei++) {
            if (s.charAt(ei) != c) {
                k--; // use one flip
            }

            // If flips exceeded, move start pointer
            while (k < 0) {
                if (s.charAt(si) != c) {
                    k++; // regain a flip
                }
                si++;
            }

            ans = Math.max(ans, ei - si + 1);
        }

        return ans;
    }

    // For quick testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        String answerKey = "TTFTTFTT";
        int k = 1;
        int result = sol.maxConsecutiveAnswers(answerKey, k);
        System.out.println(result); // Output: 5
    }
}
