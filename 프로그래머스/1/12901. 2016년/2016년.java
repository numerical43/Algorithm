import java.util.*;

class Solution {
	 public String solution(int a, int b) {
		 Calendar calendar = Calendar.getInstance(); 
		 calendar.set(2016, a - 1, b);
		 int day = calendar.get(Calendar.DAY_OF_WEEK);
         
		 switch(day) { 
		 	case 1: return "SUN"; 
		 	case 2: return "MON";  
		 	case 3: return "TUE"; 
		 	case 4: return "WED"; 
		 	case 5: return "THU"; 
		 	case 6: return "FRI";
		 	case 7: return "SAT"; 
		 }
         
         return "";
	 }
}
