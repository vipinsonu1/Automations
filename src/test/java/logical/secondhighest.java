package logical;

import java.security.PublicKey;

public class secondhighest {
    public  static  void main (String [] args ) {

        int[] arr = {100, 30, 40, 50, 20, 60, 90};

        int largest = 0;
        int secondlargest = 0;
        System.out.println("the given list is:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("\t" + arr[i]);


            if (arr[i] > largest) {
                secondlargest=largest;
                largest=arr[i];

            }
            else if (arr[i]> secondlargest)
            {
                secondlargest=arr[i];
            }
        }
        System.out.println("\n"+"second largest value is:"+ "\t"+secondlargest);
        System.out.println("largest value is:"+ "\t"+largest);

    }

    }

