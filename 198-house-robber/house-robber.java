// class Solution {
//     public int rob(int[] nums) 
//     {
//         return recursion(0, nums); //starting
//     }

//     int recursion(int idx, int[]nums)
//     {
//         // no ghar
//         if (idx >= nums.length)
//         {
//             return 0;
//         }
//         //idx --- current index
//         //choice --- steal or not

//         //steal
//         int path1 = nums[idx] + recursion(idx+2, nums);

//         //not
//         int path2 = 0 + recursion(idx+1,nums);
//          return Math.max(path1, path2);
//     }
// }








class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[n - 1];        
    }
}