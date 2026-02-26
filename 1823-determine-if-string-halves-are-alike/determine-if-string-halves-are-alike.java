
class Solution {
    public boolean halvesAreAlike(String s) {
        int mid = s.length() / 2;
        int count = 0;
        
        for (int i = 0; i < mid; i++) {
            if (isVowel(s.charAt(i))) count++;
            if (isVowel(s.charAt(i + mid))) count--;
        }
        
        return count == 0;
    }
    
    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || 
               c == 'o' || c == 'u';
    }
}