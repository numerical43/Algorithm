class Solution {
    public int solution(String s) {
        char c = s.charAt(0);
        int length = s.length();
	    int num = 0;
	    int diff = 0;
	    int result = 0;
    
	    for (int i = 0; i < length; i++) {
		    if (num == diff) {
			    result++;
			    c = s.charAt(i);
		    }
            
		    if (s.charAt(i) == c) {
                num++;
            } 
            else {
                diff++;
            }
	    }
    
	    return result;
    }
}