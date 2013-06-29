import org.joda.time.DateTime;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-6-29
 * Time: 下午10:19
 * To change this template use File | Settings | File Templates.
 */
public class nothing {

    public static void main(String[] args) {
        DateTime dt = new DateTime(2005, 3, 26, 12, 0, 0, 0);
        System.out.println(dt.getMonthOfYear());
        System.out.println(dt.plusMonths(3).getMonthOfYear());
    }
}