package ru.agavrilova;

public class Palindrome {

    public boolean isPalindrome(String value){
       boolean result = false;
       int startIndex = 0;
       int finishIndex = value.length() - 1;
       while (startIndex <= finishIndex) {
           if (value.charAt(startIndex) != value.charAt(finishIndex)){
               result = false;
               break;
           }
           else{
               result = true;
               startIndex++;
               finishIndex--;
           }
       }

       return result;
    }

    private String middlePalindrome(String s, int left, int right) {
        if (left > right) return null;
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public String maxPalindrome(String s) {
        if ((s == null) || (s.isEmpty())) return null;
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            //odd cases like 121
            String palindrome = middlePalindrome(s, i, i);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
            //even cases like 1221
            palindrome = middlePalindrome(s, i, i + 1);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
        }
        return longest;
    }

}
