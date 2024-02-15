class Solution {
    public String solution(String phone_number) {
        String sub = phone_number.substring(phone_number.length()-4,phone_number.length());
        String star = "*".repeat(phone_number.length()-4);
        return star + sub;
    }
}