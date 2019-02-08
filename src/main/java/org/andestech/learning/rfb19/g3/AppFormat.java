package org.andestech.learning.rfb19.g3;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AppFormat
{
    public static void main( String[] args )
    {
        // String

        int dd = 123123;
        double data = 1212.232323;

        String str = String.format(new Locale("en-en"),"Value %10d, string: %s, double %7.3f", dd, "Hello!", data);

        System.out.println(str);
        System.out.printf("data=%f", data);

        //---- Date formatters



        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy, hh:mm:ss Z");

        Date today = new Date();

        System.out.println("\n\n" + today);
        System.out.println(sdf.format(today));

        String date = "1948/03/25";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");


        Date date2 = null;
        try {
            date2 = sdf2.parse(date);


        System.out.println(date2);

        // Calendar - исследовать.

        // Decimal formatters

        DecimalFormat df = new DecimalFormat();
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();

        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('_');
        //symbols.
        df.setDecimalFormatSymbols(symbols);


        double dvalue = df.parse("3_111_523,44").doubleValue();


        System.out.println(dvalue);

        //-----------------

        NumberFormat nf = NumberFormat.getNumberInstance(new Locale("ru"));
        double r = nf.parse("123,345").doubleValue();

        System.out.println(r);

        } catch (ParseException ex){ex.printStackTrace();}



    }
}
