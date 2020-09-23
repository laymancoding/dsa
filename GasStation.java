class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int st = 0, end = (st + 1) % len;
        int tank = gas[0] - cost[0];
        int count = 1;

        while(count <= (2 * len) && st != end) {
            if(tank < 0) {
                st = end;
                end = (end + 1) % len;

                tank = gas[st] - cost[st];
            } else {
                tank += gas[end] - cost[end];
                end = (end + 1) % len;
            }

            ++count;
        }

        return tank >= 0 && st == end ? st : -1;
    }
}
