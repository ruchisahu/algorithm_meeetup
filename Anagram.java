//boolean   isAnagram(String   word1,   String   word2):    Given   two   words,   word1   and   word2,   find   if   word1   is   an  anagram   of   word2. 

import java.util.Arrays; 

class Anagram
{
    boolean isAnagram(String word1, String word2)
    {
        if(word1==null || word2==null)
            return false;
        
        if(word1.length()!=word2.length())
            return false;
        
        char[] word1_char = word1.toCharArray();
        char[] word2_char = word2.toCharArray();
        Arrays.sort(word1_char);
        Arrays.sort(word2_char);
       return Arrays.equals(word1_char,word2_char);

    }
    public static void main(String[] args)
    {
       Anagram Anagram=new Anagram();
        String word1="araaabbba";
         String word2="araaabbbaqw";
         System.out.println(Anagram.isAnagram(word1,word2));
    }
}