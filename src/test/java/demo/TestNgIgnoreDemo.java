package demo;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

/**
 * @author Natalia Mykytiak
 */
public class TestNgIgnoreDemo {
    @Ignore
    @Test
    public void test1(){
        System.out.println("Inside test1");
    }

    @Test
    public void test2(){
        System.out.println("Inside test2");
    }
}
