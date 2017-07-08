// List<String>   getPermutations(String   word,   int   r):    Write   a   program   to   print   all   permutations   of   length   r,  made   up   of   chars   from   the   given   word.   Note:   r   cannot   be   more   than   length   of   word

 
public class GenerateAllPermutationOfNBits 
{

 public static void main(String[] args)
 {
  permutation("ABC", "", 2);

 }
  
 private static void permutation(String str, String prefix, int lengthOfPermutationString)
 {
     
  if(prefix.length()==lengthOfPermutationString)
  {
   System.out.println(prefix);
  }
  else
  {
   for (int i = 0; i < str.length(); i++)
   {
       
    permutation(str, prefix + str.charAt(i), lengthOfPermutationString);
    
   }
  }
 }
}
  
