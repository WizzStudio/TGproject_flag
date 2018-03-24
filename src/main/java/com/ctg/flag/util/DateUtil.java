package com.ctg.flag.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Date String2Date(String string){
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        try{
            return format1.parse(string);
        }catch (ParseException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isSameDay(Date d1,Date d2){
        String s1 = new SimpleDateFormat("yyyy-MM-dd").format(d1);
        String s2 = new SimpleDateFormat("yyyy-MM-dd").format(d2);

        if(s1.equals(s2))
            return true;
        else
            return false;
    }
}
