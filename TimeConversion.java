import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeConversion {

    static String timeConversion(String s) {
        String meridianIndicator = s.substring(s.length() - 2);
        String inHour = s.substring(0, s.indexOf(":"));
        String resultHour = inHour;
        if("PM".equalsIgnoreCase(meridianIndicator)) {
          int hour = Integer.parseInt(s.substring(0, s.indexOf(":")));
            if (!inHour.equals("12")) {
                resultHour = String.valueOf(hour + 12);      
            }
          
          String hourToReturn = s.replace(s.substring(0, s.indexOf(":")), resultHour).substring(0, s.length() - 2);
          return hourToReturn;
        } 
        
        if (inHour.equals("12")) {
           resultHour = "00";      
           String hourToReturn = s.replace(s.substring(0, s.indexOf(":")), resultHour).substring(0, s.length() - 2);
            return hourToReturn;
        }
        

        return s.substring(0, s.length() - 2);
        //return LocalTime.parse(s, DateTimeFormatter.ofPattern("hh:mm:ssa")).format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        
        //return s;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}