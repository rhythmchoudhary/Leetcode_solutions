class Solution {
public void moveZeroes(int[] nums) {
    int lastNonZeroIndex = 0;
    
    // Non-zero elements ko front me lao
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
            nums[lastNonZeroIndex] = nums[i];
            lastNonZeroIndex++;
        }
    }
    
    // Remaining positions ko zero karo
    for (int i = lastNonZeroIndex; i < nums.length; i++) {
        nums[i] = 0;
    }
}

}