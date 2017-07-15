//Given   two   numbers,   check   if   their   binary   representations   are   anagrams   of   each   other


class binary_anagrams
{
boolean check(int x, int y)
{

return (countOne(x)==countOne(y));

}

public static int countOne(int number){

        int count = 0;
        for(int i =0; i<32; i++){
            if( (number&1) == 1) {
                count++;
            }
            number = number >>> 1;
        }
        return count;
}





public static void main(String[] args)
{
   binary_anagrams b=new binary_anagrams();
   
    //System.out.printf("Number of one's in %d is %d %n", 7, b.countOne(7));
    
  System.out.printf("Number of one in %d= %d\n", 3, countOne(3));

    System.out.println(b.check(7,3));
}
}