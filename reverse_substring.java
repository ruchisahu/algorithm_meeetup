
    class reverse1
    {
        int len;
        public void reverse(String input)
        {
          //  String input="my name is ruchi";
            String output=new String();
            output=" ";
            len=input.length();
             System.out.println(len);
             System.out.println("input string=" +input);
            int end=len;
            for(int k=len-1;k>0;k--)
            {
                System.out.println("index" +k);
                if(k==input.indexOf(" "))
                {
                    output=output +input.substring(k,end-1);
                    
                   end=k;
                   System.out.println("string" +output);
                }
            }
            
        }
   
    
    public static void main(String[] args)
    {
        reverse1 s=new reverse1();
        string sentence="my name is ruchi";
        
        s.reverse1(sentence);
    }
    }
