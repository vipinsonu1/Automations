package logical;

import java.util.HashMap;

public class countword {
    public static void main (String[] args)
    {
        String str="hello how can i help help you";

        String[] split=str.split(" ");

        HashMap<String, Integer> map = new HashMap();
        for(int i=0; i < split.length -1 ; i++)
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
}
