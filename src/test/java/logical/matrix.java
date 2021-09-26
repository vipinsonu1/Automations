package logical;

import java.util.Scanner;

public class matrix {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter total rows: ");
        int rows=sc.nextInt();
        System.out.println("Enter total coloums: ");
        int cols=sc.nextInt();
        int data[][]=new int[rows][cols];
        System.out.println("please enter the matrix data: ");
        for(int i=0; i<rows;i++){
            for (int j=0; j<cols;j++){
                data[i][j]=sc.nextInt();
            }
        }

        for(int i=0; i<rows;i++){
            for (int j=0; j<cols;j++){
                System.out.print(data[i][j] +" ");
            }
            System.out.println();
        }

    }
}
