public class ExceptionsInJava {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        try {
            int c = a / b; // Infinity
            System.out.println("Try Block Executed");
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception Occured");
        } finally {
            System.out.println("Finally Block Executed");
        }
    }
}
