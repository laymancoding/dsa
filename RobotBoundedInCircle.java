class RobotBoundedInCircle {
    public boolean isRobotBoundedInCircle(String instructions) {
        int a = 0, b = 0;
        int dir = 0; // 0 -> N, 1 -> E, 2 -> S, 3 -> W
        
        int[][] directions = new int[][] { {1,0}, {0, 1}, {-1, 0}, {0, -1} };
        
        for(int i = 0; i < instructions.length(); i++) {
            char ch = instructions.charAt(i);

            if(ch == 'G') {
                a = a + directions[dir][0];
                b = b + directions[dir][1];
            } else if (ch == 'L') {
                dir = (dir == 0) ? 3 : dir - 1;
            } else if (ch == 'R') {
                dir = (dir + 1) % 4;
            }
        }
        
        if(a == 0 && b == 0) {
            return true;
        }
        
        if(dir == 0) {
            return false;
        }
        
        return true;
    }
}
