import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hash = new HashMap<>();
        for (String par : participant)
            hash.put(par, hash.getOrDefault(par, 0) + 1);

        for (String com : completion)
            hash.put(com, hash.get(com) - 1);

        for (String name : hash.keySet()){
            if (hash.get(name) != 0) 
                answer = name;
        }

        return answer;

    }
}