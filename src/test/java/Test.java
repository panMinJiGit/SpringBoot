import java.util.HashMap;

public class Test {



    public static void main(String[] args)  {


       String str = "&5122jfdh";
       if(str.startsWith("&")){
           str = str.substring(1,str.length());
       }

        System.out.println(str);

    }

}
