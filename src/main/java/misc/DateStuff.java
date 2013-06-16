package misc;

import java.text.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Calendar;
import java.util.TreeSet;

// 7-Saturday
// 6-Friday
// 5-Thursday
// 4-Wednesday
// 3-Tuesday
// 2-Monday
// 1-Sunday
public class DateStuff {
    static public void main(String[] args) {
        List<Calendar> listPubSched = new ArrayList<Calendar>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Iterator<Calendar> iterator;
        TreeSet<Calendar> treeSet = new TreeSet<Calendar>();

        Calendar cal = new GregorianCalendar(2012, Calendar.JANUARY, 1);
        for (int i = 31; i > 0; i--) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
            listPubSched.add(new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)));
        }

        // Add only Sunday/Wednesday dates into a sorted TreeSet
        for (Calendar c : listPubSched) {
            if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || c.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
                treeSet.add(c);
            }
        }

        // Iterate through TreeSet comparing current and next days. If a 3-day
        // gap is found, that can only mean that we have a Sun/Wed combo.
        iterator = treeSet.iterator();
        int combos = 0;
        while (iterator.hasNext()) {
            Calendar currentDay = iterator.next();
            Calendar nextDay = treeSet.higher(currentDay);
            if (nextDay != null) {
                if (nextDay.get(Calendar.DAY_OF_WEEK) - currentDay.get(Calendar.DAY_OF_WEEK) == 3) {
                    System.out.println(sdf.format(currentDay.getTime()) + "\t" + sdf.format(nextDay.getTime()));
                    combos++;
                }
            }
        }
        System.out.println("Number of Sunday/Wednesday Combos " + combos);
    }
}
