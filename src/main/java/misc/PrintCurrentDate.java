package misc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PrintCurrentDate {
    public static void main(String[] args) {
        // Method 1
        Calendar cal = Calendar.getInstance();
        System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(cal.getTime()));

        // Method2
        System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()));
    }
}
