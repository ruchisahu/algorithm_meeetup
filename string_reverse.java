
    class string
    {
        int len;
        public void reverse(String input)
        {
            //String input = "My name is ruchi";
            String output = "";
           String[] array = input.split(" ");
           for(int i = array.length-1; i >= 0; i--)
           {
               output += array[i];
               if (i != 0)
               {
                   output += " "; 
               }
           }
           System.out.print(output);
           
        }
   
    
    public static void main(String[] args)
    {
        string s=new string();
       String input="my name is ruchi";
        
        s.reverse(input);
    }
    }
