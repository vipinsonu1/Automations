package logical;

import java.util.Scanner;

public class duplicate {

    public static void main(String args[]) {
        String str;
        int leng;
        int count=0;
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the your text");

        str = in.nextLine();
        leng = str.length();
        char[] chars = str.toCharArray();

        for (int i = 0; i < leng - 1; i++)
            for (int j = i + 1; j < str.length(); j++) {

                if (chars[i] == chars[j]) {

                    System.out.println(chars[j]);

                    count ++;

                    break;


                }
            }
    }
}