class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String tempSkill : skill_trees) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tempSkill.length(); i++) {
                if (skill.contains(String.valueOf(tempSkill.charAt(i))))
                    sb.append(tempSkill.charAt(i));
            }

            for (int i = skill.length(); i >= sb.length(); i--) {
                String compare = skill.substring(0, i);

                if (compare.equals(sb.toString())) 
                    answer++;

            }
        }
        return answer;
    }
}