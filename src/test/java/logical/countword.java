package logical;

import java.util.HashMap;

public class countword {
    public static void main (String[] args)
    {
        String str="hello how can i help help you";

        String[] split=str.split(" ");

        HashMap<String, Integer> map = new HashMap();
        for(int i=0; i < split.length  ; i++)
        {
            if (map.containsKey(split[i])) {

                int count = map.get(split[i]);

                map.put(split[i], count + 1);
            }
            else {
                 map.put(split[i], 1);
             }
            }

        System.out.println(map);

        Testarray();
        System.out.println("Largest in given array is " + Testsecond());
    }

    public static class armstrong {

        public  static  void main (String[] args){

            int num,temp, c=0,a;

            temp=1;
            num=temp;

            while (num>0)
            {
                a=num%10;
                num=num/10;

                c=c+a*a*a;
            }
            if(temp==c)
            System.out.println("armstrong number");
            else
                System.out.println("not armstrong number");

        }
    }
    public static void Testarray(){
        int ab[]={10,20,30,50,20};
        int min=ab[0];
        for (int j : ab)
            System.out.println("sfsd"+j);
        int j = 0;
        if (ab[j]>min)
            min =ab[j];


        System.out.println(min);

    }

     static int Testsecond(){
        int arr[]={10,20,30,-50,20};
         int max = arr[0];
         for (int i=1; i<arr.length;i++)
             if (arr[i] > max)
                 max = arr[i];

         return max;

    }

}

