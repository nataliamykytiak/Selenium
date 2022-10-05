package demo;

import listeners.RetryAnalyzer;
import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * @author Natalia Mykytiak
 */
public class TestNGRetryFailedDemo {
    @Test
    public void test1(){
        System.out.println("Inside test1");
    }

    @Test
    public void test2(){
        System.out.println("Inside test2");
        int i = 1/0;
    }

    @Test(retryAnalyzer = listeners.RetryAnalyzer.class)
    public void test3(){
        System.out.println("Inside test3");
        Assert.assertTrue(0>1);
    }
}
