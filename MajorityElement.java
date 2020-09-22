class MajorityElement {
    public int majorityElement_Sorting(int[] nums) {
        Arrays.sort(nums);
        
        return nums[nums.length/2];
    }
    
    public int majorityElement_HashMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if(map.get(num) > nums.length/2) {
                return num;
            }
        }
        
        return Integer.MAX_VALUE;
    }
    
    public int majorityElement(int[] nums) {
        Integer maj = null;
        int count = 0;
        
        for(int num: nums) {
            if(maj == null) {
                maj = num;
                count = 1;
            } else if(num == maj) {
                ++count;
            } else {
                --count;
                
                if(count == 0) {
                    maj = null;
                }
            }
        }
        
        return maj;
    }
}
