class Solution {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();

        sb.append("*".repeat(phone_number.length() - 4));

        for (int i = phone_number.length() - 4; i < phone_number.length(); i++)
            sb.append(phone_number.charAt(i));

        return sb.toString();
    }
}