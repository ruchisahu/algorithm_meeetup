
    class reverse
    {
        int len;
        public void reverse(String input)
        {
         //   String input="my name is ruchi";
            
            String output=new String();
            output=" ";
            len=input.length();
             System.out.println(len);
            
            int end=len;
            for(int k=len-1;k>0;k--)
            {
                System.out.println("index" +k);
                if(k==input.indexOf(" "))
                {
                    output=output +input.substring(k,end-1);
                    
                   end=k;
                
                }
            }
            
        }
   
    
    public static void main(String[] args)
    {
        string s=new string();
       String input="my name is ruchi";
        
        s.reverse(input);
    }
    }
