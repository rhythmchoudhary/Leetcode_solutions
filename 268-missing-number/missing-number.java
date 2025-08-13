class Solution {
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int sum= 0;
        for(int i=0;i<nums.length; i++)
        {
            sum = sum + nums[i];
        }
        
        int actualSum = (nums.length) * (nums.length + 1)/2;
        int missNum = actualSum - sum;
        return missNum;
        
    }
    public static void main(String[] args)
    {
        int nums[] = {1,2,3,4,5,6,8};
        int result =  missingNumber(nums);
        System.out.println(result);
       
    }
}