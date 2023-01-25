import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String, Integer> hash = new HashMap<>();

        for (String phone : phone_book)
            hash.put(phone, hash.getOrDefault(phone, 0) + 1);

        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                if (hash.containsKey(phone.substring(0, i)))
                    return false;
            }
        }

        return answer;
    }
}