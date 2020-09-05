package logical;

import java.io.CharArrayReader;
import java.io.IOException;
import java.util.Arrays;

public class arryetest {
    public  static void main(String[] agrs){
        int count=0;
        char[] arr = {'a','b','c','d'};
        CharArrayReader reader = new CharArrayReader(arr);
        char[] charArray = new char[4];



        for(int i=0; i<arr.length; i++)
        try {
            reader.read(charArray);






                System.out.println(Arrays.toString(charArray));

            count ++;

        }


        catch (IOException e) {
            e.printStackTrace();
        }



    }
}
