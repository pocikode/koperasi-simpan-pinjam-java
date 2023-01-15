package uas.mvc.utils;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author agus
 */
public class Helpers {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void inputNumeric(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }
    
    public static String formatRupiah(Long number) {
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        return kursIndonesia.format(number);
    }
    
    public static java.util.Date parseDate(String date) {
        try {
            return new java.util.Date(DATE_FORMAT.parse(date).getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static java.sql.Date parseDateSql(String date) {
        try {
            return new java.sql.Date(DATE_FORMAT.parse(date).getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static java.sql.Timestamp parseTimestamp(String timestamp) {
        try {
            return new Timestamp(DATE_TIME_FORMAT.parse(timestamp).getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }
    
    public static java.sql.Date utilDateToSqlDate(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }
    
    public static String dateToString(java.util.Date date) {
        return DATE_TIME_FORMAT.format(date);
    }
}
