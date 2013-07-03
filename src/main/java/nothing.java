import org.joda.time.DateTime;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-6-29
 * Time: 下午10:19
 * To change this template use File | Settings | File Templates.
 */
public class nothing {

    DateTime dt = new DateTime(2005, 4, 26, 12, 0, 0, 0);

    public int getMonth() {
        return dt.getMonthOfYear();
    }

    public int changeMonth() {
        return dt.plusMonths(3).getMonthOfYear();
    }

    public static void main(String[] args) {

        System.out.println(new nothing().getMonth());
        System.out.println(new nothing().changeMonth());

    }
}