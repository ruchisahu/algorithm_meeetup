// Binary Coded Decimal (BCD), known as packet decimal, is a representation where numbers 0 through 9                                 converted to four­digit binary. The number 25, for example, would have a BCD number of 0010 0101 or                                     00100101. However, in binary, 25 is represented as 11001. Write two functions to convert between BCD                                 and   Decimal. 



class BCD_to_Decimal
{
int  DecToBin(int val)
{
return( ((val/10) << 4) | (val%10) );
}

int BcdToDec(int bcd)
{
    
   System.out.println((bcd>>4)*10) ;
   return( ((bcd >> 4) * 10) + (bcd&0xF) );               //(0xF)=15 
}

/* Divisibility by 3: Write a program to determine if a number is divisible by 3. A number is divisible by 3 if it atisfies   the   following   rules.   
    ? If   it   is   a   single   bit   number,   and   is   0  –    return   true; 
        ? If   it   is   a   single   bit   number,   and   is   1  –    return   false; 
            ? Otherwise, count the number of bits that are set in odd position, and even position. If the  difference   between   these   counts   is   divisible   by   3,   then   the   original   number   is   divisible   by   3. */

 public  boolean Multiple_Three(int n) {
        if(n < 0) n = -n;

        int even = 0;
        int odd = 0;

        while (n != 0) {
            if ((n & 1) == 1) { 
                odd++;
            } 
            n = n>>1;
            if ((n & 1) == 1) {
                even++;
            } 
            n = n>>1;
        }

        return even == odd;
    }   




public static void main(String[] args)
{
   BCD_to_Decimal b=new  BCD_to_Decimal();

   System.out.println(b.Multiple_Three(5));
    
  //   System.out.println(b.BcdToDec(16));
}
}