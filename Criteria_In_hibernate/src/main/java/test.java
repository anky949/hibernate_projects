import org.apache.commons.lang.time.DateUtils;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class test {

    public static void main(String[] args) {

        /*BigDecimal x=new BigDecimal(27.86);
        BigDecimal y=new BigDecimal(30.56);
        if(x.compareTo(y)==-1){
            System.out.println(x +" is less than "+y);
        }
        else {
            System.out.println(x +" is greater than "+y);

        }
        */
        BigDecimal bigDecimal=new BigDecimal(12345.00);
        System.out.println(bigDecimal.negate());

        System.out.println(new Date(1522521000000L));
        /*Date date=new Date();
        System.out.println(date);

        Date result= DateUtils.addMonths(date,-1);
        System.out.println(result);

        final BigDecimal x=new BigDecimal(0);

        x.add(new BigDecimal(5));

        System.out.println(x);
*/
       /* Date date1=new Date();
        System.out.println(date1);


        System.out.println(clearTime(date1).compareTo(clearTime(date)));

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        Date result = cal.getTime();

        System.out.println(result);
*/

       String str="646.88";
       BigDecimal bigDecima1=new BigDecimal(str);
        System.out.println(bigDecimal);
    }

    public static Date getStartDateOfMonth(Date month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(month);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }



        public static Date clearTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
}

