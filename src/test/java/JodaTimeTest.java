import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-6-29
 * Time: 下午11:39
 * To change this template use File | Settings | File Templates.
 */
public class JodaTimeTest {
    @Test
    public void testMonth() {
        nothing nothing1 = new nothing();
        int result1 = nothing1.getMonth();
        assertEquals(4, result1);
        int result2 = nothing1.changeMonth();
        assertEquals(7, result2);
    }
}
