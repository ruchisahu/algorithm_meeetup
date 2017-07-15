class BinaryString
{
 String convert(int n)
{
    String s = "000";
    if(n==0)
        return "000";
    while (n > 0)
    {
        s =  s+( (n % 2 ) == 0 ? "0" : "1");
        n = n / 2;
    }
    return s;
}

public static void main(String[] args)
{
    BinaryString bs= new BinaryString();
      System.out.println(bs.convert(5));
    
}
}
  