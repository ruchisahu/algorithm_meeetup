 //boolean   isRotation(String   word1,   String   word2):    Given   two   words,   word1   and   word2,   find   if   word1   is   a  rotation   of   word2.

class Rotation
{
    boolean isRotating(String word1,String word2)
    {
        if(word1.length()!=word2.length())
            return false;
         if(word1==null || word2==null)
            return false;
         String add=word1 +word1;
         return(add.indexOf(word2)!=-1);
        
         
    }
    public static void main(String[] args)
    {
     Rotation rotation=new Rotation();
        String word1="iruch";
         String word2="ruchi";
         System.out.println(rotation.isRotating(word1,word2));
    }
}