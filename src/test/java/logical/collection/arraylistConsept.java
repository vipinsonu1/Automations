package logical.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class arraylistConsept {
    public static void main(String [] args) {
        int arr[] = new int[3];  // static list
        // daynamic arraylist
        //cantain the duplicate value/elemmemt
        // maintain the instertion order
        //allaow to reduce the element fayching becouse eleamt stroign in indexs

        ArrayList arr1 = new ArrayList();
        arr1.add(10);
        arr1.add(20);
        arr1.add("Hello");
        arr1.add(12.34);
        System.out.println(arr1.get(3));
        System.out.println(arr1.size());
        System.out.println("*********************");

        for(int i=0; i<arr1.size();i++){
            System.out.println(arr1.get(i));
        }

ArrayList <Integer>arr2=new ArrayList<Integer>();
        arr2.add(5);
        arr2.add(10);
        arr2.add(20);

     ArrayList <String> arr3=new ArrayList<String>();
        arr3.add("selenium");

       Employee e1=new Employee("vipin",30,98834534);
        Employee e2=new Employee("sonu",23,23234534);
        Employee e3=new Employee("Rmm",34,988345340);

        ArrayList<Employee> arr4= new ArrayList<Employee>();
        arr4.add(e1);
        arr4.add(e2);
        arr4.add(e3);
        Iterator<Employee> it=arr4.iterator();
        while (it.hasNext())
        {
             Employee emp=it.next();
             System.out.println(emp.name);
            System.out.println(emp.age);

            System.out.println(emp.phoneNumber);

        }

    }
}