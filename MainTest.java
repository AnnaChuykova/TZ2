import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class MainTest {

    @Test
    public void _min() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(-1);
        list.add(2);
        list.add(5);
        list.add(0);
        list.add(-9);
        Assert.assertEquals(Main._min(list), -9);
    }

    @Test
    public void _max() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(-1);
        list.add(2);
        list.add(5);
        list.add(0);
        list.add(-9);
        Assert.assertEquals(Main._max(list), 5);
    }

    @Test
    public void _sum() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(-1);
        list.add(2);
        list.add(5);
        list.add(0);
        list.add(-9);
        Assert.assertEquals(Main._sum(list), -3);
    }

    @Test
    public void _mult() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(-1);
        list.add(2);
        list.add(5);
        list.add(0);
        list.add(-9);
        Assert.assertEquals(Main._mult(list), 0);
    }

    @Test
    public void testTime() throws Exception {
        long startTime = System.currentTimeMillis();
        Main.readFileAndUseNumber("C:\\input1.txt");
        long stopTime = System.currentTimeMillis();
        long elapsedTime1 = stopTime - startTime;
        System.out.println("Время программы работы с 100 числами - " + elapsedTime1);
        startTime = System.currentTimeMillis();
        Main.readFileAndUseNumber("C:\\input2.txt");
        stopTime = System.currentTimeMillis();
        long elapsedTime2 = stopTime - startTime;
        System.out.println("Время программы работы с 10000 числами - " + elapsedTime2);
        startTime = System.currentTimeMillis();
        Main.readFileAndUseNumber("C:\\input3.txt");
        stopTime = System.currentTimeMillis();
        long elapsedTime3 = stopTime - startTime;
        System.out.println("Время программы работы с 100000 числами - " + elapsedTime3);
    }

    @Test
    public void testException() throws Exception {
        Assert.assertFalse(Main.readFileAndUseNumber("C:\\abcdef.txt"));
    }
}