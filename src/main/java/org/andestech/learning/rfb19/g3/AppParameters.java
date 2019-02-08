package org.andestech.learning.rfb19.g3;

import java.util.Scanner;


public class AppParameters {

    public static void main(String[] args)
    {

        for(String arg:  args)
        {   if(arg.startsWith("/") || arg.startsWith("-")){
            System.out.println(arg.substring(1));}

        }

        Scanner scanner = new Scanner(System.in);

        Scanner scanner2 = new Scanner("123123;12;34.44;213.3;33");
        scanner2.useDelimiter(";");

        while (scanner2.hasNext())
        {
            System.out.print(scanner2.next() + ", ");
        }

        while (scanner.hasNext())
        {

            String data = scanner.next();
            if(data.equals("end")) break;

            System.out.println(data);
        }



    }

}
