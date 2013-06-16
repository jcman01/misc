package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateFormats {
    public java.util.Date tryParsingDate(String dateStr) {
        String[] formatStrings = {"yyyy-MM-dd-hh:mm", "yyyy-MM-dd"};

        for (String formatString : formatStrings) {
            try {
                return new SimpleDateFormat(formatString).parse(dateStr);
            } catch (ParseException e) {
            }
        }
        return null;
    }

    public XMLGregorianCalendar asXMLGregorianCalendar(java.util.Date date) throws DatatypeConfigurationException {
        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
        if (date == null) {
            return null;
        } else {
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTimeInMillis(date.getTime());
            return datatypeFactory.newXMLGregorianCalendar(gc);
        }
    }
}
