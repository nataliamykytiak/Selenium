package demo;

import org.testng.annotations.Test;

/**
 * @author Natalia Mykytiak
 */
public class TestNGPriorityDemo {
    @Test
    public void one(){
        System.out.println("inside test1");
    }

    @Test(priority = 1)
    public void two(){
        System.out.println("inside test2");
    }

    @Test(priority = 2)
    public void three(){
        System.out.println("inside test3");
    }


}
