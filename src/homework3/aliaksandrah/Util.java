package homework3.aliaksandrah;

import java.sql.Timestamp;
//import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util{
  public static Timestamp convertStringToTimestamp(String str_date) {
//	  System.out.println("Str_date " + str_date);
    try {
      SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
      Date date = sdf.parse(str_date);
//      System.out.println("Date " + date);
//      DateFormat df = DateFormat.getTimeInstance(DateFormat.FULL);
//      System.out.println("Util " + df.format(date));
      java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());
      return timeStampDate;
    } catch (ParseException e) {
      System.out.println("Exception :" + e);
      return null;
    }
  }
}
