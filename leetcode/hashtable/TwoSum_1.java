package hashtable;

class TwoSum_1{
    //使用HashMap保存之前已经遍历过的值
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) return null;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)) return new int[] {i, map.get(complement)};
            map.put(nums[i], i);
        }
        
        return null;
    }
}
