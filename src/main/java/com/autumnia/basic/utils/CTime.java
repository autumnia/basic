package com.autumnia.basic.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CTime {

    // getCurrentTime( "yyyy-MM-dd HH:mm:ss" )
    public static String getCurrentTime(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat ( pattern );
        Calendar time = Calendar.getInstance();
        String current_time = sdf.format( time.getTime() );
        return current_time;
    }
}
