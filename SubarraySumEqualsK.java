public class SubarraySumEqualsK {
    public int subarraySumNaiveApproach(int[] nums, int k) {
        int counter = 0;

        for(int i = 0; i < nums.length; i++) {
            int sum = 0;

            for(int j = i; j < nums.length; j++) {
                sum += nums[j];

                if(sum == k) {
                    ++counter;
                }
            }
        }

        return counter;
    }

    public int subarraySumUsingHashMap(int[] nums, int k) {
        int totalSum = 0, counter = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for(int index = 0; index < nums.length; index++) {
            totalSum += nums[index];
            
            counter += map.getOrDefault(totalSum - k, 0);
            
            map.put(totalSum, map.getOrDefault(totalSum, 0) + 1);
        }
        
        return counter;
    }
}
