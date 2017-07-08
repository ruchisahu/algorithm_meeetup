 //boolean   isSubstring(String   needle,   String   haystack):    Given   HayStack   and   Needle,   find   if   Needle   is   in   the  haystack.  

public class substring
{
  public static int isSubstring(final String haystack, final String needle) {
        if(haystack.isEmpty() || needle.isEmpty())
            return -1;
        if(haystack == null || needle == null)
            return -1;
        int i, j;
        int M = needle.length();
        int N = haystack.length();
        
        for(i = 0, j = 0; i < N && j < M; i++){
            if(haystack.charAt(i) == needle.charAt(j)) 
                j++;
            else{
                i = i - j;
                j = 0;
            }
        }
        if(j == M)
            return i - M;
        else
            return -1;
    }
   
    public static void main(String[] args)
    {
        substring str=new substring();
        
        String haystack = "wwwewabcdoeokepte";
        String needle = "abcd";
        System.out.println(str.isSubstring(haystack, needle));
          
    }
} 
