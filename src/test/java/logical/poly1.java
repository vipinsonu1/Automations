package logical;

public class poly1 {

   // int x;
   // int y;

    public int xyz(int x, int y){

        return(x+y);
    }

    public int xyz(int x, int y, int z){

        return(x+y+z);
    }


    public double xyz(double x, int y, int z){

        return(double)(x+y+z);
    }


    public  static  void main(String args[]){
        poly1 p= new poly1();
       int a =p.xyz(3,3);
       int b= p.xyz(3,3,3);
        double c=p.xyz(3.3,4,5);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);


    }


}
