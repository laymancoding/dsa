class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        int lowLen = getLen(low), highLen = getLen(high);
        String str = "123456789";
        
        List<Integer> out = new ArrayList<>();
        
        for(int len = lowLen; len <= highLen; len++) {
            for(int j = 0; j <= 9 - len; j++) {
                String sub = str.substring(j, j + len);
                int subNum = Integer.parseInt(sub);
                
                if(subNum >= low && subNum <= high) {
                    out.add(subNum);
                }
            }
        }
        
        return out;
    }
    
    private int getLen(int num) {
        int len = 0;
        
        while(num > 0) {
            len++;
            
            num = num / 10;
        }
        
        return len;
    }
}
