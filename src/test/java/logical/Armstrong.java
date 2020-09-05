package logical;

public class Armstrong {
    public static  void main(String[] args)
    {
/*
        int  c=0,a,temp;
        int n;
        Scanner in =new Scanner(Scanner.in);
        System.out.println("Please enter the value Armstrong");
        n = Integer.parseInt(in.nextLine());
                   temp=n;
        while(n>0)

        {

            a=n%10;

            n=n/10;

            c=c+(a*a*a);

        }

        if(temp==c)

        System.out.println("armstrong number");

    else

        System.out.println("Not armstrong number");

    */
    }


    public static class twodarrey {

        public static  void main(String args[])
        {
            int a[][]={{1,2,3},{3,4,5}};
            int b[][]={{1,2,3},{3,4,5}};
            int c[][]=new int [2][3];
            for(int i=0; i<2;i++)
            {
                for (int j=0;j<3;j++)
                {

                     c[i][j]=a[i][j] + b[i][j];

                     System.out.println(c[i][j] + " ");
                }
                System.out.println();

            }



        }
    }
}

