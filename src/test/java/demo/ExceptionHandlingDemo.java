package demo;

/**
 * @author Natalia Mykytiak
 */
public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        try {
            System.out.println("Hello World");
            int i = 1 / 0;
            System.out.println("Completed");
        }
        catch (Exception exception){
            System.out.println("Inside catch block");
            System.out.println("Message is : " + exception.getMessage());
            System.out.println("Cause is:" + exception.getCause());
            exception.printStackTrace();
        }
        finally {
            System.out.println("Inside finally block");
        }
    }
}
