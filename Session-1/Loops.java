public class Loops {
    public static void main(String[] args) {
        // For loop
        for (int i = 0; i < 5; i++) {
            System.out.println("Number is : " + i);
        }
        // While Loop
        int len = 1;
        // while (true) {
        //     len++;
        //     System.out.println(len);
        // }
        // This will run indefinitely, so we need to break it manually or set a condition
   
        while (len <= 5) {
            System.out.println("Length is : " + len);
            len++;
        }

        // for loop similar to while loop
        int i = 0;
        for(;;i++) {
            if (i >= 5) {
                break; // Break the loop when i reaches 5
            }
            System.out.println("For loop iteration: " + i);
        }
    }
}
