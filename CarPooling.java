class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (t1, t2) -> (t1[1] - t2[1]));
        PriorityQueue<int[]> minPq = new PriorityQueue<>((t1, t2) -> (t1[2] - t2[2]));
        
        int count = 0;
        
        for(int i =0; i < trips.length; i++) {
            int[] trip = trips[i];
            
            while(!minPq.isEmpty() && minPq.peek()[2] <= trip[1]) {
                count = count - minPq.poll()[0];
            }
            
            if(trip[0] > capacity || trip[0] + count > capacity) {
                return false;
            }
            
            minPq.add(trip);
            count = count + trip[0];
        }
        
        return true;
    }
}
