class Bit
{
 boolean isSETLSB(int n)
{
     if ((n&1)==1)
        return true;
      // n%2   
         return false;
}
 
 boolean isSETMSB(int n)
 {
      long x = n & ((~0 >> 1) ^ (~0));
     if(x==1)
         return true;
         
         return false;
 }
 
 boolean isSETn(int n,int x)
 {
     if ((n & (1 << x)) != 0)
         return true;
     return false;
         

 }

public static void main(String[] args)
{
    Bit bs= new Bit();
      System.out.println(bs.isSETLSB(5));
      
        System.out.println(bs.isSETMSB(5));
        
        System.out.println(bs.isSETn(5,4));
        
    
}
}
  