package logical;

import java.util.Arrays;
import java.util.List;

public class alfabate {

    public static  void main (String[] args )
    {
        String[] arr ={"a","b","c","d","e","f","g","h"};

       // List<String> vowelsList = Arrays.asList(arr);
//         for (int i=0,j=1; i<arr.length && j<arr.length; i++,j++){
//
//             System.out.println(arr[i]+ j);
//
//          }
            for (int i=0; i<arr.length ; i++){
                int j = i;
                System.out.println(arr[i]+ ++j);

            }


    }

}
