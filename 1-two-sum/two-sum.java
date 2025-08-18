class Solution {
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i =0; i<nums.length; i++)
        {
            int required_num = target - nums[i];
            if(hm.containsKey(required_num))
            {
                return new int[] { hm.get(required_num), i };
            }
            hm.put(nums[i],i);
        }
        return new int[] {};
    }
    // public static void main(String[] agrs)
    // {
    //     int nums[] = {2,7,11,15};
    //     int target = 9;
    //     System.out.println(Arrays.toString(twoSum(nums[], target));
    // }
}