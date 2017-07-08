// Question: String   getLongestPalindrome(String   word):    Write   a   program   to   print   the   longest   palindrome   in   the   given  string?  
class pal
{
    
      
String getLongestPalindrome(String s)
{
    if (null == s || s.length() == 0) {
        return null;
    }
    if (s.length() == 1) {
        return s;
    }
    int[] maxLengthPalindromic = new int[2];
    for (int index = 0; index < s.length(); index++) {
        findMaxLengthPalindromic(maxLengthPalindromic, s, index - 1, index + 1);
        findMaxLengthPalindromic(maxLengthPalindromic, s, index, index + 1);
    }
    return s.substring(maxLengthPalindromic[0], maxLengthPalindromic[1] + 1);
}
 
private void findMaxLengthPalindromic(int[] maxLengthPalindromic, String s, int min, int max) {
    for (int i = min, j = max; i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j); i--, j++) {
        if (j - i > maxLengthPalindromic[1] - maxLengthPalindromic[0]) {
            maxLengthPalindromic[0] = i;
            maxLengthPalindromic[1] = j;
        }
    }
}
   public static void main(String[] args)
    
    {
      pal pal= new pal();
       String word="araaabbba";
        
        pal.getLongestPalindrome( word);
        System.out.print( pal.getLongestPalindrome( word));
    }
}
